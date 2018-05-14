package com.privateuser.home.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity {

    private Spinner spinner = null;
    private TextView textView = null;
    private Button button = null;
    private String selectedOption = "";
    private int itemPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // typecasting
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);

        // Creating adapter for spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text_spinner, getResources().getStringArray(R.array.months_array));
        spinner.setAdapter(arrayAdapter);

        spinner.setSelection(0);

        // spinner item selected listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemPosition = position;
                selectedOption = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Button onclick listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (itemPosition) {
                    case 0:
                        Toast.makeText(ActivityA.this, getString(R.string.str_selectHint), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        textView.setText(selectedOption);
                        break;
                }
            }
        });
    }
}
