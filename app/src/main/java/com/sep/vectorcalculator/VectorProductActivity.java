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


public class VectorProductActivity extends ActionBarActivity {
    boolean isCartesian = true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_product);
        setTitle("Get Vector Product");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vector_product, menu);
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
            TextView vectorX1 = (TextView)findViewById(R.id.vector_textViewX1);
            TextView vectorY1 = (TextView)findViewById(R.id.vector_textViewY1);
            TextView vectorX2 = (TextView)findViewById(R.id.vector_textViewX2);
            TextView vectorY2 = (TextView)findViewById(R.id.vector_textViewY2);

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonCartesian:
                    isCartesian = true;
                    vectorX1.setText("x1");
                    vectorY1.setText("y1");
                    vectorX2.setText("x2");
                    vectorY2.setText("y2");
                    break;
                case R.id.radioButtonPolar:
                    isCartesian = false;
                    vectorX1.setText("r1");
                    vectorY1.setText("theta1");
                    vectorX2.setText("r2");
                    vectorY2.setText("theta2");
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
            View rootView = inflater.inflate(R.layout.fragment_vector_product, container, false);
            return rootView;
        }
    }
}
