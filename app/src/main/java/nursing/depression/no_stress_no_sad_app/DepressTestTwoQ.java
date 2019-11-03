package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nursing.depression.no_stress_no_sad_app.R;

public class DepressTestTwoQ extends DepressTestInit {


    public RadioGroup radioGroupTwoQOne, radioGroupTwoQTwo;
    public RadioButton radioTwoQOneYes, radioTwoQOneNo, radioTwoQTwoYes, radioTwoQTwoNo;
    public Button btnNext;
    ArrayList<TextView> radioArr = new ArrayList<>();
    int stack = 1;

    //protected static String userDepressResult;
    protected DepressResults myDepressResult = new DepressResults();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depress_test_two_q);
        //myDepressTestComponent.setScore(0);

        radioGroupTwoQOne = (RadioGroup) findViewById(R.id.radioDepressTwoQOne);
        radioGroupTwoQTwo = (RadioGroup) findViewById(R.id.radioDepressTwoQTwo);

        radioTwoQOneYes = findViewById(R.id.depressTwoQ1Yes);
        radioTwoQOneNo = findViewById(R.id.depressTwoQ1No);
        radioTwoQTwoYes = findViewById(R.id.depressTwoQ2Yes);
        radioTwoQTwoNo = findViewById(R.id.depressTwoQ2No);

//        radioTwoQOneYes.setOnClickListener(this);
//        radioTwoQOneNo.setOnClickListener(this);
//        radioTwoQTwoYes.setOnClickListener(this);
//        radioTwoQTwoNo.setOnClickListener(this);

        btnNext = (Button) findViewById(R.id.btnNextQuestion) ;
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int temp = 0;
                int selectedTwoQOne = radioGroupTwoQOne.getCheckedRadioButtonId();

                if(selectedTwoQOne == radioTwoQOneYes.getId()){
                    temp++;
                }

                int selectedTwoQTwo = radioGroupTwoQTwo.getCheckedRadioButtonId();
                if(selectedTwoQTwo == radioTwoQTwoYes.getId()){
                    temp++;
                }

                if(temp >= 1){
                    Intent intent = new Intent(DepressTestTwoQ.this, DepressTestStart.class);
                    startActivity(intent);


                } else if (temp == 0) {
                    Intent intent = new Intent(DepressTestTwoQ.this, DepressShowResultNoResult.class);
                    startActivity(intent);

                }

            }
        });
    }
//
//    void onRadioCustomClick(int id){
//
//        for (int i = 0 ; i < radioArr.size() ; i++){
//            if (i == id){
//                radioArr.get(i).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                if (stack != id){
//                    radioArr.get(stack).setBackground(getResources().getDrawable(R.drawable.border_radio));
//                    stack = i;
//                }
//            }
//
//        }
//    }
//    int temp = 0;
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()){
//            case R.id.radioTwoQOneYes:
//                onRadioCustomClick(0);
//                break;
//            case R.id.radioTwoQOneNo:
//                onRadioCustomClick(1);
//                break;
//        }
//        switch (v.getId()){
//            case R.id.depressTestNever:
//                onRadioCustomClick(0);
//                break;
//            case R.id.depressTestSometimes:
//                onRadioCustomClick(1);
//                break;
//        }
//    }
}
