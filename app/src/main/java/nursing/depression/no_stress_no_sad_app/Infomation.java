package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Infomation extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.infomations);

        Button back = (Button) findViewById(R.id.backToMainPage);
        back.setOnClickListener(this);

        Button sCauseBut = (Button) findViewById(R.id.causeBut);
        sCauseBut.setOnClickListener(this);

        Button  effect = (Button) findViewById(R.id.effectBut);
        effect.setOnClickListener(this);

        Button  coping = (Button) findViewById(R.id.copingBut);
        coping.setOnClickListener(this);

        Button  stBut = (Button) findViewById(R.id.stBut);
        stBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToMainPage:
                // do your code
                Intent back = new Intent(Infomation.this, MainActivity.class);
                startActivity(back);
                break;

            case R.id.causeBut:
                // code for button when user clicks buttonOne.
                Intent intent = new Intent(Infomation.this, Stresscause.class);
                startActivity(intent);
                break;

            case R.id.effectBut:
                // code for button when user clicks buttonOne.
                Intent effect = new Intent(Infomation.this, StressEffect.class);
                startActivity(effect);
                break;

            case R.id.copingBut:
                // code for button when user clicks buttonOne.
                Intent coping = new Intent(Infomation.this, Coping.class);
                startActivity(coping);
                break;

            case R.id.stBut:
                // code for button when user clicks buttonOne.
                Intent stressTestIntent = new Intent(Infomation.this, StressTestStart.class);
                startActivity(stressTestIntent);
                break;


            default:
                break;
        }
    }
}
