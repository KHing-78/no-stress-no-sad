package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class Contact extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.contact);

        Button back = (Button) findViewById(R.id.backToMain);
        back.setOnClickListener(this);

        Button call1 = (Button) findViewById(R.id.callbth1);
        call1.setOnClickListener(this);

        Button call2 = (Button) findViewById(R.id.callbth2);
        call2.setOnClickListener(this);

        Button call3 = (Button) findViewById(R.id.callbth3);
        call3.setOnClickListener(this);

        Button call4 = (Button) findViewById(R.id.callbth4);
        call4.setOnClickListener(this);

        Button call5 = (Button) findViewById(R.id.callbth5);
        call5.setOnClickListener(this);

        Button call6 = (Button) findViewById(R.id.callbth6);
        call6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backToMain:
                // do your code
                Intent back = new Intent(Contact.this, MainActivity.class);
                startActivity(back);
                break;

            case R.id.exit:
                // code for button when user clicks buttonOne.
                Intent exitintent = new Intent(Contact.this, MainActivity.class);
                startActivity(exitintent);
                break;

            case R.id.callbth1:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+1667));
                startActivity(call);
                break;

            case R.id.callbth2:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                Intent call2 = new Intent(Intent.ACTION_DIAL);
                call2.setData(Uri.parse("tel:"+1323));
                startActivity(call2);
                break;

            case R.id.callbth3:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                Intent call3 = new Intent(Intent.ACTION_DIAL);
                call3.setData(Uri.parse("tel:0433630013"));
                startActivity(call3);
                break;

            case R.id.callbth4:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                Intent call4 = new Intent(Intent.ACTION_DIAL);
                call4.setData(Uri.parse("tel:043203455"));
                startActivity(call4);
                break;

            case R.id.callbth5:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"samaritans.thailand",Toast.LENGTH_LONG).show();
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/Samaritans.Thailand/"));
                startActivity(launchBrowser);
                break;

            case R.id.callbth6:
                // code for button when user clicks buttonOne.
                Toast.makeText(this,"samaritans.thailand",Toast.LENGTH_LONG).show();
                Intent callbth6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/THAIDMH/?ref=br_rs"));
                startActivity(callbth6);
                break;

            default:
                break;
        }
    }
}
