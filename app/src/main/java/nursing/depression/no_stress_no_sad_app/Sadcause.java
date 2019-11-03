package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Sadcause extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sadcause);

        Button back = (Button) findViewById(R.id.backToWhat);
        back.setOnClickListener(this);

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToWhat:
                // do your code
                Intent back = new Intent(Sadcause.this, WhatIsSad.class);
                startActivity(back);
                break;

            case R.id.exit:
                // code for button when user clicks buttonOne.
                Intent exitintent = new Intent(Sadcause.this, MainActivity.class);
                startActivity(exitintent);
                break;

            default:
                break;
        }
    }
}

