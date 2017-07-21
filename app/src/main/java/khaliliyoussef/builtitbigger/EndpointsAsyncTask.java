package khaliliyoussef.builtitbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;


import com.example.khalil.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Khalil on 7/21/2017.
 */

class EndpointsAsyncTask extends AsyncTask<Context,Void, String>
{
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context...params)
    {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    //if it's an Real Device you put your IP
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];
//        String name = params[0];

        try {
            return myApiService.sayHi("").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }


}

//          compile group: 'com.google.api-client', name: 'google-api-client', version: '1.22.0'
//            compile group: 'com.google.api-client', name: 'google-api-client-android', version: '1.22.0'
//          compile group: 'com.google.api-client', name: 'google-api-client', version: '1.22.0'
//        compile group: 'com.google.api-client', name: 'google-api-client-android', version: '1.22.0'