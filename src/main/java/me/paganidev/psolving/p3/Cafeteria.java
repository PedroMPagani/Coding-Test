package me.paganidev.psolving.p3;

import java.util.Collection;
import java.util.HashMap;

public class Cafeteria {

    private final HashMap<String,Food> cache = new HashMap<>();

    public Cafeteria(){

    }

    public void registerFood(String foodName,int amountOnStorage, FoodType ... types){
        if (cache.containsKey(foodName.toUpperCase())){
            // manager this already exists.
            return;
        }
        Food food = new Food(foodName,amountOnStorage,types);
        cache.put(foodName.toUpperCase(),food);// registers the food
    }

    public void addAmountProduced(String foodName, int amountProduced){
        Food f = cache.get(foodName.toUpperCase());
        if (f == null){
            System.out.println("Food does not exist! List of foodname registered:");
            StringBuilder stringBuilder = new StringBuilder();

            Collection<Food> collection = cache.values();

            int size = collection.size();
            int run = 0;
            for (Food food : collection){
                stringBuilder.append(food.getFoodName());
                if (run < size){
                    stringBuilder.append(", ");
                }
                run++;
            }

            System.out.println(stringBuilder.toString());
            return;
        }
    }

    public void trackFoodInformation(){
        System.out.println(" ------------- REPORT --------------");
        for (Food value : cache.values()) {
            System.out.println("Name of food: " + value.getFoodName());
            System.out.println("Food groups: " + value.getFoodGroups());
            System.out.println("Total amount made: " + value.getTotalProduced());
            System.out.println("Total amount consumed: " + value.getTotalConsumed());
            System.out.println("Total amount left over: " + value.getLeftover());
        }
    }

}