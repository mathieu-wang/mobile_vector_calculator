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


public class ThreeVectorsAdditionActivity extends ActionBarActivity {
    boolean isCartesian = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_vectors_addition);
        setTitle("Add Three Vectors");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_vectors_addition, menu);
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
            TextView threeadditionX1 = (TextView)findViewById(R.id.threeaddition_textViewX1);
            TextView threeadditionY1 = (TextView)findViewById(R.id.threeaddition_textViewY1);
            TextView threeadditionX2 = (TextView)findViewById(R.id.threeaddition_textViewX2);
            TextView threeadditionY2 = (TextView)findViewById(R.id.threeaddition_textViewY2);
            TextView threeadditionX3 = (TextView)findViewById(R.id.threeaddition_textViewX3);
            TextView threeadditionY3 = (TextView)findViewById(R.id.threeaddition_textViewY3);

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonCartesian:
                    isCartesian = true;
                    threeadditionX1.setText("x1");
                    threeadditionY1.setText("y1");
                    threeadditionX2.setText("x2");
                    threeadditionY2.setText("y2");
                    threeadditionX3.setText("x3");
                    threeadditionY3.setText("y3");
                    break;
                case R.id.radioButtonPolar:
                    isCartesian = false;
                    threeadditionX1.setText("r1");
                    threeadditionY1.setText("theta1");
                    threeadditionX2.setText("r2");
                    threeadditionY2.setText("theta2");
                    threeadditionX3.setText("r3");
                    threeadditionY3.setText("theta3");
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
            View rootView = inflater.inflate(R.layout.fragment_three_vectors_addition, container, false);
            return rootView;
        }
    }
}
