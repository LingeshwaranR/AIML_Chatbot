package com.example.useri.chatbot;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CardFragment extends Fragment {

    private CardView cardView;
    private int[] image={R.drawable.icons8_carrot_480,R.drawable.icons8_apple_480,R.drawable.icons8_lettuce_480,R.drawable.icons8_ingredients_480};


    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        cardView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(getActivity(), "There are no offers available at this time", Toast.LENGTH_LONG).show();
				
			}
		});
        ImageView img=view.findViewById(R.id.imageView);
            img.setImageResource(image[getArguments().getInt("position")]);
        //Button button = (Button)view.findViewById(R.id.button);

//        if(getArguments().getInt("position")==0)
//            img.setImageResource(R.drawable.icons8_carrot_480);
//        else if(getArguments().getInt("position")==1)
//            img.setImageResource(R.drawable.icons8_apple_480);


        
        
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button in Card " + getArguments().getInt("position")
                        + "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
