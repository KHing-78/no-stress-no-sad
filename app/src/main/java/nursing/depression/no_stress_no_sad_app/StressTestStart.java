package nursing.depression.no_stress_no_sad_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nursing.depression.no_stress_no_sad_app.R;

public class StressTestStart extends Activity {
    private Button btnStart, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_test_start);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitintent = new Intent(StressTestStart.this, MainActivity.class);
                startActivity(exitintent);
            }
        });
        btnStart = findViewById(R.id.starto);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StressTestStart.this, StressTestInit.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
