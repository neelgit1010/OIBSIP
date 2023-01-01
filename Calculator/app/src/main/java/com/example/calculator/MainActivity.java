package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,sub, mul, div,clr;
    TextView result;
    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.btnadd);
        sub = findViewById(R.id.btnsub);
        mul = findViewById(R.id.btnmul);
        div = findViewById(R.id.btndiv);
        clr = findViewById(R.id.clr);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result =  findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            //@SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(num1.length() == 0){
                    num1.setError("Field is Empty");
                }else if(num2.length() == 0){
                    num2.setError("Field is Empty");
                }
                else {
                    Float n1 = Float.parseFloat(num1.getText().toString());
                    Float n2 = Float.parseFloat(num2.getText().toString());
                    Float sum = n1 + n2;

                    result.setText("Result : " + sum);
                    Toast.makeText(MainActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
       sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.length() == 0){
                    num1.setError("Field is Empty");
                }else if(num2.length() == 0){
                    num2.setError("Field is Empty");
                }
                else {
                    Float n1 = Float.parseFloat(num1.getText().toString());
                    Float n2 = Float.parseFloat(num2.getText().toString());
                    Float sum = n1 - n2;

                    result.setText("Result : " + sum);
                    Toast.makeText(MainActivity.this, "Successfully Subtracted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.length() == 0){
                    num1.setError("Field is Empty");
                }else if(num2.length() == 0){
                    num2.setError("Field is Empty");
                }
                else {
                    Float n1 = Float.parseFloat(num1.getText().toString());
                    Float n2 = Float.parseFloat(num2.getText().toString());
                    Float sum = n1 * n2;

                    result.setText("Result : " + sum);
                    Toast.makeText(MainActivity.this, "Successfully Multiplied", Toast.LENGTH_SHORT).show();
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.length() == 0){
                    num1.setError("Field is Empty");
                }else if(num2.length() == 0){
                    num2.setError("Field is Empty");
                }
                else {
                    Float n1 = Float.parseFloat(num1.getText().toString());
                    Float n2 = Float.parseFloat(num2.getText().toString());
                    Float sum = n1 / n2;

                    result.setText("Result : " + sum);
                    Toast.makeText(MainActivity.this, "Yo yo! Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(num1.getText().toString().isEmpty() && num2.getText().toString().isEmpty() && result.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Already Empty, Dude!", Toast.LENGTH_SHORT).show();
                }else{
                    result.setText("");
                    num1.getText().clear();
                    num2.getText().clear();
                }
            }
        });
    }
}
/*
    if(TextUtils.isEmpty(num1.getText().toString())){
        Toast.makeText(MainActivity.this, "Enter Num1 first buddy", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(num2.getText().toString())){
        Toast.makeText(MainActivity.this, "Enter Num2 first buddy", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(num1.getText().toString()) && TextUtils.isEmpty(num2.getText().toString())){
        Toast.makeText(MainActivity.this, "Enter num1 and num2 first", Toast.LENGTH_SHORT).show();

 */