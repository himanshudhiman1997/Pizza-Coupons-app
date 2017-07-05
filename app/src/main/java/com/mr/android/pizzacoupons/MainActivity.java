package com.mr.android.pizzacoupons;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0, flag6 = 0;
    private AdView mAdView;
    InterstitialAd mInterstitialAd;
    Button dominoes, pizza, papajohn, caesar, smokin, us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        dominoes = (Button) findViewById(R.id.button1);
        pizza = (Button) findViewById(R.id.button2);
        papajohn = (Button) findViewById(R.id.button3);
        caesar = (Button) findViewById(R.id.button4);
        smokin = (Button) findViewById(R.id.button5);
        us = (Button) findViewById(R.id.button6);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                if (flag1 == 1) {
                    buttonclick();
                    flag1 = 0;
                }
                if (flag2 == 1) {
                    buttonclick1();
                    flag2 = 0;

                }
                if (flag3 == 1) {
                    buttonclick2();
                    flag3 = 0;
                }
                if (flag4 == 1) {
                    buttonclick3();
                    flag4 = 0;
                }
                if (flag5 == 1) {
                    buttonclick4();
                    flag5 = 0;
                }
                if (flag6 == 1) {
                    buttonclick5();
                    flag6 = 0;
                }


            }
        });
        requestNewInterstitial();
        dominoes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flag1 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick();
                }
            }
        });
        requestNewInterstitial();
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick1();
                }
            }
        });
        requestNewInterstitial();
        papajohn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag3 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick2();
                }
            }
        });
        requestNewInterstitial();
        caesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick3();
                }
            }
        });
        requestNewInterstitial();
        smokin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag5 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick4();
                }
            }
        });
        requestNewInterstitial();
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag6 = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    buttonclick5();
                }
            }
        });
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void buttonclick() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.grabon.in/dominos-coupons/")));
    }

    private void buttonclick1() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://online.pizzahut.co.in/offer/listing")));
    }


    private void buttonclick2() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.grabon.in/papajohnspizza-coupons/")));
    }

    private void buttonclick3() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupons.com/coupon-codes/littlecaesars.com/?Ver=test&utm_expid=87900937-46.Ac2VYjvURKWv4jzr_jLNxw.1&utm_referrer=https%3A%2F%2Fwww.google.co.in%2F")));
    }

    private void buttonclick4() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.grabon.in/smokinjoes-coupons/")));
    }

    private void buttonclick5() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.grabon.in/uspizza-coupons/")));
    }
}
