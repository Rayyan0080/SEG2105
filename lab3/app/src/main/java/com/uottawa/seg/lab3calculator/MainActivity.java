package com.uottawa.seg.lab3calculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    private enum Operator {none, add, sub, mul, div, eq}

    private double data01=0, data02 = 0;

    private Operator opp = Operator.none;

    private boolean hasDot = false;

    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView)findViewById(R.id.resultText);

    }

    // Sample implementation of the onClickNumericalButton (...).
    // Feel free to re-implement or modidy.
    public void onClickNumericalButton(View view) {


        //Getting ID of pressed Button
        int pressID = view.getId();

        //If we had an equal sign pressed last, standard operation is to clean
//        if (R.id.buttonEq == pressID) {
//            resultText.setText("equals");
//            // Perform operation
//            if (opp == Operator.div) {
//                double math = data01 / data02;
//                resultText.setText(math + "");
//            } else if (opp == Operator.mul) {
//                double math = data01 * data02;
//                resultText.setText(math + "");
//            } else if (opp == Operator.sub) {
//                double math = data01 - data02;
//                resultText.setText(math + "");
//            } else if (opp == Operator.add) {
//                double math = data01 + data02;
//                resultText.setText(math + "");
//            }
//
//            data01 = 0;
//            data02 = 0;
//            opp = Operator.none;
//        }

        if (requiresCleaning) {
            resultText.setText("");
            requiresCleaning = false;
            hasDot = false;
        }

        //Figuring out which button was pressed and updating the represented text field object
        if (pressID == R.id.button0) {
            resultText.setText(resultText.getText() + "0");
        } else if (pressID == R.id.button1) {
            resultText.setText(resultText.getText() + "1");
        } else if (pressID == R.id.button2) {
            resultText.setText(resultText.getText() + "2");
        } else if (pressID == R.id.button3) {
            resultText.setText(resultText.getText() + "3");
        } else if (pressID == R.id.button4) {
            resultText.setText(resultText.getText() + "4");
        } else if (pressID == R.id.button5) {
            resultText.setText(resultText.getText() + "5");
        } else if (pressID == R.id.button6) {
            resultText.setText(resultText.getText() + "6");
        } else if (pressID == R.id.button7) {
            resultText.setText(resultText.getText() + "7");
        } else if (pressID == R.id.button8) {
            resultText.setText(resultText.getText() + "8");
        } else if (pressID == R.id.button9) {
            resultText.setText(resultText.getText() + "9");
        } else if (pressID == R.id.buttonDot) {
            if (!hasDot) {
                resultText.setText(resultText.getText() + ".");
                hasDot = true;
            }
        } else {
            resultText.setText("ERROR");
        }

    }

    public void onClickFunctionButton(View view) {
        int pressId = view.getId();

        if (pressId == R.id.buttonEq) {
            // Parse second number
            String temp = resultText.getText().toString();
            if (!temp.isEmpty()) {
                data02 = Double.parseDouble(temp);
            }

            double math = 0;
            if (opp == Operator.div) {
                math = data01 / data02;
            } else if (opp == Operator.mul) {
                math = data01 * data02;
            } else if (opp == Operator.sub) {
                math = data01 - data02;
            } else if (opp == Operator.add) {
                math = data01 + data02;
            }

            resultText.setText(String.valueOf(math));
            data01 = 0;
            data02 = 0;
            opp = Operator.none;

        } else {
            String temp = resultText.getText().toString();
            if (!temp.isEmpty()) {
                data01 = Double.parseDouble(temp);
            }

            if (pressId == R.id.buttonDiv) {
                opp = Operator.div;
            } else if (pressId == R.id.buttonMul) {
                opp = Operator.mul;
            } else if (pressId == R.id.buttonMinus) {
                opp = Operator.sub;
            } else if (pressId == R.id.buttonPlus) {
                opp = Operator.add;
            }

            requiresCleaning = true;
        }
    }
}