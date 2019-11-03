package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nursing.depression.no_stress_no_sad_app.R;

public class StressResultThree extends StressResultOneAndTwo {
    protected Button stressContactInfo, exit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_result_three);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(StressResultThree.this, MainActivity.class);
                startActivity(exitintent);
            }
        });

        stressContactInfo = (Button) findViewById(R.id.stress_contactInfo);
        stressResultTopic = (TextView) findViewById(R.id.stress_results_topic_three);
        stressResultDescription = (TextView) findViewById(R.id.stress_results_description_three);
        stressEncounter = (Button) findViewById(R.id.stress_encounter);


           // Toast.makeText(StressResultThree.this, "Hey it's me :D", Toast.LENGTH_SHORT).show();
            userStressResult = myStressResult.getStressResultValue(2);
            myStressTestComponent.setResult(userStressResult);

            stressResultTopic.setText(myStressResult.getStressResultValue(2));
            stressResultDescription.setText(myStressResult.getStressResultDescription(2));


        saveUserResults();
        stressScore = 0;
        stressContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactintent = new Intent(StressResultThree.this, Contact.class);
                startActivity(contactintent);
                stressScore = 0;
                finish();


            }
        });
        stressEncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent coping = new Intent(StressResultThree.this, Coping.class);
                startActivity(coping);
                stressScore = 0;
                finish();

            }
        });

    }
}
