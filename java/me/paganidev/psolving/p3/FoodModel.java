package me.paganidev.psolving.p3;

import java.util.List;

public interface FoodModel {

    int getTotalConsumed();

    int getTotalProduced();

    int getLeftover();

    List<FoodType> getFoodGroups();

    String getFoodName();
}
