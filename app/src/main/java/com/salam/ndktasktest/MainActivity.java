package com.salam.ndktasktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //input numbers
    int num1, num2;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("mathUtility");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        final TextView tv = findViewById(R.id.sample_text);
        final TextView tv_Results = findViewById(R.id.tv_results);

        //EditText
        final EditText et_One = findViewById(R.id.et_num1);
        final EditText et_Two = findViewById(R.id.et_num2);

        //Button
        Button btn_Addition = findViewById(R.id.btn_add);
        Button btn_Subtract = findViewById(R.id.btn_subtract);
        Button btn_Divide = findViewById(R.id.btn_divide);
        Button btn_Mulitply = findViewById(R.id.btn_muliply);

        //provided by android studio as first action
        tv.setText(stringFromJNI());



        //addition of numbers with text validations on null input
        btn_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_One.getText().length() == 0){
                    et_One.setError(getString(R.string.err_NUMBER));
                    et_One.requestFocus();
                }
                else if (et_Two.getText().length() == 0){
                    et_Two.setError(getString(R.string.err_NUMBER));
                    et_Two.requestFocus();
                }
                else {
                    num1 = Integer.valueOf(et_One.getText().toString());
                    num2 = Integer.valueOf(et_Two.getText().toString());

                    tv_Results.setText(String.valueOf(sumOfNumbers(num1, num2)));
                }


            }
        });

        //subtraction of numbers  with text validations on null input
        btn_Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_One.getText().length() == 0){
                    et_One.setError(getString(R.string.err_NUMBER));
                    et_One.requestFocus();
                }
                else if (et_Two.getText().length() == 0){
                    et_Two.setError(getString(R.string.err_NUMBER));
                    et_Two.requestFocus();
                }
                else {
                    num1 = Integer.valueOf(et_One.getText().toString());
                    num2 = Integer.valueOf(et_Two.getText().toString());

                    tv_Results.setText(String.valueOf(subtractionOfNumbers(num1, num2)));
                }


            }
        });

        //multiplication of numbers with text validations on null input
        btn_Mulitply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_One.getText().length() == 0){
                    et_One.setError(getString(R.string.err_NUMBER));
                    et_One.requestFocus();
                }
                else if (et_Two.getText().length() == 0){
                    et_Two.setError(getString(R.string.err_NUMBER));
                    et_Two.requestFocus();
                }

                else {
                    num1 = Integer.valueOf(et_One.getText().toString());
                    num2 = Integer.valueOf(et_Two.getText().toString());

                    tv_Results.setText(String.valueOf(multiplicationOfNumbers(num1, num2)));
                }

            }
        });

        //division of numbers with text validations on null input
        btn_Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_One.getText().length() == 0){
                    et_One.setError(getString(R.string.err_NUMBER));
                    et_One.requestFocus();
                }
                else if (et_Two.getText().length() == 0){
                    et_Two.setError(getString(R.string.err_NUMBER));
                    et_Two.requestFocus();
                }
                else {
                    num1 = Integer.valueOf(et_One.getText().toString());
                    num2 = Integer.valueOf(et_Two.getText().toString());

                    tv_Results.setText(String.valueOf(divideNumbers(num1, num2)));
                }


            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    //new Library created

    /**
     *
     * @param a first integer number input
     * @param b second integer number input
     * @return results output a+b
     */
    public native int sumOfNumbers(int a, int b);

    /**
     *
     * @param a first input
     * @param b second input
     * @return a-b
     */
    public native int subtractionOfNumbers(int a , int b);

    /**
     *
     * @param a first input
     * @param b second input
     * @return a*c
     */
    public native int multiplicationOfNumbers(int a, int b);

    /**
     * @param a first input
     * @param b second input
     * @return a/b
     */
    public native double divideNumbers(int a, int b);



}
