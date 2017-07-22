package khaliliyoussef.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent mIntent=getIntent();
      String Joke= mIntent.getStringExtra(JOKE);
//        Toast.makeText(this, ""+Joke, Toast.LENGTH_SHORT).show();
      TextView  mTextView= (TextView) findViewById(R.id.tv_activity);
        mTextView.setText(String.valueOf(Joke));
    }
}
