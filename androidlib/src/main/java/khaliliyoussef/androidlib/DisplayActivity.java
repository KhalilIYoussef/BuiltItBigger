package khaliliyoussef.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mIntent=getIntent();
      String Joke= mIntent.getStringExtra("joke");
        mTextView= (TextView) findViewById(R.id.tv_android_library);
mTextView.setText(Joke);
    }
}
