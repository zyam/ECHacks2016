package com.example.zy.echacks2016;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tony on 2016-11-05.
 */

public class ProofOfPaymentActivity extends Activity {
    public String mCity;
    public int currentInt;
    public int colors[] = {R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5};
    public int colors2[] = {R.color.color1trans, R.color.color2trans, R.color.color3trans,
            R.color.color4trans, R.color.color5trans};
    public int[] mTransitLogo = {R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.chicago,
            R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.peterborough,
            R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.calgary,
            R.drawable.sf,
            R.drawable.ttc,
            R.drawable.nyc,
            R.drawable.vancouver,
            R.drawable.nyc,
            R.drawable.grt,
            R.drawable.grt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proof_of_payment);
        Intent intent = getIntent();
        mCity = intent.getStringExtra(Constants.CITY_NAME);
        TextView textView = (TextView) findViewById(R.id.change_city_color);
        textView.setText(mCity);
        ImageView image = (ImageView) findViewById(R.id.proof_img);
        image.setImageResource(mTransitLogo[intent.getIntExtra(Constants.CITY_INDEX,-1)]);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInt++;
                if(currentInt >=colors2.length){
                    currentInt = 0;
                }
                view.setBackgroundColor(getColor(colors2[currentInt]));
                TextView top = (TextView) findViewById(R.id.proof_top);
                ImageView img = (ImageView) findViewById(R.id.proof_img);
                TextView bottom = (TextView) findViewById(R.id.proof_bottom);
                top.setBackgroundColor(getColor(colors[currentInt]));
                bottom.setBackgroundColor(getColor(colors[currentInt]));
                img.setBackgroundColor(getColor(colors2[currentInt]));
            }
        });
        currentInt = 0;
    }
}
