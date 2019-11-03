package nursing.depression.no_stress_no_sad_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import nursing.depression.no_stress_no_sad_app.R;

public class StressTestInit extends Activity {
    public StressTestComponent myStressTestComponent = new StressTestComponent();
    protected RadioGroup radioGenderGroup;
    protected RadioButton radioSexButton;
    protected Button btnstartTest, exit;
    protected static String selectedGender;
    protected Spinner dropdownFaculty;
    protected EditText editTextAge;
    protected static String facultySelected;
    protected static int ageInt;
    //private static String[] items = new String[]{"คณะวิทยาศษสตร์", "คณะมนุษยศษสตร์และสังคมศาสตร์", "คณะเทคโนโลยี", "คณะบริหารธุรกิจและการบัญชี", "คณะนิติศาสตร์", "คณะเศรษฐศาสตร์", "วิทยาลัยการปกครองท้องถิ่น"};

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //myStressTestComponent.setScore(0);
        setContentView(R.layout.stress_test_init);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(StressTestInit.this, MainActivity.class);
                startActivity(exitintent);
            }
        });
        radioGenderGroup = findViewById(R.id.radioGender);
        dropdownFaculty = findViewById(R.id.dropdown_faculty);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.faculties, android.R.layout.simple_spinner_item);
        dropdownFaculty.setAdapter(adapter);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        editTextAge = findViewById(R.id.edit_text_age);
        btnstartTest = findViewById(R.id.startTest);

        dropdownFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                facultySelected = dropdownFaculty.getItemAtPosition(position).toString();
                //Toast.makeText(StressTestInit.this, facultySelected, Toast.LENGTH_SHORT).show();
                //myStressTestComponent.setFaculty(facultySelected);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(StressTestInit.this, "Please select faculty before proceed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnstartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = radioGenderGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioSexButton = findViewById(selectedId);

                selectedGender = (String) radioSexButton.getText();
                myStressTestComponent.setGender(selectedGender);

                String ageString = editTextAge.getText().toString();
                ageInt = Integer.parseInt(ageString);
                myStressTestComponent.setAge(ageInt);
                myStressTestComponent.setFaculty(facultySelected);

                Toast.makeText(StressTestInit.this,
                        myStressTestComponent.getGender() + "," + myStressTestComponent.getFaculty() + "," + myStressTestComponent.getAge() + "," + myStressTestComponent.getScore(), Toast.LENGTH_SHORT).show();
                //System.out.println("clicked");
                Intent intent = new Intent(StressTestInit.this, StressTestQuiz.class);
                startActivity(intent);
            }
        });
    }

}
