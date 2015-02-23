package com.sep.vectorcalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.RadioButton;
import android.widget.TextView;


public class ScalarProductActivity extends ActionBarActivity {
    boolean isCartesian = true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scalar_product);
        setTitle("Get Scalar Product");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scalar_product, menu);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (checked) {
            TextView scalarX1 = (TextView)findViewById(R.id.scalar_textViewX1);
            TextView scalarY1 = (TextView)findViewById(R.id.scalar_textViewY1);
            TextView scalarX2 = (TextView)findViewById(R.id.scalar_textViewX2);
            TextView scalarY2 = (TextView)findViewById(R.id.scalar_textViewY2);

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonCartesian:
                    isCartesian = true;
                    scalarX1.setText("x1");
                    scalarY1.setText("y1");
                    scalarX2.setText("x2");
                    scalarY2.setText("y2");
                    break;
                case R.id.radioButtonPolar:
                    isCartesian = false;
                    scalarX1.setText("r1");
                    scalarY1.setText("theta1");
                    scalarX2.setText("r2");
                    scalarY2.setText("theta2");
                    break;
            }
        }
    }
    

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_scalar_product, container, false);
            return rootView;
        }
    }
}
