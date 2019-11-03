package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class WhatIsSad extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.whatissad);

        Button back = (Button) findViewById(R.id.backToMainPage);
        back.setOnClickListener(this);

        Button meaningBut = (Button) findViewById(R.id.meaning);
        meaningBut.setOnClickListener(this);

        Button  sadcause = (Button) findViewById(R.id.sadcause);
        sadcause.setOnClickListener(this);

        Button  sadeffect = (Button) findViewById(R.id.sadeffect);
        sadeffect.setOnClickListener(this);

        Button  fightproblem = (Button) findViewById(R.id.fightproblem);
        fightproblem.setOnClickListener(this);

        Button  sedtest = (Button) findViewById(R.id.sedtest);
        sedtest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToMainPage:
                // do your code
                Intent back = new Intent(WhatIsSad.this, MainActivity.class);
                startActivity(back);
                break;

            case R.id.meaning:
                // code for button when user clicks buttonOne.
                Intent meaningintent = new Intent(WhatIsSad.this, Meaning.class);
                startActivity(meaningintent);
                break;

            case R.id.sadcause:
                // code for button when user clicks buttonOne.
                Intent sadcause = new Intent(WhatIsSad.this, Sadcause.class);
                startActivity(sadcause);
                break;

            case R.id.sadeffect:
                // code for button when user clicks buttonOne.
                Intent sadeffect = new Intent(WhatIsSad.this, Sadeffect.class);
                startActivity(sadeffect);
                break;

            case R.id.fightproblem:
                // code for button when user clicks buttonOne.
                Intent fightproblem = new Intent(WhatIsSad.this, Coping.class);
                startActivity(fightproblem);
                break;

            case R.id.sedtest:
                // code for button when user clicks buttonOne.
                Intent depressTestIntent = new Intent(WhatIsSad.this, DepressTestInit.class);
                startActivity(depressTestIntent);
                break;
            default:
                break;
        }
    }
}