package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    TextView textView, txtenter;
    Button btn;
    Spinner spinner1, spinner2;
    String selected1, selected2;
    String[] strings = {"Meter", "Centimeter", "Grams", "Kilograms"};
    Double result = 1.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        txtenter = findViewById(R.id.txtenter);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btnsubmit);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,strings);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected1 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected2= adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtenter.getText().toString().isEmpty()){
                    textView.setText("Enter the Value");
                } else {
                    solve(selected1, selected2, txtenter.getText().toString());
                }
            }
        });
    }

    private void solve(String selected1, String selected2, String str){
        
        if (str == null){
            Toast.makeText(this, "Enter the value", Toast.LENGTH_SHORT).show();
        }
        else if(selected1.equals("Meter") && selected2.equals("Centimeter") || selected1.equals(selected2)) {
            textView.setText(String.format("Converting from %s to %s", selected1, selected2));
            result = Double.parseDouble(str);
            result *= 100;
        } else if(selected1.equals("Centimeter") && selected2.equals("Meter") || selected1.equals(selected2)){
            textView.setText(String.format("Converting from %s to %s", selected1, selected2));
            result = Double.parseDouble(str);
            result *= 0.01;
        } else if(selected1.equals("Kilograms") && selected2.equals("Grams") || selected1.equals(selected2)){
            textView.setText(String.format("Converting from %s to %s", selected1, selected2));
            result = Double.parseDouble(str);
            result *= 1000;
        } else if(selected1.equals("Grams") && selected2.equals("Kilograms") || selected1.equals(selected2)) {
            textView.setText(String.format("Converting from %s to %s", selected1, selected2));
            result = Double.parseDouble(str);
            result *= 0.001;
        }

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.show_result,(LinearLayout)findViewById(R.id.resultidLL));
        TextView ans = view.findViewById(R.id.ans);

        if(selected1.equals("Meter") && selected2.equals("Grams") || selected1.equals("Meter") && selected2.equals("Kilograms") ||
                selected1.equals("Centimeter") && selected2.equals("Grams") || selected1.equals("Centimeter") && selected2.equals("Kilograms") ||
                selected1.equals("Grams") && selected2.equals("Meter") || selected1.equals("Grams") && selected2.equals("Centimeter") ||
                selected1.equals("Kilograms") && selected2.equals("Meter") || selected1.equals("Kilograms") && selected2.equals("Centimeter")
        )
            ans.setText(new StringBuilder().append("Can't be Converted\nUnequal Units.").toString());
        else if(selected1.equals(selected2))
            ans.setText(new StringBuilder().append("Converted value is : " + str).toString());
        else
            ans.setText(new StringBuilder().append("Converted value is : " + result).toString());

//        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}