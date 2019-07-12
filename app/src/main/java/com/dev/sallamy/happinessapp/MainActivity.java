package com.dev.sallamy.happinessapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dev.sallamy.happinessapp.data.GetAsyncCallBack;
import com.dev.sallamy.happinessapp.data.QuoteData;
import com.dev.sallamy.happinessapp.data.QuoteViewPagerAdapter;
import com.dev.sallamy.happinessapp.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdpater;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteViewPagerAdpater = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdpater);

    }


    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();
        new QuoteData().getQuote(new GetAsyncCallBack() {
            @Override
            public void Procesfinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getAuthor()
                    );

                    fragmentList.add(quoteFragment);

                    quoteViewPagerAdpater.notifyDataSetChanged();/// very important!!
            }


            }
        });


        return fragmentList;
    }

}
