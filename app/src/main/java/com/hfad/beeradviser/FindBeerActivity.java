package com.hfad.beeradviser;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import static java.lang.String.valueOf;

public class FindBeerActivity extends Activity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner beerColor = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(beerColor.getSelectedItem());
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand: brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);
    }
}
