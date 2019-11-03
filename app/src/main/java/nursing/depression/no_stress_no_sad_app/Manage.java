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

public class Manage extends AppCompatActivity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.manage);

        ImageButton back = (ImageButton) findViewById(R.id.backToCoping);
        back.setOnClickListener(this);

        Button awa = (Button) findViewById(R.id.awaBut);
        awa.setOnClickListener(this);

        Button  positiveBut = (Button) findViewById(R.id.positiveBut);
        positiveBut.setOnClickListener(this);

        Button  consultants = (Button) findViewById(R.id.consultantsBut);
        consultants.setOnClickListener(this);

        Button  skillTraining = (Button) findViewById(R.id.skillTrainingBut);
        skillTraining.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToCoping:
                // do your code
                Intent back = new Intent(Manage.this, Coping.class);
                startActivity(back);
                break;

            case R.id.awaBut:
                // code for button when user clicks buttonOne.
                Intent intent = new Intent(Manage.this, Awareness.class);
                startActivity(intent);
                break;

            case R.id.positiveBut:
                // code for button when user clicks buttonOne.
                Intent effect = new Intent(Manage.this, PositiveThink.class);
                startActivity(effect);
                break;

            case R.id.consultantsBut:
                // code for button when user clicks buttonOne.
                Intent Consult = new Intent(Manage.this, nursing.depression.no_stress_no_sad_app.Consult.class);
                startActivity(Consult);
                break;

            case R.id.skillTrainingBut:
                // code for button when user clicks buttonOne.
                Intent skillt = new Intent(Manage.this, Skill.class);
                startActivity(skillt);
                break;


            default:
                break;
        }
    }
}
