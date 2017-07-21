package khaliliyoussef.builtitbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;



import khaliliyoussef.androidlib.DisplayActivity;
import khaliliyoussef.builtitbigger.flavors.free.FreeActivity;

public class MainActivity extends AppCompatActivity
{

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        if (BuildConfig.PAID_VERSION)
        {
            // this is the flag configured in build.gradle
            //piad
            Toast.makeText(this, "paid Version $$$", Toast.LENGTH_SHORT).show();
            new EndpointsAsyncTask(){

                @Override
                protected void onPostExecute(String result) {
                    Intent intent = new Intent(getApplicationContext(),DisplayActivity.class);
                    intent.putExtra(JOKE, result);
                    startActivity(intent);
                    super.onPostExecute(result);
                }
            }.execute(this);

        }
        else
        {//free
            Toast.makeText(this, "your free Version", Toast.LENGTH_SHORT).show();
Intent intent =new Intent (getBaseContext(), FreeActivity.class);
            startActivity(intent);

        }


    }


}