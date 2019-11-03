package nursing.depression.no_stress_no_sad_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nursing.depression.no_stress_no_sad_app.R;

public class YouTube extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtue);

        Button back = (Button) findViewById(R.id.exit);
        back.setOnClickListener(this);
        Button youtubeBut = (Button)findViewById(R.id.videoView1);
        youtubeBut.setOnClickListener(this);
        Button youtubeBut2 = (Button)findViewById(R.id.videoView2);
        youtubeBut2.setOnClickListener(this);
        Button youtubeBut3 = (Button)findViewById(R.id.videoView3);
        youtubeBut3.setOnClickListener(this);
        Button youtubeBut4 = (Button)findViewById(R.id.videoView4);
        youtubeBut4.setOnClickListener(this);
        Button youtubeBut5 = (Button)findViewById(R.id.videoView5);
        youtubeBut5.setOnClickListener(this);
        Button youtubeBut6 = (Button)findViewById(R.id.videoView6);
        youtubeBut6.setOnClickListener(this);
        Button youtubeBut7 = (Button)findViewById(R.id.videoView7);
        youtubeBut7.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.exit:
                // do your code
                Intent back = new Intent(YouTube.this, MainActivity.class);
                startActivity(back);
                break;

            case R.id.videoView1:
                Intent videoView1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=w7QZKCJTw2o&amp;feature=share&amp;fbclid=IwAR00nzphAXT4-B4Y_S2kyUAN7pFLWtiTM2yVDC-ymhXbBhm1G8vz-5OpRL4"));
                startActivity(videoView1);
                break;

            case R.id.videoView2:
                Intent videoView2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=a1kHw3p6JtY&amp=&feature=share&amp=&fbclid=IwAR1vbFjz0_bEx8eUfGypb3IGVrBVDK8YrcwAuo46NwSGuB5-fIaYYGHW5wA"));
                startActivity(videoView2);
                break;

            case R.id.videoView3:
                Intent videoView3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6u2kbE2tt0o&amp=&feature=share&amp=&fbclid=IwAR2DXTCvJr4nEkL9RnUDHwz5AUuMW7if1nsx45SvWfRyhbGCWRtAhjmIHPc"));
                startActivity(videoView3);
                break;

            case R.id.videoView4:
                Intent videoView4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4A4Xx3KvOJI&amp=&fbclid=IwAR3Ct8pq5EjckC4r7h2CHDlLLzzfXVEHmkh0tb-sjmeylROOslVNBUTLIgc"));
                startActivity(videoView4);
                break;

            case R.id.videoView5:
                Intent videoView5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CfRfwS47GhE"));
                startActivity(videoView5);
                break;

            case R.id.videoView6:
                Intent videoView6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VgVmX86qsLk"));
                startActivity(videoView6);
                break;

            case R.id.videoView7:
                Intent videoView7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EWJCQxs4SjU"));
                startActivity(videoView7);
                break;

            default:
                break;
        }
    }
}
