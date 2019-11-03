package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Conscious extends AppCompatActivity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.conscious);

        Button back = (Button) findViewById(R.id.backToCoping);
        back.setOnClickListener(this);

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

        Button trainBut = (Button) findViewById(R.id.trainBut);
        trainBut.setOnClickListener(this);

        Button  bodyScanBut = (Button) findViewById(R.id.bodyScanBut);
        bodyScanBut.setOnClickListener(this);

        Button  focusBut = (Button) findViewById(R.id.focusBut);
        focusBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToCoping:
                // do your code
                Intent back = new Intent(Conscious.this, Coping.class);
                startActivity(back);
                break;

            case R.id.exit:
                // code for button when user clicks buttonOne.
                Intent exitintent = new Intent(Conscious.this, MainActivity.class);
                startActivity(exitintent);
                break;


            case R.id.trainBut:
                // code for button when user clicks buttonOne.
                Intent intent = new Intent(Conscious.this, Traincon.class);
                startActivity(intent);
                break;

            case R.id.bodyScanBut:
                // code for button when user clicks buttonOne.
                Intent effect = new Intent(Conscious.this, BodyScan.class);
                startActivity(effect);
                break;

            case R.id.focusBut:
                // code for button when user clicks buttonOne.
                Intent coping = new Intent(Conscious.this, Focusing.class);
                startActivity(coping);
                break;
            default:
                break;
        }
    }
}
