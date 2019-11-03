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

public class StressResultOneAndTwo extends StressTestQuiz {
    private static final String TAG = "StressResultOneAndTwo";
    protected TextView stressResultTopic, stressResultDescription;
    protected ImageView stressImageResult;
    protected Button stressEncounter, exit;
    public String userStressResult;
    protected StressResults myStressResult = new StressResults();

    // firebase firestore things
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String KEY_GENDER = "gender";
    private static final String KEY_FACULTY = "faculty";
    private static final String KEY_AGE = "age";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SCORE = "score";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_result_one);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(StressResultOneAndTwo.this, MainActivity.class);
                startActivity(exitintent);
            }
        });

        stressResultTopic = (TextView) findViewById(R.id.stress_results_topic_one);
        stressResultDescription = (TextView) findViewById(R.id.stress_results_description_one);
        stressEncounter = (Button) findViewById(R.id.stress_encounter);
        stressImageResult = (ImageView) findViewById(R.id.stress_result_pic);

        //Log.d("score", String.valueOf(stressScore));
        if(stressScore > 0 && stressScore <= 23){

            userStressResult = myStressResult.getStressResultValue(0);
            myStressTestComponent.setResult(myStressResult.getStressResultValue(0));

        stressResultTopic.setText(myStressResult.getStressResultValue(0));
        stressResultDescription.setText(myStressResult.getStressResultDescription(0));
            stressImageResult.setImageResource(R.drawable.no_depress);

        } else if (stressScore > 23 && stressScore <= 41){
            //Toast.makeText(StressResultOneAndTwo.this, "คะแนนที่ได้ : " + stressScore, Toast.LENGTH_SHORT).show();
            //Log.d(TAG, String.valueOf(stressScore));
            userStressResult = myStressResult.getStressResultValue(1);
           myStressTestComponent.setResult(myStressResult.getStressResultValue(1));

           stressResultTopic.setText(myStressResult.getStressResultValue(1));
            stressResultDescription.setText(myStressResult.getStressResultDescription(1));
            stressImageResult.setImageResource(R.drawable.medium_depress);
        }

        saveUserResults();
        stressScore = 0;
        stressEncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coping = new Intent(StressResultOneAndTwo.this, Coping.class);
                startActivity(coping);
                stressScore = 0;
                finish();

            }
        });
    }
    public void saveUserResults() {
        Map<String, Object> userResult = new HashMap<>();
        userResult.put(KEY_GENDER, myStressTestComponent.getGender());
        userResult.put(KEY_FACULTY, myStressTestComponent.getFaculty());
        userResult.put(KEY_AGE, myStressTestComponent.getAge());
        userResult.put(KEY_SCORE, myStressTestComponent.getScore());
        userResult.put(KEY_RESULT, myStressTestComponent.getResult());

        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        db.collection("stressResultFromUser").document("user"+ts).set(userResult)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //myStressTestComponent.setScore(0);
                        stressScore = 0;


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
