package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import nursing.depression.no_stress_no_sad_app.R;

public class DepressShowResult extends DepressTestQuiz {
    // firebase firestore things
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String KEY_GENDER = "gender";
    private static final String KEY_FACULTY = "faculty";
    private static final String KEY_AGE = "age";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SCORE = "score";

    protected TextView depressResultTopic, depressResultDescription;
    protected Button depressEncounter, depressContactInfo, exit;
    protected ImageView depressImageResult;
    public static String userDepressResult;
    public DepressResults myDepressResult = new DepressResults();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depress_result_show);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(DepressShowResult.this, MainActivity.class);
                startActivity(exitintent);
            }
        });

        depressResultTopic = (TextView) findViewById(R.id.depress_results_topic);
        depressResultDescription = (TextView) findViewById(R.id.depress_results_decription);
        depressEncounter = (Button) findViewById(R.id.depress_encounter);
        depressContactInfo = (Button) findViewById(R.id.depress_contactInfo);
        depressImageResult = (ImageView) findViewById(R.id.depress_result_pic);

        if(depressScore <= 6){
            userDepressResult = myDepressResult.getDepressResultValue(1);
            myDepressTestComponent.setResult(userDepressResult);

            depressResultTopic.setText(myDepressResult.getDepressResultValue(1));
            depressResultDescription.setText(myDepressResult.getDepressResultDescription(0));
            depressImageResult.setImageResource(R.drawable.no_depress);

            myDepressTestComponent.setScore(depressScore);

        } else if(depressScore > 6 && depressScore < 13){
            userDepressResult = myDepressResult.getDepressResultValue(2);
            myDepressTestComponent.setResult(userDepressResult);

            depressResultTopic.setText(myDepressResult.getDepressResultValue(2));
            depressResultDescription.setText(myDepressResult.getDepressResultDescription(1));
            depressImageResult.setImageResource(R.drawable.mild_depress);

            myDepressTestComponent.setScore(depressScore);

        } else if(depressScore >= 13 && depressScore < 19){
            userDepressResult = myDepressResult.getDepressResultValue(3);
            myDepressTestComponent.setResult(userDepressResult);

            depressResultTopic.setText(myDepressResult.getDepressResultValue(3));
            depressResultDescription.setText(myDepressResult.getDepressResultDescription(2));
            depressImageResult.setImageResource(R.drawable.medium_depress);

            myDepressTestComponent.setScore(depressScore);

        } else if(depressScore >= 19){
            userDepressResult = myDepressResult.getDepressResultValue(4);
            myDepressTestComponent.setResult(userDepressResult);

            depressResultTopic.setText(myDepressResult.getDepressResultValue(4));
            depressResultDescription.setText(myDepressResult.getDepressResultDescription(3));
            depressImageResult.setImageResource(R.drawable.severe_depress);

            myDepressTestComponent.setScore(depressScore);

        }


        depressEncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// code for button when user clicks buttonOne.
                Intent coping = new Intent(DepressShowResult.this, Coping.class);
                startActivity(coping);
                finish();
                depressScore = 0;
            }
        });
        depressContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// code for button when user clicks buttonOne.
                Intent contactintent = new Intent(DepressShowResult.this, Contact.class);
                startActivity(contactintent);
                finish();
                depressScore = 0;
            }
        });
        saveUserResults();
        //depressScore = 0;
    }


    protected void saveUserResults() {

        Map<String, Object> userResult = new HashMap<>();
        userResult.put(KEY_GENDER, myDepressTestComponent.getGender());
        userResult.put(KEY_FACULTY, myDepressTestComponent.getFaculty());
        userResult.put(KEY_AGE, myDepressTestComponent.getAge());
        userResult.put(KEY_SCORE, myDepressTestComponent.getScore());
        userResult.put(KEY_RESULT, myDepressTestComponent.getResult());
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        db.collection("depressResultNineQFromUser").document("user"+ ts).set(userResult)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        depressScore = 0;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
