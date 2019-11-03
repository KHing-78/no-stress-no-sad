package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Coping extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.coping);

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

        Button conscious = (Button) findViewById(R.id.consciousBut);
        conscious.setOnClickListener(this);

        Button massage = (Button) findViewById(R.id.massageBut);
        massage.setOnClickListener(this);

        Button breat = (Button) findViewById(R.id.breatheBut);
        breat.setOnClickListener(this);

        Button technique = (Button) findViewById(R.id.techniqueBut);
        technique.setOnClickListener(this);

        Button manage = (Button) findViewById(R.id.manageBut);
        manage.setOnClickListener(this);

        Button controll = (Button) findViewById(R.id.controllBut);
        controll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToStress:
                // do your code
                Intent back = new Intent(Coping.this, Infomation.class);
                startActivity(back);
                break;

            case R.id.exit:
                // do your code
                Intent exit = new Intent(Coping.this, MainActivity.class);
                startActivity(exit);
                break;

            case R.id.consciousBut:
                // code for button when user clicks buttonOne.
                Intent conscious = new Intent(Coping.this, Conscious.class);
                startActivity(conscious);
                break;

            case R.id.massageBut:
                // code for button when user clicks buttonOne.
                Intent massage = new Intent(Coping.this, Massage.class);
                startActivity(massage);
                break;

            case R.id.breatheBut:
                // code for button when user clicks buttonOne.
                Intent breath = new Intent(Coping.this, Breathe.class);
                startActivity(breath);
                break;

            case R.id.techniqueBut:
                // code for button when user clicks buttonOne.
                Intent technique = new Intent(Coping.this, Technique.class);
                startActivity(technique);
                break;

            case R.id.manageBut:
                // code for button when user clicks buttonOne.
                Intent manage = new Intent(Coping.this, Manage.class);
                startActivity(manage);
                break;

            case R.id.controllBut:
                // code for button when user clicks buttonOne.
                Intent controll = new Intent(Coping.this, Controll.class);
                startActivity(controll);
                break;

            default:
                break;
        }
    }
}