package com.example.netclan_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class Refine extends AppCompatActivity {
    Spinner spinner;
    //RadioButton radioButton;
    ImageView back;
    Slider slider;
    TextView textCount;
    Button save;
    EditText editText;
    

    private ToggleButton[] toggleButtons = new ToggleButton[8];
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        spinner = findViewById(R.id.spinner);
        save = findViewById(R.id.save);
        slider = findViewById(R.id.slider);
        back = findViewById(R.id.back);
        textCount = findViewById(R.id.textCount);
        editText = findViewById(R.id.editText);

        //Toggle buttons
        toggleButtons[0] = findViewById(R.id.coffeebtn);
        toggleButtons[1] = findViewById(R.id.businessbtn);
        toggleButtons[2] = findViewById(R.id.hobbiesbtn);
        toggleButtons[3] = findViewById(R.id.Friendshipbtn);
        toggleButtons[4] = findViewById(R.id.Moviesbtn);
        toggleButtons[5] = findViewById(R.id.Dinningbtn);
        toggleButtons[6] = findViewById(R.id.Datingbtn);
        toggleButtons[7] = findViewById(R.id.Matrimonybtn);

        slider.setEnabled(true);

        arr.add("Available | Hey Let Us Connect");
        arr.add("Away | Stay Discreet And Watch");
        arr.add("Buzy | Do Not Distrub | Will Catch Up Later");
        arr.add("SOS | Emergency! Need Assistance! Help");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spin_item, arr);
        adapter.setDropDownViewResource(R.layout.spin_item);
        spinner.setAdapter(adapter);

        for (ToggleButton button : toggleButtons) {
            button.setOnClickListener(toggleClickListener);
        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Refine.this, "Saved!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(getApplicationContext(), this);
                //startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                int currentLength = text.length();
                textCount.setText(currentLength+"/100");
            }
        });

    }
    private View.OnClickListener toggleClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            ToggleButton clickedButton = (ToggleButton) v;
            if (!clickedButton.isChecked()) {
                // Count the number of enabled buttons
                int enabledCount = 0;
                for (ToggleButton button : toggleButtons) {
                    if (button.isChecked()) {
                        enabledCount++;
                    }
                }

                // If only one button is enabled, prevent unchecking
                if (enabledCount < 1) {
                    clickedButton.setChecked(true);
                }
            }
        }
    };
}