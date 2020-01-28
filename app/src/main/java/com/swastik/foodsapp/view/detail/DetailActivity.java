
package com.swastik.foodsapp.view.detail;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;
import com.swastik.foodsapp.R;
import com.swastik.foodsapp.Utils;
import com.swastik.foodsapp.model.Meals;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.swastik.foodsapp.view.home.HomeActivity.EXTRA_DETAIL;

public class DetailActivity extends AppCompatActivity implements DetailView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.mealThumb)
    ImageView mealThumb;
    
    @BindView(R.id.category)
    TextView category;
    
    @BindView(R.id.country)
    TextView country;
    
    @BindView(R.id.instructions)
    TextView instructions;

    @BindView(R.id.ingredient)
    TextView ingredients;
    
    @BindView(R.id.measure)
    TextView measures;
    
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    
    @BindView(R.id.youtube)
    TextView youtube;
    
    @BindView(R.id.source)
    TextView source;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupActionBar();
        
        Intent intent=getIntent();
        String mealName=intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter= new DetailPresenter(this);
        presenter.getMealById(mealName);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setMeals(Meals.Meal meals) {
        Picasso.get().load(meals.getStrMealThumb()).into(mealThumb);
        collapsingToolbarLayout.setTitle(meals.getStrMeal());
        category.setText(meals.getStrCategory());
        country.setText(meals.getStrArea());
        instructions.setText(meals.getStrInstructions());
        setupActionBar();

        //===

        if (!meals.getStrIngredient1().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient1());
        }
        if (!meals.getStrIngredient2().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient2());
        }
        if (!meals.getStrIngredient3().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient3());
        }
        if (!meals.getStrIngredient4().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient4());
        }
        if (!meals.getStrIngredient5().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient5());
        }
        if (!meals.getStrIngredient6().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient6());
        }
        if (!meals.getStrIngredient7().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient7());
        }
        if (!meals.getStrIngredient8().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient8());
        }
        if (!meals.getStrIngredient9().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient9());
        }
        if (!meals.getStrIngredient10().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient10());
        }
        if (!meals.getStrIngredient11().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient11());
        }
        if (!meals.getStrIngredient12().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient12());
        }
        if (!meals.getStrIngredient13().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient13());
        }
        if (!meals.getStrIngredient14().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient14());
        }
        if (!meals.getStrIngredient15().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient15());
        }
        if (!meals.getStrIngredient16().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient16());
        }
        if (!meals.getStrIngredient17().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient17());
        }
        if (!meals.getStrIngredient18().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient18());
        }
        if (!meals.getStrIngredient19().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient19());
        }
        if (!meals.getStrIngredient20().isEmpty()) {
            ingredients.append("\n \u2022 " + meals.getStrIngredient20());
        }

        if (!meals.getStrMeasure1().isEmpty() && !Character.isWhitespace(meals.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure1());
        }
        if (!meals.getStrMeasure2().isEmpty() && !Character.isWhitespace(meals.getStrMeasure2().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure2());
        }
        if (!meals.getStrMeasure3().isEmpty() && !Character.isWhitespace(meals.getStrMeasure3().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure3());
        }
        if (!meals.getStrMeasure4().isEmpty() && !Character.isWhitespace(meals.getStrMeasure4().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure4());
        }
        if (!meals.getStrMeasure5().isEmpty() && !Character.isWhitespace(meals.getStrMeasure5().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure5());
        }
        if (!meals.getStrMeasure6().isEmpty() && !Character.isWhitespace(meals.getStrMeasure6().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure6());
        }
        if (!meals.getStrMeasure7().isEmpty() && !Character.isWhitespace(meals.getStrMeasure7().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure7());
        }
        if (!meals.getStrMeasure8().isEmpty() && !Character.isWhitespace(meals.getStrMeasure8().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure8());
        }
        if (!meals.getStrMeasure9().isEmpty() && !Character.isWhitespace(meals.getStrMeasure9().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure9());
        }
        if (!meals.getStrMeasure10().isEmpty() && !Character.isWhitespace(meals.getStrMeasure10().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure10());
        }
        if (!meals.getStrMeasure11().isEmpty() && !Character.isWhitespace(meals.getStrMeasure11().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure11());
        }
        if (!meals.getStrMeasure12().isEmpty() && !Character.isWhitespace(meals.getStrMeasure12().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure12());
        }
        if (!meals.getStrMeasure13().isEmpty() && !Character.isWhitespace(meals.getStrMeasure13().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure13());
        }
        if (!meals.getStrMeasure14().isEmpty() && !Character.isWhitespace(meals.getStrMeasure14().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure14());
        }
        if (!meals.getStrMeasure15().isEmpty() && !Character.isWhitespace(meals.getStrMeasure15().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure15());
        }
        if (!meals.getStrMeasure16().isEmpty() && !Character.isWhitespace(meals.getStrMeasure16().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure16());
        }
        if (!meals.getStrMeasure17().isEmpty() && !Character.isWhitespace(meals.getStrMeasure17().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure17());
        }
        if (!meals.getStrMeasure18().isEmpty() && !Character.isWhitespace(meals.getStrMeasure18().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure18());
        }
        if (!meals.getStrMeasure19().isEmpty() && !Character.isWhitespace(meals.getStrMeasure19().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure19());
        }
        if (!meals.getStrMeasure20().isEmpty() && !Character.isWhitespace(meals.getStrMeasure20().charAt(0))) {
            measures.append("\n : " + meals.getStrMeasure20());
        }


        youtube.setOnClickListener(v -> {
            Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
            intentYoutube.setData(Uri.parse(meals.getStrYoutube()));
            startActivity(intentYoutube);
        });

        source.setOnClickListener(v -> {
            Intent intentSource = new Intent(Intent.ACTION_VIEW);
            intentSource.setData(Uri.parse(meals.getStrSource()));
            startActivity(intentSource);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Error",message);
    }
}
