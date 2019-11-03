package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import nursing.depression.no_stress_no_sad_app.R;

public class DepressShowResultNoResult extends DepressTestTwoQ {
    // firebase firestore things
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String KEY_GENDER = "gender";
    private static final String KEY_FACULTY = "faculty";
    private static final String KEY_AGE = "age";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SCORE = "score";

    protected TextView depressResultTopic, depressResultDescription;
    protected Button depressEncounter, exit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depress_result_no_result);

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(DepressShowResultNoResult.this, MainActivity.class);
                startActivity(exitintent);
            }
        });

        depressResultTopic = (TextView) findViewById(R.id.depress_results_topic_no_result);
        depressResultDescription = (TextView) findViewById(R.id.depress_results_description_no_result);
        depressEncounter = (Button) findViewById(R.id.depress_encounter);

        depressResultTopic.setText(myDepressResult.getDepressResultValue(0));
        depressResultDescription.setText(myDepressResult.getDepressResultDescription(0));
        saveUserResults();
        depressEncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // code for button when user clicks buttonOne.
                Intent coping = new Intent(DepressShowResultNoResult.this, Coping.class);
                startActivity(coping);

            }
        });

    } protected void saveUserResults(){
        Map<String, Object> userResult = new HashMap<>();
        userResult.put(KEY_GENDER, myDepressTestComponent.getGender());
        userResult.put(KEY_FACULTY, myDepressTestComponent.getFaculty());
        userResult.put(KEY_AGE, myDepressTestComponent.getAge());
        userResult.put(KEY_SCORE, myDepressTestComponent.getScore());
        userResult.put(KEY_RESULT, myDepressTestComponent.getResult());

        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        db.collection("depressResultTwoQFroemUser").document("user"+ ts).set(userResult)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
    }

