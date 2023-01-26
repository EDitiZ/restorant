# Restaurant Finder

Welcome to the Restaurant Review App! This app allows users to search for restaurants in their area, view restaurant information, including reviews 
and ratings, and leave their own reviews. Users can also filter restaurants by their average price range, rating, and delivery availability. The app 
is built using Spring Boot and utilizes a MySQL database to store all information. 

In this README, we will cover the steps to set up and run the application, as well as provide information on the REST endpoints and usage examples.



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
    
      Spring Boot 2.7.7
      SpringWeb
      MySQL Connector
      Hibernate
    
    
 ## Database  
 
 
 You can use the provided `restaurant.sql` file to import the database schema.
 
*Make sure to update the username and password fields in application.properties file with your MySQL credentials before running the application.*

    
 ## Endpoints
    
  The following are the available REST endpoints for this project:
  
  Creates a new restaurant
  
    'POST /restaurant/post'
    
   _Returns a list of all restaurants_
   
    'GET /restaurant/post' 
    'GET /restaurant/post/one/{id}' : Returns a specific restaurant by ID
    'GET /restaurant/city/{address}' : Returns a list of all restaurants in a specific City
    'GET /restaurant/type/{type}' : Returns a list of all restaurants by a specific restaurant type
    'GET /restaurant/post/{name}' : Returns a list of all restaurants matching the name
    'GET /restaurant//cityprice/{address}/{sorter}' : Returns a sorted list of restaurants in ascending or descending order based on their prices
    'GET /restaurant//cityrating/{address}/{sorter}' : Returns a sorted list of restaurant in acsending or descending order based on their ratings
    'GET /restaurant//deliveries/{address}' : Returns a list of restaurants that offer delivery in a specific city
    'PUT /restaurant/update/{id}' : Updates an existing restaurant
    'DELETE /restaurant/delete/{id} : Deletes an existing restaurant
    
  //Users Endpoints
  
  //Reviews Endpoints
  
  //Menu Endpoints
    
 ## Examples
    
 ## Notes 
      
      Make sure you configure your application.properties accordingly to your own setup.
  
