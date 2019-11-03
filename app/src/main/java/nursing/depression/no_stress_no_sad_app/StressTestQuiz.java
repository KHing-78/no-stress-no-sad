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

public class StressTestQuiz extends StressTestInit {
   // StressTestComponent myStressTestComponent = new StressTestComponent();
    public RadioGroup radioStressGroup;
    public RadioButton radioZero, radioOne, radioTwo, radioThree, radioFour, radioFive, button;
    public TextView stressQuestion;
    public Button btnNext;
    public StressQuestions myStressQuestions = new StressQuestions();
    public static int stressScore = 0;
    //private int stressQuestionLength = 19;
    public int temp = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_test_quiz);
        /*Intent in = getIntent();
        Bundle b = in.getExtras();
        String parseGender = b.getString("gender", selectedGender);
        String parseFaculty = b.getString("faculty", facultySelected);
        int parseAge = b.getInt("age", ageInt);*/

        radioStressGroup = (RadioGroup) findViewById(R.id.stressAnswerGroup) ;
        radioZero = (RadioButton) findViewById(R.id.stressValue0);
        radioOne = (RadioButton) findViewById(R.id.stressValue1);
        radioTwo = (RadioButton) findViewById(R.id.stressValue2);
        radioThree = (RadioButton) findViewById(R.id.stressValue3);
        radioFour = (RadioButton) findViewById(R.id.stressValue4);
        radioFive = (RadioButton) findViewById(R.id.stressValue5);
        stressQuestion = (TextView) findViewById(R.id.stressQuestion);

        //updateQuestion(0);
        stressQuestion.setText("Q1" +  " : " +myStressQuestions.getStressQuestion(0));

        btnNext = (Button) findViewById(R.id.btnNextQuestion);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = radioStressGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id

                if (temp <= 19) {
                    if (selectedId == radioZero.getId()) {
                        stressScore += 0;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    if (selectedId == radioOne.getId()) {
                        stressScore += 1;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    if (selectedId == radioTwo.getId()) {
                        stressScore += 2;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    if (selectedId == radioThree.getId()) {
                        stressScore += 3;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    if (selectedId == radioFour.getId()) {
                        stressScore += 4;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    if (selectedId == radioFive.getId()) {
                        stressScore += 5;
                        updateQuestion(temp);
                        radioStressGroup.clearCheck();
                    }
                    temp++;
                }
                else {
                    button  = findViewById(selectedId);
                    String lastScore = (String) button.getText();
                    int myLastScore = Integer.parseInt(lastScore);
                    stressScore += myLastScore ;
                    myStressTestComponent.setScore(stressScore);
                    //Toast.makeText(StressTestQuiz.this, myStressTestComponent.getGender() + "," + myStressTestComponent.getFaculty() + "," + myStressTestComponent.getAge() + "," + myStressTestComponent.getScore()
                     //       , Toast.LENGTH_SHORT).show();
                    //finish();
                    Toast.makeText(StressTestQuiz.this,  "คะแนนที่ได้ : " +  myStressTestComponent.getScore()
                            , Toast.LENGTH_SHORT).show();
                    if(stressScore > 0 && stressScore <= 41){
                        Intent intent = new Intent(StressTestQuiz.this, StressResultOneAndTwo.class);
                        startActivity(intent);
                        //stressScore = 0;
                        finish();

                    } else if (stressScore > 41){
                        Intent intent = new Intent(StressTestQuiz.this, StressResultThree.class);
                        startActivity(intent);
                        //stressScore = 0;
                        finish();

                    }
                }

            }
        });
    }

    private void updateQuestion(int num){
        stressQuestion.setText("Q" + (num+1) + " : " + myStressQuestions.getStressQuestion(num));
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





}
