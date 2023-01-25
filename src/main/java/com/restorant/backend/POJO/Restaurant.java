package com.restorant.backend.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Address address;

    @Enumerated(EnumType.STRING)
    private RestaurantType type;
    private double rating;

    @Column(name = "price_range")
    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

    @Column(name = "do_deliveries")
    private boolean doDelivery;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Menu> menus;

    @ElementCollection
    @CollectionTable(name = "restaurant_ratings", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "rating")
    @JsonIgnore
    private List<Integer> ratings;

    @OneToMany(mappedBy = "restaurant")
    protected List<Review> reviews;

    @Column(name = "average_price")
    @JsonIgnore
    private double averagePrice;

    @ElementCollection
    @JsonIgnore
    private List<Double> prices;




    public Restaurant() {
    }

    public Restaurant(String name, Address address, RestaurantType type, boolean doDelivery) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.rating = 0;
        this.averagePrice = 0;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.priceRange = PriceRange.UNKNOWN;
        this.doDelivery = doDelivery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public RestaurantType getType() {
        return type;
    }

    public void setType(RestaurantType type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public boolean isDoDelivery() {
        return doDelivery;
    }

    public void setDoDelivery(boolean doDelivery) {
        this.doDelivery = doDelivery;
    }

    public void addRating(int rating){
        this.ratings.add(rating);
        totalRating();
    }

    public void totalRating(){
        double Sum = 0;
        for (Integer rating:ratings){
            Sum += rating;
        }

        double rate = Sum / ratings.size();
        setRating(rate);
    }

    public void addPrice(double price){
        this.prices.add(price);
        averagePraceCalculation();
    }

    public void removePrice(double price){
        this.prices.remove(price);
        averagePraceCalculation();
    }

    public void averagePraceCalculation(){

        if(prices == null || prices.isEmpty()){
            setAveragePrice(0);
            setPriceRange(PriceRange.UNKNOWN);
            return;
        }

        double sum = 0;
        for (Double doubles: prices){
            sum += doubles;
        }

        double average = sum / prices.size();
        setAveragePrice(average);

        if (average<300)
            setPriceRange(PriceRange.CHEAP);
        else if (average>=300 && average<600) {
            setPriceRange(PriceRange.NORMAL);
        } else if (average>=600 && average<900) {
            setPriceRange(PriceRange.MODERATE);
        }
        else setPriceRange(PriceRange.EXPENSIVE);
    }



}
