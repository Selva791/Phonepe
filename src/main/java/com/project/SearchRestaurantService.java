package com.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class SearchRestaurantService {

   public void SearchRestaurantService(){

    }
    public List<Restaurant> searchRestaurantForUser(SearchRestaurant searchRestaurant){
       List<Restaurant> restaurantList=new ArrayList<>();
        if(searchRestaurant.getArea()!=null && !searchRestaurant.getArea().equals("")){
            restaurantList.addAll(getRestaurantListBasedArea(searchRestaurant.getArea()));
        }else if(searchRestaurant.getCity()!=null && !searchRestaurant.getCity().equals("")){
            restaurantList.addAll(getRestaurantListBasedCity(searchRestaurant.getCity()));
        } else if(searchRestaurant.getPeopleCount()>0 && searchRestaurant.getTotalCost()!=null){
           // restaurantList.addAll(getRestaurantListBasedCostAndPeople(searchRestaurant.getPeopleCount(),searchRestaurant.getTotalCost()));

        }else if(searchRestaurant.getMealType()!=null &&!searchRestaurant.getMealType().equals("")){
            restaurantList.addAll(getRestaurantListBasedMealType(searchRestaurant.getMealType()));
        }
        return restaurantList;
    }

    class Pair{
       double cost;
       Restaurant restaurant;
        Pair(double cost,Restaurant restaurant){
            this.cost=cost;
            this.restaurant=restaurant;
        }
    }

    public List<Restaurant> getRestaurantListBasedCity(String city){
        List<Restaurant> list=new ArrayList<>();

        for(Restaurant restaurant:Application.getRestaurantList()){
            if(restaurant.getCity().equals(city)){
                list.add(restaurant);
            }
        }
        return list;

    }
    public List<Restaurant> getRestaurantListBasedArea(String area){
        List<Restaurant> list=new ArrayList<>();
        for(Restaurant restaurant:Application.getRestaurantList()){
            if(restaurant.getArea().equals(area)){
                list.add(restaurant);
            }
        }
        return list;
    }
    public List<Restaurant> getRestaurantListBasedMealType(String meal){
        List<Restaurant> list=new ArrayList<>();
        for(Restaurant restaurant:Application.getRestaurantList()){
            for(Cuisine cuisine:restaurant.getCuisineSet()){
                if(cuisine.type.equals(meal)){
                    list.add(restaurant);
                }

            }
        }
        return list;
    }
}
