package com.example.sit30521p;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editInput = findViewById(R.id.edit_input);
        Spinner spinnerFrom = findViewById(R.id.spinner_from);
        Spinner spinnerTo = findViewById(R.id.spinner_to);
        Button btnConvert = findViewById(R.id.btn_convert);
        TextView textResult = findViewById(R.id.text_result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = editInput.getText().toString();

                if (inputStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a value first!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double value = Double.parseDouble(inputStr);
                String fromUnit = spinnerFrom.getSelectedItem().toString();
                String toUnit = spinnerTo.getSelectedItem().toString();
                String conversionKey = fromUnit + "_to_" + toUnit;
                double result = 0.0;

                switch (conversionKey) {
                    case "USD_to_AUD":
                        result = value * 1.55;
                        break;
                    case "USD_to_EUR":
                        result = value * 0.92;
                        break;
                    case "USD_to_JPY":
                        result = value * 148.50;
                        break;
                    case "USD_to_GBP":
                        result = value * 0.78;
                        break;
                    case "MPG_to_km/L":
                        result = value * 0.425;
                        break;
                    case "Gallon_to_Liter":
                        result = value * 3.785;
                        break;
                    case "Nautical Mile_to_Kilometer":
                        result = value * 1.852;
                        break;
                    case "Celsius_to_Fahrenheit":
                        result = (value * 1.8) + 32;
                        break;
                    case "Fahrenheit_to_Celsius":
                        result = (value - 32) / 1.8;
                        break;
                    case "Celsius_to_Kelvin":
                        result = value + 273.15;
                        break;
                    default:
                        if (fromUnit.equals(toUnit)) {
                            result = value;
                        } else {
                            result = 0.0;
                            Toast.makeText(MainActivity.this, "Conversion not supported", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                textResult.setText("Result: " + String.format("%.2f", result) + " " + toUnit);
            }
        });
    }
}