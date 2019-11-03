package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Controll extends AppCompatActivity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.controll);

        ImageButton back = (ImageButton) findViewById(R.id.backToCoping);
        back.setOnClickListener(this);

        Button review = (Button) findViewById(R.id.reviewBut);
        review.setOnClickListener(this);

        Button  pre = (Button) findViewById(R.id.preBut);
        pre.setOnClickListener(this);

        Button  controllMineBut = (Button) findViewById(R.id.controllMineBut);
        controllMineBut.setOnClickListener(this);

        Button  rateBut = (Button) findViewById(R.id.rateBut);
        rateBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToCoping:
                // do your code
                Intent back = new Intent(Controll.this, Coping.class);
                startActivity(back);
                break;

            case R.id.reviewBut:
                // code for button when user clicks buttonOne.
                Intent intent = new Intent(Controll.this, Review.class);
                startActivity(intent);
                break;

            case R.id.preBut:
                // code for button when user clicks buttonOne.
                Intent effect = new Intent(Controll.this, Prepare.class);
                startActivity(effect);
                break;

            case R.id.controllMineBut:
                // code for button when user clicks buttonOne.
                Intent Consult = new Intent(Controll.this, ControllMine.class);
                startActivity(Consult);
                break;

            case R.id.rateBut:
                // code for button when user clicks buttonOne.
                Intent skillt = new Intent(Controll.this, Rate.class);
                startActivity(skillt);
                break;


            default:
                break;
        }
    }
}
