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


    public void threeadditionCalculate(View view) {
        EditText editTextX1 = (EditText)findViewById(R.id.threeaddition_editTextX1);
        EditText editTextY1 = (EditText)findViewById(R.id.threeaddition_editTextY1);
        EditText editTextX2 = (EditText)findViewById(R.id.threeaddition_editTextX2);
        EditText editTextY2 = (EditText)findViewById(R.id.threeaddition_editTextY2);
        EditText editTextX3 = (EditText)findViewById(R.id.threeaddition_editTextX3);
        EditText editTextY3 = (EditText)findViewById(R.id.threeaddition_editTextY3);

        TextView textViewResult = (TextView)findViewById(R.id.threeadditionViewResult);
        String displayText = "";

        try {
            double x1 = Double.parseDouble(editTextX1.getText().toString());
            double y1 = Double.parseDouble(editTextY1.getText().toString());
            double x2 = Double.parseDouble(editTextX2.getText().toString());
            double y2 = Double.parseDouble(editTextY2.getText().toString());
            double x3 = Double.parseDouble(editTextX3.getText().toString());
            double y3 = Double.parseDouble(editTextY3.getText().toString());

            if (isCartesian) {
                CartesianVector cVector1 = new CartesianVector(x1, y1);
                CartesianVector cVector2 = new CartesianVector(x2, y2);
                CartesianVector cVector3 = new CartesianVector(x3, y3);
                CartesianVector result = Calculator.addThreeCartesianVectors(cVector1, cVector2, cVector3);
                displayText = result.toString();
                drawVector(result);
            } else {
                PolarVector cVector1 = new PolarVector(x1, y1);
                PolarVector cVector2 = new PolarVector(x2, y2);
                PolarVector cVector3 = new PolarVector(x3, y3);
                PolarVector result = Calculator.addThreePolarVectors(cVector1, cVector2, cVector3);
                displayText = result.toString();
                drawVector(result);
            }
        } catch (NumberFormatException nfe) {
            displayText = "Please do not leave vector components empty";
        } catch (Exception e) {
            displayText = e.getMessage();
        }
        textViewResult.setText(displayText);
    }

    private void drawVector(CartesianVector vector) throws Exception {
        drawVector(vector.convertToPolarVector());
    }

    private void drawVector(PolarVector vector) throws Exception {
        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.threeaddition_surfaceView);
        surfaceView.setWillNotDraw(false);
        Canvas canvas = surfaceView.getHolder().lockCanvas();

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        float centerX = w/2;
        float centerY = h/2;

        float magnitude = centerY*3/4;
        double angleInRad = Math.toRadians(vector.getTheta());
        float normalizedX = centerX + magnitude * (float)Math.cos(angleInRad);
        float normalizedY = centerY - magnitude * (float)Math.sin(angleInRad); //y-axis of Canvas starts at top, so need to subtract from center y

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
            View rootView = inflater.inflate(R.layout.fragment_three_vectors_addition, container, false);
            return rootView;
        }
    }
}
