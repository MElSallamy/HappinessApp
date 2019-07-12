package com.dev.sallamy.happinessapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        CardView cardView = quoteView.findViewById(R.id.cardView);

        TextView quoteText = quoteView.findViewById(R.id.quoteTextviewId);
        TextView autherText=quoteView.findViewById(R.id.autherTextviewId);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        quoteText.setText(quote);
        autherText.setText("-" + author);



        return quoteView;
    }

    public static final QuoteFragment newInstance ( String quote , String auther ){

        QuoteFragment fragment = new QuoteFragment();

        Bundle bundle =  new Bundle();

        bundle.putString("quote", quote);

        bundle.putString("author", auther);

        fragment.setArguments(bundle);

        return fragment;

    }
}
