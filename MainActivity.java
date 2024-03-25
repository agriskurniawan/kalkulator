package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private StringBuilder currentNumber = new StringBuilder();
    private double operand1 = Double.NaN;
    private double operand2 = Double.NaN;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        currentNumber.append(button.getText());
        textViewResult.setText(currentNumber.toString());
    }

    public void onResetClicked(View view) {
        currentNumber.setLength(0);
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        textViewResult.setText("0");
    }

    public void onCalculateClicked(View view) {
        if (!Double.isNaN(operand1) && !Double.isNaN(operand2)) {
            double result = calculate(operand1, operand2, operator);
            textViewResult.setText(String.valueOf(result));
            currentNumber.setLength(0);
            currentNumber.append(result);
            operand1 = result;
            operand2 = Double.NaN;
        }
    }


    private double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0)
                    return Double.NaN; // Handling division by zero
                return num1 / num2;
            default:
                return Double.NaN;
        }
    }
}
