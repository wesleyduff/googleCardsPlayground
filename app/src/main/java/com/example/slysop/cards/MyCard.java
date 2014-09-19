package com.example.slysop.cards;

import android.view.View;
import android.widget.TextView;

import com.fima.cardsui.objects.RecyclableCard;

/**
 * Created by slysop on 9/18/14.
 */
public class MyCard extends RecyclableCard {

    public MyCard(String title){
        super(title);
    }

    @Override
    protected int getCardLayoutId(){
        return R.layout.card_ex;
    }

    @Override
    protected void applyTo(View convertView){
        ((TextView) convertView.findViewById(R.id.title)).setText(title);
    }
}
