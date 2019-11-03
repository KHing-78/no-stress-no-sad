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

public class DepressTestInit extends Activity {
    public DepressTestComponent myDepressTestComponent = new DepressTestComponent();
    protected RadioGroup radioGenderGroup;
    protected RadioButton radioSexButton;
    protected Button btnstartTest, exit;
    protected static String selectedGender;
    protected Spinner dropdownFaculty;
    protected EditText editTextAge;
    protected static String facultySelected;
    protected static int ageInt;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        myDepressTestComponent.setScore(0);
        setContentView(R.layout.depress_test_init);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(DepressTestInit.this, MainActivity.class);
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
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(DepressTestInit.this, "Please select faculty before proceed", Toast.LENGTH_SHORT).show();
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
                myDepressTestComponent.setGender(selectedGender);

                String ageString = editTextAge.getText().toString();
                ageInt = Integer.parseInt(ageString);
                myDepressTestComponent.setAge(ageInt);
                myDepressTestComponent.setFaculty(facultySelected);

                Toast.makeText(DepressTestInit.this,
                        myDepressTestComponent.getGender() + "," + myDepressTestComponent.getFaculty() + "," + myDepressTestComponent.getAge(), Toast.LENGTH_SHORT).show();
                //System.out.println("clicked");
                Intent intent = new Intent(DepressTestInit.this, DepressTestTwoQ.class);
                startActivity(intent);
            }
        });
    }
}
