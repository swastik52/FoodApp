package com.swastik.foodsapp.view.home;

import androidx.annotation.NonNull;

import com.swastik.foodsapp.Utils;
import com.swastik.foodsapp.model.Categories;
import com.swastik.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;


    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getMeals() {
       view.showLoading();
       Call<Meals> mealsCall = Utils.getApi().getMeal();
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call,@NonNull Response<Meals> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    view.setMeal(response.body().getMeals());
                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


    void getCategories() {
        view.showLoading();


        Call<Categories> categoriesCall = Utils.getApi().getCategories();

        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * 30 Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */
                    view.setCategory(response.body().getCategories());
                }
                else {
                   view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
