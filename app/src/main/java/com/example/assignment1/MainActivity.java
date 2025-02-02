package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button kz_add_btn, kz_sub_btn, kz_mul_btn;
    private EditText kz_op_1_value, kz_op_2_value;
    private TextView kz_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeEventListeners();
    }
    private void initializeViews() {
        kz_add_btn = findViewById(R.id.kz_add_btn);
        kz_sub_btn = findViewById(R.id.kz_sub_btn);
        kz_mul_btn = findViewById(R.id.kz_mul_btn);

        kz_op_1_value = findViewById(R.id.kz_op_1_value);
        kz_op_2_value = findViewById(R.id.kz_op_2_value);

        kz_result = findViewById(R.id.kz_result);
    }
    private void initializeEventListeners() {
        kz_add_btn.setOnClickListener(v -> performOperation("+"));
        kz_sub_btn.setOnClickListener(v -> performOperation("-"));
        kz_mul_btn.setOnClickListener(v -> performOperation("*"));
    }
    private void performOperation(String operation) {
        String kz_op1 = kz_op_1_value.getText().toString();
        String kz_op2 = kz_op_2_value.getText().toString();

        if (kz_op1.isEmpty() || isNotNumeric(kz_op1)) {
            kz_op_1_value.setError("Please enter a valid number");
            return;
        }
        if (kz_op2.isEmpty() || isNotNumeric(kz_op2)) {
            kz_op_2_value.setError("Please enter a valid number");
            return;
        }

        Float kz_op1_f = Float.parseFloat(kz_op1);
        Float kz_op2_f = Float.parseFloat(kz_op2);

        float result;

        switch(operation) {
            case "+":
                result = kz_op1_f + kz_op2_f;
                break;
            case "-":
                result = kz_op1_f - kz_op2_f;
                break;
            case "*":
                result = kz_op1_f * kz_op2_f;
                break;
            default:
                result = 0;
        }

        setResult(result);
    }
    private boolean isNotNumeric(String input) {
        try {
            Float.parseFloat(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    private void setResult(float res) {
        kz_result.setText(String.valueOf(res));
        kz_op_1_value.setText("");
        kz_op_2_value.setText("");
        kz_op_1_value.requestFocus();
    }
}