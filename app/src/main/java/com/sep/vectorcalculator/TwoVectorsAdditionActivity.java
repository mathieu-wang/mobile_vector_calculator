package com.sep.vectorcalculator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
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
                drawVector(result);
            } else {
                PolarVector cVector1 = new PolarVector(x1, y1);
                PolarVector cVector2 = new PolarVector(x2, y2);
                PolarVector result = Calculator.addTwoPolarVectors(cVector1, cVector2);
                displayText = result.toString();
                drawVector(result);
            }
        } catch (Exception e) {
            displayText = e.getMessage();
        }
        textViewResult.setText(displayText);
    }

    private void drawVector(CartesianVector vector) throws Exception {
        drawVector(vector.convertToPolarVector());
    }

    private void drawVector(PolarVector vector) throws Exception {
        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.twoaddition_surfaceView);
        surfaceView.setWillNotDraw(false);
        Canvas canvas = surfaceView.getHolder().lockCanvas();

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        float centerX = w/2;
        float centerY = h/2;

        float magnitude = centerY*3/4;
        double angleInRad = Math.toRadians(vector.getTheta());
        float normalizedX = centerX + magnitude * (float)Math.cos(angleInRad);
        float normalizedY = centerY - magnitude * (float)Math.sin(angleInRad); //y-axis of Canvas starts at top, so need to substract from center y

        float x1f = centerX;
        float y1f = centerY;
        float x2f = normalizedX;
        float y2f = normalizedY;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        surfaceView.draw(canvas);
        drawArrow(canvas, paint, x1f, y1f, x2f, y2f);
        surfaceView.getHolder().unlockCanvasAndPost(canvas);
    }

    //drawArrow method inspired from http://stackoverflow.com/questions/11975636/how-to-draw-an-arrow-using-android-graphic-class
    private void drawArrow(Canvas canvas, Paint paint, float x0, float y0, float x1, float y1) {
        float deltaX = x1 - x0;
        float deltaY = y1 - y0;
        float frac = (float) 0.1;

        float point_x_1 = x0 + (float) ((1 - frac) * deltaX + frac * deltaY);
        float point_y_1 = y0 + (float) ((1 - frac) * deltaY - frac * deltaX);

        float point_x_2 = x1;
        float point_y_2 = y1;

        float point_x_3 = x0 + (float) ((1 - frac) * deltaX - frac * deltaY);
        float point_y_3 = y0 + (float) ((1 - frac) * deltaY + frac * deltaX);

        Path path = new Path();

        path.moveTo(point_x_1, point_y_1);
        path.lineTo(point_x_2, point_y_2);
        path.lineTo(point_x_3, point_y_3);
        path.moveTo(point_x_2, point_y_2);
        path.close();

        canvas.drawLine(x0, y0, x1, y1, paint);
        canvas.drawPath(path, paint);
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
