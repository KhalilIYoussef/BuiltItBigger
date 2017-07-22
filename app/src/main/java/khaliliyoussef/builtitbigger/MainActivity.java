package khaliliyoussef.builtitbigger;


import android.content.Context;
import android.content.Intent;

import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import khaliliyoussef.androidlib.DisplayActivity;

import static khaliliyoussef.androidlib.DisplayActivity.JOKE;


public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
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



            // this is the flag configured in build.gradle
            //piad
new EndpointsAsyncTask()
        {
            @Override
            protected void onPostExecute(String result)
            {
                super.onPostExecute(result);
                Intent intent =new Intent(getApplicationContext(),DisplayActivity.class);
                intent.putExtra(JOKE, result);
                startActivity(intent);
            }
        }
        .execute(new Pair<Context, String>(this, " :-)"));






    }


}