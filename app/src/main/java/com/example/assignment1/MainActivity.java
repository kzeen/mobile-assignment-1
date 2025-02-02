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
        kz_add_btn.setOnClickListener(v -> {
            float kz_op1 = Float.parseFloat(kz_op_1_value.getText().toString());
            float kz_op2 = Float.parseFloat(kz_op_2_value.getText().toString());

            float result = kz_op1 + kz_op2;

            setResult(result);
        });

        kz_sub_btn.setOnClickListener(v -> {
            float kz_op1 = Float.parseFloat(kz_op_1_value.getText().toString());
            float kz_op2 = Float.parseFloat(kz_op_2_value.getText().toString());

            float result = kz_op1 - kz_op2;

            setResult(result);
        });

        kz_mul_btn.setOnClickListener(v -> {
            float kz_op1 = Float.parseFloat(kz_op_1_value.getText().toString());
            float kz_op2 = Float.parseFloat(kz_op_2_value.getText().toString());

            float result = kz_op1 * kz_op2;

            setResult(result);
        });
    }

    private void setResult(float res) {
        kz_result.setText(String.valueOf(res));
    }
}