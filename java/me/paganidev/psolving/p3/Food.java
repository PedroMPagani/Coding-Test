package me.paganidev.psolving.p3;

import java.util.ArrayList;
import java.util.List;

public class Food implements FoodModel {

    private final String foodName;
    private int totalConsumed = 0;
    private int totalProduced = 0;
    private List<FoodType> typesOfFood;

    public Food(String name){
        this.foodName = name;
        this.typesOfFood = new ArrayList<>(); // the food can have meat and vegetables at same time
    }

    public Food(String name,int amount, FoodType ... type){
        this.foodName = name;
        this.typesOfFood = List.of(type);// the food can have meat and vegetables at same time
    }

    @Override
    public int getTotalConsumed(){
        return totalConsumed;
    }

    @Override
    public int getTotalProduced(){
        return totalConsumed;
    }

    @Override
    public int getLeftover(){
        return totalProduced - totalConsumed;
    }

    @Override
    public List<FoodType> getFoodGroups() {
        return typesOfFood;
    }

    @Override
    public String getFoodName(){
        return foodName;
    }

    public void addUnitsProduced(int unit){
        this.totalProduced+=unit;
    }

    public void addUnitsConsumed(int unit){
        this.totalConsumed+=unit;
    }

}