# Restaurant Finder

Welcome to the Restaurant Review App! This app allows users to search for restaurants in their area, view restaurant information, including reviews 
and ratings, and leave their own reviews. Users can also filter restaurants by their average price range, rating, and delivery availability. The app 
is built using Spring Boot and utilizes a MySQL database to store all information. 

Libraries and Frameworks used:
- Spring Boot: used as the main framework for building the back-end of the application.
- Hibernate: used as the ORM tool for mapping the entities to the database.
- JUnit: used for unit testing

In this README, we will cover the steps to set up and run the application, as well as provide information on the REST endpoints and usage examples.

## UML Class Diagram

![UML Class Diagram](https://user-images.githubusercontent.com/113714822/215280227-07f20a04-9cf0-461c-8ee3-d7f3b8d9f555.png)




## Setting up the project

### Prerequisites

    Java 19 
    Maven
    MySQL
    
    
  ## Installation
  
   1. Clone the repository 
    
      `git clone https://github.com/EDitiZ/restorant.git`
      
   2. Navigate to the project directory
    
      `cd restorant`
      
   3. Install the dependencies 
    
      `mvn install`
      
   4. Create a new MySQL database and configure the database settings in the 'application.properties' file.
    
   5. Run the application
    
      `mvn spring-boot:run`
      
   6. The application should now be running on 'http://localhost:8080/'
    
    
 ## Depenedencies 
    
      Spring Boot 2.7.8
      SpringWeb
      MySQL Driver
      Spring Data JPA
    
    
 ## Database  
 
 
 You can use the provided `restaurant.sql` file to import the database schema.
 
*Make sure to update the username and password fields in application.properties file with your MySQL credentials before running the application.*

    
 ## Endpoints
    
  The following are the available REST endpoints for the _Restaurant_ Endpoints:
  
  
    'POST /restaurant/post' : Creates a new restaurant 
    'GET /restaurant/post' : Returns a list of all restaurants 
    'GET /restaurant/post/one/{id}' : Returns a specific restaurant by ID
    'GET /restaurant/city/{address}' : Returns a list of all restaurants in a specific City
    'GET /restaurant/type/{type}' : Returns a list of all restaurants by a specific restaurant type
    'GET /restaurant/post/{name}' : Returns a list of all restaurants matching the name
    'GET /restaurant//cityprice/{address}/{sorter}' : Returns a sorted list of restaurants in ascending or descending order based on their prices
    'GET /restaurant//cityrating/{address}/{sorter}' : Returns a sorted list of restaurant in acsending or descending order based on their ratings
    'GET /restaurant//deliveries/{address}' : Returns a list of restaurants that offer delivery in a specific city
    'PUT /restaurant/update/{id}' : Updates an existing restaurant
    'DELETE /restaurant/delete/{id} : Deletes an existing restaurant
    
    
  The following are the available REST endpoints for the _Users_ Endpoints:
  
    'POST /users/post : Creates a new user
    'GET /users/city/{address} : Returns a list of all users in a specific city
    'PUT /users/update/{uid} : Updates an existing user
    'DELETE /users/delete/{uid} : Deletes an existing user
  
  The following are the available REST endpoints for the _Reviews_ Endpoints:
  
    'POST /reviews/post' : Creates a new reviews
    'GET /reviews/post/{rid}' : Returns a list of reviews of a specific restaurant
    'GET /reviews/post/user/{uid}' : Returns a list of reviews by a specific user
    'PUT /reviews/{id}/like/{uid}' : Likes a review from a specific user
    'PUT /reviews/{id}/unlike/{uid} : Unlikes a reviews from a specific user
  
  The following are the available REST endpoints for the _Menu_ Endpoints:
    
    'POST /menu/add/{rid}' : Creates a menu item to a specific restaurant
    'PUT /menu/update/{rid}/{id}' : Updates an existing menu item in a specific restaurant
    'DELETE /menu/delete{rid}/{id}' : Deletes an existing menu item form a specific restaurant
    
    
 ## Examples
 
 ### POST /restaurant/post 
 
 Creates a restaurant.
 
   Example request: 
 
    POST restaurant/post
    {
	"name": "Versus",
	"address": "STRUGA",
	"type": "CASUAL",
	"doDelivery": false
    }
    
 ### POST /user/post 
 
 Creates a user.
 
   Example request: 
 
    {
	"firstName": "Artin",
	"lastName": "Cami",
	"address": "DEBAR",
	"phoneNo": "070969420"
    }
   
   
 ### POST /reviews/post 
 
 Creates a review.
 
   Example request:  

    {
	"rating": 5,
	"text": "Wow very nice restaurant!",
	"uid": 3,      
	"rid": 1      
    }
    
    uid - The users ID.
    rid - The Restaurants ID.
    ID
 
 ### POST /menu/add/{id} 
 
 Creates a menu item for a specific restaurant. id being the restaurants ID.
 
   Example request:
   
    POST /menu/add/1
    {
	"name": "Shishqebap Pule",
	"price": 350,
	"description": "Me Garniture."
    }
 


 ### GET /restaurant/post 
 
 Retrives a list of all restaurants.
 
   Example request: 
 
    GET /restaurant/post
       
   Example response: 
   
    [
	{
		"id": 1,
		"name": "Versus",
		"address": "STRUGA",
		"type": "CASUAL",
		"rating": 5.0,
		"priceRange": "NORMAL",
		"doDelivery": false,
		"menus": [
			{
				"id": 1,
				"name": "Shishqebap Pule",
				"price": 350.0,
				"description": "Me Garniture."
			}
		],
		"reviews": [
			{
				"id": 4,
				"rating": 5,
				"text": "Wow very nice restaurant!",
				"createdAt": "2023-01-27",
				"user": {
					"id": 3,
					"firstName": "Artin",
					"lastName": "Cami",
					"address": "DEBAR",
					"phoneNo": "070969420"
				},
				"likes": 0,
				"likedBy": []
			}
		]
	},
	{
		"id": 2,
		"name": "Adenia",
		"address": "STRUGA",
		"type": "MEXICAN",
		"rating": 0.0,
		"priceRange": "UNKNOWN",
		"doDelivery": false,
		"menus": [],
		"reviews": []
	}
    ]
    
    
 ### GET /restaurant/city/{address}
 
 Retrives a list of all restaurants on a specific city.
 
   Example request: 
 
    GET /restaurant/city/debar
    
   Example Response:
   
    [
	{
		"id": 5,
		"name": "Perla",
		"address": "DEBAR",
		"type": "MEXICAN",
		"rating": 0.0,
		"priceRange": "UNKNOWN",
		"doDelivery": true,
		"menus": [],
		"reviews": []
	}
    ]
    
    
 ### GET /restaurant/cityprice/{address}/{sorter}
 
 Retrives a list of all restaurants on a specific city and sorts it based on the prices. 
    
   Example request:
   
    GET /restaurant/cityprice/struga/asc
    
   Example Response:
   
    [
	{
		"id": 2,
		"name": "Adenia",
		"address": "STRUGA",
		"type": "MEXICAN",
		"rating": 0.0,
		"priceRange": "UNKNOWN",
		"doDelivery": false,
		"menus": [],
		"reviews": []
	},
	{
		"id": 1,
		"name": "Versus",
		"address": "STRUGA",
		"type": "CASUAL",
		"rating": 5.0,
		"priceRange": "NORMAL",
		"doDelivery": false,
		"menus": [
			{
				"id": 1,
				"name": "Shishqebap Pule",
				"price": 350.0,
				"description": "Me Garniture."
			}
		],
		"reviews": [
			{
				"id": 4,
				"rating": 5,
				"text": "Wow very nice restaurant!",
				"createdAt": "2023-01-27",
				"user": {
					"id": 3,
					"firstName": "Artin",
					"lastName": "Cami",
					"address": "DEBAR",
					"phoneNo": "070969420"
				},
				"likes": 0,
				"likedBy": []
			}
		]
	}
    ]
    
    
 ### DELETE /restaurant/delete/{id}
 
 Deletes an existing restaurant. 
    
   Example request:
   
    GET /restaurant/delete/1
    
    
 ### PUT /restaurant/update/{id}
 
 Updates an existing restaurant. 
    
   Example request:
    
    PUT /restaurant/update/2
    
    {
	  "name": "Adenia II",
	  "address": "STRUGA",
	  "type": "CHINESE",
	  "doDelivery": true
    }
    
    
 ### PUT /users/update/{id}
 
 Updates an existing user. 
    
   Example request:
   
    PUT /users/update/3
    
    {
	"firstName": "Endrit",
	"lastName": "Ziba",
	"address": "STRUGA",
	"phoneNo": "070208639"
    }
    
    
 ### DELETE /users/delete/{id}
 
 Deletes an existing user. 
    
   Example request: 
   
    DELETE /users/delete/3
    
    
    
    
    
 ## Notes 
      
      Make sure you configure your application.properties accordingly to your own setup.
  
