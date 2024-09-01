package com.project;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Application {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cuisine cuisine =new Cuisine();
        Cost cost = new Cost();
        cost.setCuisineCost(120.0);
        cost.setTax(10.0);
        cost.setTotalAmount(120.0);
        cuisine.setCost(cost);
        cuisine.setTaste("Sweet");
        Cuisine cuisine1 =new Cuisine();
        Cost cost1 = new Cost();
        cost.setCuisineCost(220.0);
        cost.setTax(10.0);
        cost.setTotalAmount(230.0);
        cuisine1.setCost(cost);
        cuisine1.setTaste("Sweet");
        Cuisine cuisine2 =new Cuisine();
        Cost cost2 = new Cost();
        cost.setCuisineCost(220.0);
        cost.setTax(0.0);
        cost.setTotalAmount(220.0);
        cuisine2.setCost(cost);
        cuisine2.setTaste("Sweet");

        Cuisine cuisine3 =new Cuisine();
        Cost cost3 = new Cost();
        cost.setCuisineCost(120.0);
        cost.setTax(20.0);
        cost.setTotalAmount(130.0);
        cuisine3.setCost(cost);
        cuisine3.setTaste("Sweet");


        Set<Cuisine> cuisineSet =new HashSet<>();
        cuisineSet.add(cuisine1);
        cuisineSet.add(cuisine2);
        cuisineSet.add(cuisine3);
        Set<LocalTime> set=new HashSet<>();
        set.add(LocalTime.of(10,00));
        Restaurant restaurant= new Restaurant("FoodCourt","Banglore","WhiteField",cuisineSet,set,20);
        Restaurant restaurant2= new Restaurant("FastFood","Banglore","MGROAD",cuisineSet,set,20);
        Restaurant restaurant3= new Restaurant("Snack","Banglore","WhiteField",cuisineSet,set,20);
        Restaurant restaurant4= new Restaurant("IndianFood","Mumbai","Beach",cuisineSet,set,20);
        Restaurant restaurant5= new Restaurant("RiceTaste","Chennai","Adyar",cuisineSet,set,20);
        Restaurant restaurant6= new Restaurant("FoodCourtBangalore","Banglore","ElectronicCity",cuisineSet,set,20);
        restaurants=new ArrayList<>();
        restaurants.add(restaurant);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        SearchRestaurantService service=new SearchRestaurantService();
        SearchRestaurant searchRestaurant =new SearchRestaurant();
        searchRestaurant.setCity("Banglore");
        System.out.println(service.searchRestaurantForUser(searchRestaurant));
        SearchRestaurant searchRestaurant1 =new SearchRestaurant();
        searchRestaurant.setArea("Adyar");
        System.out.println(service.searchRestaurantForUser(searchRestaurant1));
        SearchRestaurant searchRestaurant2 =new SearchRestaurant();
        searchRestaurant.setCity("Banglore");
        System.out.println(service.searchRestaurantForUser(searchRestaurant2));
        UserInfo userInfo=new UserInfo("Selva","+919894888245","abc@gmai.com","India");
        BookTable bookTable =new BookTable();
        bookTable.setTable(2);
        bookTable.setPeopleCount(10);
        bookTable.setRestaurant(restaurant6);
        bookTable.setUserInfo(userInfo);
        System.out.println("Booked Table Succesfully "+ bookTable.toString());
        byte[] b= "hello world".getBytes();
        String s=new String(b);
        System.out.println("Converted "+s);
        SecretKey secretKey ;
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        secretKey = keyGen.generateKey();
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);


    }
    static List<Restaurant> restaurants;
    public static List<Restaurant> getRestaurantList() {
        return restaurants;
    }

}
