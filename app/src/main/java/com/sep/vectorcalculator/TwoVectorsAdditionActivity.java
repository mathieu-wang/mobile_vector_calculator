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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class TwoVectorsAdditionActivity extends ActionBarActivity {
    boolean isCartesian = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_vectors_addition);
        setTitle("Add Two Vectors");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_vectors_addition, menu);
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
            TextView twoadditionX1 = (TextView)findViewById(R.id.twoaddition_textViewX1);
            TextView twoadditionY1 = (TextView)findViewById(R.id.twoaddition_textViewY1);
            TextView twoadditionX2 = (TextView)findViewById(R.id.twoaddition_textViewX2);
            TextView twoadditionY2 = (TextView)findViewById(R.id.twoaddition_textViewY2);

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonCartesian:
                    isCartesian = true;
                    twoadditionX1.setText("x1");
                    twoadditionY1.setText("y1");
                    twoadditionX2.setText("x2");
                    twoadditionY2.setText("y2");
                    break;
                case R.id.radioButtonPolar:
                    isCartesian = false;
                    twoadditionX1.setText("r1");
                    twoadditionY1.setText("theta1");
                    twoadditionX2.setText("r2");
                    twoadditionY2.setText("theta2");
                    break;
            }
        }
    }

    public void twoadditionCalculate(View view) {
        EditText editTextX1 = (EditText)findViewById(R.id.twoaddition_editTextX1);
        EditText editTextY1 = (EditText)findViewById(R.id.twoaddition_editTextY1);
        EditText editTextX2 = (EditText)findViewById(R.id.twoaddition_editTextX2);
        EditText editTextY2 = (EditText)findViewById(R.id.twoaddition_editTextY2);
        double x1 = Double.parseDouble(editTextX1.getText().toString());
        double y1 = Double.parseDouble(editTextY1.getText().toString());
        double x2 = Double.parseDouble(editTextX2.getText().toString());
        double y2 = Double.parseDouble(editTextY2.getText().toString());

        TextView textViewResult = (TextView)findViewById(R.id.twoadditionViewResult);
        String displayText = "";

        try {
            if (isCartesian) {
                CartesianVector cVector1 = new CartesianVector(x1, y1);
                CartesianVector cVector2 = new CartesianVector(x2, y2);
                CartesianVector result = Calculator.addTwoCartesianVectors(cVector1, cVector2);
                displayText = result.toString();
            } else {
                PolarVector cVector1 = new PolarVector(x1, y1);
                PolarVector cVector2 = new PolarVector(x2, y2);
                PolarVector result = Calculator.addTwoPolarVectors(cVector1, cVector2);
                displayText = result.toString();
            }
        } catch (Exception e) {
            displayText = e.getMessage();
        }
        textViewResult.setText(displayText);
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
            View rootView = inflater.inflate(R.layout.fragment_two_vectors_addition, container, false);
            return rootView;
        }
    }
}
