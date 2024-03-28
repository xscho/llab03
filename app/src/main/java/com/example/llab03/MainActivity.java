package com.example.llab03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText out;
    TextView inp;
    Spinner choiceFrom;
    Spinner choiceTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = findViewById(R.id.edtxt);
        inp = findViewById(R.id.txt_inp_to);
        choiceFrom = findViewById(R.id.spin_from);
        choiceTo = findViewById(R.id.spin_to);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        choiceFrom.setAdapter(adp);
        choiceTo.setAdapter(adp);
    }

    public void on_convert(View v) {
        if (out.getText().toString().isEmpty()) {
            inp.setText("Field is empty, please enter a value.");
        }
        else if (!out.getText().toString().contains(".")) {
            out.setText(out.getText().toString() + ".0");
        }
        else {
            double from = Double.parseDouble(out.getText().toString());
            String spin_from = choiceFrom.getSelectedItem().toString();
            String spin_to = choiceTo.getSelectedItem().toString();

            if (spin_from.equals(spin_to)) {
                inp.setText(String.valueOf(from));
            } else {
                // Вызов метода конвертации в основном потоке
                new Thread(() -> {
                    double result = convertAndReturnResult(from, spin_from, spin_to);
                    runOnUiThread(() -> inp.setText(String.valueOf(result)));
                }).start();
            }
        }
    }
    private double convertAndReturnResult(double value, String fromUnit, String toUnit) {
        UnitConverter converter = new UnitConverter();
        try {
            return converter.convert(value, fromUnit, toUnit);
        } catch (IllegalArgumentException e) {
            runOnUiThread(() -> inp.setText("Unable to match the desired swap behavior"));
            return 0.0;
        }
    }
}