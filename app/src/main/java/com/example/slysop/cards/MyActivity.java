package com.example.slysop.cards;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;

public class MyActivity extends Activity {

    private CardUI mCardVView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final RelativeLayout mainView = (RelativeLayout) findViewById(R.id.mainView);

        // init CardView
        mCardVView = (CardUI) findViewById(R.id.cardsview);
        mCardVView.setSwipeable(true);

        CardStack stack2 = new CardStack();
        stack2.setTitle("REGULAR CARDS");
        mCardVView.addStack(stack2);

       mCardVView.addCard(new MyCard("Get the CardsUI View"));
       mCardVView.addCardToLastStack(new MyCard("For Android At"));
       MyCard androidViewsCard = new MyCard("www.wesduff.com");
       androidViewsCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("http://www.wesduff.com/"));
               startActivity(intent);
           }
       });

        androidViewsCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "This is a long click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        mCardVView.addCardToLastStack(androidViewsCard);

        CardStack stackPlay = new CardStack();
        stackPlay.setTitle("GOOGLE PLAY CARDS");
        mCardVView.addStack(stackPlay);

        mCardVView.addCard(new MyCard("Goolge Play Cards"));
        mCardVView.addCardToLastStack(new MyCard("By Androguid and GadgetCheck"));

        mCardVView.addCardToLastStack(new MyPlayCard("Google Play",
                "This card mimics the new Google play cards look", "#33b6ea",
                "#33b6ea", true, false));
        mCardVView
                .addCardToLastStack(new MyPlayCard(
                        "Menu Overflow",
                        "The PlayCards allow you to easily set a menu overflow on your card.\nYou can also declare the left stripe's color in a String, like \"#33B5E5\" for the holo blue color, same for the title color.",
                        "#e00707", "#e00707", false, true));
// add one card
        mCardVView
                .addCard(new MyPlayCard(
                        "Different Colors for Title & Stripe",
                        "You can set any color for the title and any other color for the left stripe",
                        "#f2a400", "#9d36d0", false, false));
        mCardVView
                .addCardToLastStack(new MyPlayCard(
                        "Set Clickable or Not",
                        "You can easily implement an onClickListener on any card, but the last boolean parameter of the PlayCards allow you to toggle the clickable background.",
                        "#4ac925", "#222222", true, true));

        mCardVView.refresh();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
