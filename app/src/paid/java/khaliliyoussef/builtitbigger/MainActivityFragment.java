package khaliliyoussef.builtitbigger;

/**
 * Created by Khalil on 7/20/2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);



        return root;
    }
}