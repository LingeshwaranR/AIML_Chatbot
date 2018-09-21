package com.example.useri.chatbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asksira.loopingviewpager.LoopingPagerAdapter;

import java.util.ArrayList;

public class DemoInfiniteAdapter extends LoopingPagerAdapter<Integer> {

    private static final int VIEW_TYPE_NORMAL = 100;
    private static final int VIEW_TYPE_SPECIAL = 101;

    public DemoInfiniteAdapter(Context context, ArrayList<Integer> itemList, boolean isInfinite) {
        super(context, itemList, isInfinite);
    }

    @Override
    protected int getItemViewType(int listPosition) {
        return VIEW_TYPE_NORMAL;
    }

    @Override
    protected View inflateView(int viewType, ViewGroup container, int listPosition) {
        return LayoutInflater.from(context).inflate(R.layout.item_viewpager, container, false);
    }

    @Override
    protected void bindView(View convertView, int listPosition, int viewType) {
        if (viewType == VIEW_TYPE_SPECIAL) return;
        convertView.findViewById(R.id.image).setBackgroundColor(context.getResources().getColor(getBackgroundColor(listPosition)));
        ImageView img= convertView.findViewById(R.id.imageView);
        img.setImageResource(getDrawableitem(listPosition));
        TextView description = convertView.findViewById(R.id.description);
        description.setText(String.valueOf(itemList.get(listPosition)));
    }


    private int getBackgroundColor (int number) {
        switch (number) {
            case 0:
                return android.R.color.holo_red_light;
            case 1:
                return android.R.color.holo_orange_light;
            case 2:
                return android.R.color.holo_green_light;
            case 3:
                return android.R.color.holo_blue_light;
            case 4:
                return android.R.color.holo_purple;
            case 5:
                return android.R.color.black;
            default:
                return android.R.color.black;
        }
    }
    private int getDrawableitem (int number) {
        switch (number) {
            case 0:
                return R.drawable.icons8_ingredients_480;
            case 1:
                return R.drawable.icons8_lettuce_480;
            case 2:
                return R.drawable.icons8_carrot_480;
            case 3:
                return R.drawable.icons8_apple_480;
            case 4:
                return R.drawable.icons8_lettuce_480;
            case 5:
                return R.drawable.icons8_milkbottle_480;
            default:
                return R.drawable.icons8_carrot_480;
        }
    }
}
