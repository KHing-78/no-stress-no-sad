package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import nursing.depression.no_stress_no_sad_app.R;

public class DepressTestQuiz extends DepressTestTwoQ {
    protected TextView depressQuestion;
    protected RadioButton radioNever, radioSometimes, radioUsually, radioEveryday, button;
    protected RadioGroup depressAnswerGroup;
   // ArrayList<TextView> radioArr = new ArrayList<>();
    //int stack = 1;
    public Button btnNext;
    protected DepressQuestions myDepressQuestion = new DepressQuestions();
    public static int depressScore = 0;
    public int temp = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDepressTestComponent.setScore(0);
        setContentView(R.layout.depress_test_quiz);

        depressAnswerGroup = (RadioGroup) findViewById(R.id.depressAnswerGroup) ;
        radioNever = findViewById(R.id.depressTestNever);
        radioSometimes = findViewById(R.id.depressTestSometimes);
        radioUsually = findViewById(R.id.depressTestUsually);
        radioEveryday = findViewById(R.id.depressTestAlways);
        depressQuestion = (TextView) findViewById(R.id.depressQuestion);

        //updateQuestion(0);
        depressQuestion.setText("Q1" +  " : " + myDepressQuestion.getDepressQuestion(0));
        btnNext = (Button) findViewById(R.id.btnNextQuestion);
//
//        radioArr.add(radioNever);
//        radioArr.add(radioSometimes);
//        radioArr.add(radioUsually);
//        radioArr.add(radioEveryday);
//
//        btnNext.setOnClickListener(this);
//        radioNever.setOnClickListener(this);
//        radioSometimes.setOnClickListener(this);
//        radioUsually.setOnClickListener(this);
//        radioEveryday.setOnClickListener(this);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = depressAnswerGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id

                if (temp <= 8) {
                    if (selectedId == radioNever.getId()) {
                        depressScore += 0;
                        updateQuestion(temp);
                        depressAnswerGroup.clearCheck();
                    }
                    if (selectedId == radioSometimes.getId()) {
                        depressScore += 1;
                        updateQuestion(temp);
                        depressAnswerGroup.clearCheck();
                    }
                    if (selectedId == radioUsually.getId()) {
                        depressScore += 2;
                        updateQuestion(temp);
                        depressAnswerGroup.clearCheck();
                    }
                    if (selectedId == radioEveryday.getId()) {
                        depressScore += 3;
                        updateQuestion(temp);
                        depressAnswerGroup.clearCheck();
                    }
                    temp++;
                }
                else {
                    //button  = findViewById(selectedId);
                    if (selectedId == radioNever.getId()) {
                        depressScore += 0;

                    }
                    if (selectedId == radioSometimes.getId()) {
                        depressScore += 1;

                    }
                    if (selectedId == radioUsually.getId()) {
                        depressScore += 2;
                        ;
                    }
                    if (selectedId == radioEveryday.getId()) {
                        depressScore += 3;

                    }
                    myDepressTestComponent.setScore(depressScore);
                    //Toast.makeText(StressTestQuiz.this, myStressTestComponent.getGender() + "," + myStressTestComponent.getFaculty() + "," + myStressTestComponent.getAge() + "," + myStressTestComponent.getScore()
                    //       , Toast.LENGTH_SHORT).show();
                    //finish();
                    Toast.makeText(DepressTestQuiz.this, "คะแนนที่ได้ : " + myDepressTestComponent.getScore()
                            , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DepressTestQuiz.this, DepressShowResult.class);
                    startActivity(intent);
                    //depressScore = 0;
                    finish();
                }

            }
        });
    }

//    void onRadioCustomClick(int id) {
//
//        for (int i = 0; i < radioArr.size(); i++) {
//            if (i == id) {
//                radioArr.get(i).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                if (stack != id) {
//                    radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    stack = i;
//                }
//            }
//
//        }
//    }

    private void updateQuestion(int num) {
        depressQuestion.setText("Q" + (num+1) + " : " + myDepressQuestion.getDepressQuestion(num));
    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.depressTestNever:
//                onRadioCustomClick(0);
//                break;
//            case R.id.depressTestSometimes:
//                onRadioCustomClick(1);
//                break;
//            case R.id.depressTestUsually:
//                onRadioCustomClick(2);
//                break;
//            case R.id.depressTestAlways:
//                onRadioCustomClick(3);
//                break;
//            case R.id.btnNextQuestion:
//
//                if (temp <= 8) {
//                    if (stack == radioNever.getId()) {
//                        depressScore += 0;
//
//                        //radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    }
//                    if (stack == radioSometimes.getId()) {
//                        depressScore += 1;
//                        //updateQuestion(temp);
//                        //radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    }
//                    if (stack == radioUsually.getId()) {
//                        depressScore += 2;
//                       // updateQuestion(temp);
//                        //radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    }
//                    if (stack == radioEveryday.getId()) {
//                        depressScore += 3;
//                        //updateQuestion(temp);
//                        //radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    }
//                    updateQuestion(temp);
//                    temp++;
//                } else {
//                    //button  = findViewById(selectedId);
//                    if (stack == radioNever.getId()) {
//                        depressScore += 0;
//                    }
//                    if (stack == radioSometimes.getId()) {
//                        depressScore += 1;
//                    }
//                    if (stack == radioUsually.getId()) {
//                        depressScore += 2;
//                    }
//                    if (stack == radioEveryday.getId()) {
//                        depressScore += 3;
//                    }
//                    myDepressTestComponent.setScore(depressScore);
//                    //Toast.makeText(StressTestQuiz.this, myStressTestComponent.getGender() + "," + myStressTestComponent.getFaculty() + "," + myStressTestComponent.getAge() + "," + myStressTestComponent.getScore()
//                    //       , Toast.LENGTH_SHORT).show();
//                    //finish();
//                    Toast.makeText(DepressTestQuiz.this, myDepressTestComponent.getGender() + "," + myDepressTestComponent.getFaculty() + "," + myDepressTestComponent.getAge() + "," + myDepressTestComponent.getScore()
//                            , Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(DepressTestQuiz.this, DepressShowResult.class);
//                    startActivity(intent);
//                    depressScore = 0;
//                    finish();
//
//                }
//        }
//    }
}


  /*  public void getQuestions() {
        stressQuestionsSource.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String questionId = documentSnapshot.getString("id");
                            String question = documentSnapshot.getString("value");
                            //Map<String, Object> stressQuestion = documentSnapshot.getData();
                            Toast.makeText(StressTestQuiz.this, questionId, Toast.LENGTH_SHORT).show();
                            stressQuestion.setText(question);

                        } else {
                            Toast.makeText(StressTestQuiz.this, "No questions", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new onFailureListener() {
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StressTestQuiz.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());

                    }
                });
    }*/





