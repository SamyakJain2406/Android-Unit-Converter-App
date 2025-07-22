package com.example.unitcoverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Added import for Toast

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView4;
    private EditText editTextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView4 = findViewById(R.id.textView4);
        editTextText = findViewById(R.id.editTextText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editTextText.getText().toString();

                if (inputText.isEmpty()) {
                    textView4.setText("Please enter a value in pounds.");
                    Toast.makeText(MainActivity.this, "Input is empty", Toast.LENGTH_SHORT).show();
                    return; // Exit the onClick method if input is empty
                }

                try {
                    double pounds = Double.parseDouble(inputText); // Use double for potentially decimal input
                    double kilograms = convertPoundsToKg(pounds);

                    // Display the result, formatted to 2 decimal places
                    textView4.setText(String.format("%.2f lbs = %.2f kg", pounds, kilograms));
                    Toast.makeText(MainActivity.this, "Converted!", Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid number
                    textView4.setText("Invalid input. Please enter a number.");
                    Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private double convertPoundsToKg(double pounds) {
        // 1 pound is approximately 0.453592 kilograms
        return pounds * 0.453592;
    }
}