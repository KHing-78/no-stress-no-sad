package nursing.depression.no_stress_no_sad_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AllMenu extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.allmenu);
        initFont();

        Button back = (Button) findViewById(R.id.backToMainPage);
        back.setOnClickListener(this);
        Button stressButton = (Button)findViewById(R.id.stressButton);
        stressButton.setOnClickListener(this);
        Button sadBut = (Button)findViewById(R.id.sadButton2);
        sadBut.setOnClickListener(this);
        Button contactBut = (Button)findViewById(R.id.contactButton5);
        contactBut.setOnClickListener(this);
        Button youtubeBut = (Button)findViewById(R.id.feelbetterButton6);
        youtubeBut.setOnClickListener(this);
        Button stresstestButton3 = (Button)findViewById(R.id.stresstestButton3);
        stresstestButton3.setOnClickListener(this);
        Button sadtestButton4 = (Button)findViewById(R.id.sadtestButton4);
        sadtestButton4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToMainPage:
                // do your code
                Intent back = new Intent(AllMenu.this, MainActivity.class);
                startActivity(back);
                break;

            case R.id.stressButton:
                // do your code
                Intent stress = new Intent(AllMenu.this, Infomation.class);
                startActivity(stress);
                break;

            case R.id.sadButton2:
                // code for button when user clicks buttonOne.
                Intent intent = new Intent(AllMenu.this, WhatIsSad.class);
                startActivity(intent);
                break;

            case R.id.contactButton5:
                // code for button when user clicks buttonOne.
                Intent contactintent = new Intent(AllMenu.this, Contact.class);
                startActivity(contactintent);
                break;

            case R.id.feelbetterButton6:
                // code for button when user clicks buttonOne.
                Intent youtubeintent = new Intent(AllMenu.this, YouTube.class);
                startActivity(youtubeintent);
                break;

            case R.id.stresstestButton3:
                // code for button when user clicks buttonOne.
                Intent stressTestIntent = new Intent(AllMenu.this, StressTestStart.class);
                startActivity(stressTestIntent);
                break;

            case R.id.sadtestButton4:
                // code for button when user clicks buttonOne.
                Intent depressTestIntent = new Intent(AllMenu.this, DepressTestInit.class);
                startActivity(depressTestIntent);
                break;
            default:
                break;
        }
    }

    private void initFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("assets/font/THSarabunNew")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }


}