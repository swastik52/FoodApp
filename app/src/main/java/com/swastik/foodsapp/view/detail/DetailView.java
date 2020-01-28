/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 7/4/19 6:42 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.swastik.foodsapp.view.detail;

import com.swastik.foodsapp.model.Meals;

import java.util.List;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meals);
    void onErrorLoading(String message);
}
