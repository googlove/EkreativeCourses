package com.flame4ost.happyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
    @SuppressLint("UseCompatLoadingForDrawables")
    public void onClick(View view) {
        EditText text = findViewById(R.id.editText);
        String input = text.getText().toString();
        ImageView bulb = findViewById(R.id.bulb);
        Drawable green = getDrawable(getResources()
                .getIdentifier("@drawable/green", null, getPackageName()));
        Drawable red = getDrawable(getResources()
                .getIdentifier("@drawable/red", null, getPackageName()));

        if (input.length() == 6) {
            try {
                int number = Integer.parseInt(input);

                if (number == 0) {
                    bulb.setImageDrawable(green);
                } else if (number / 100000 == (number % 10)) {
                    if ((number / 10000) % 10 == (number % 100) / 10) {
                        if ((number / 1000) % 10 == (number % 1000) / 100) {
                            bulb.setImageDrawable(green);
                        }
                    }

                } else {
                    bulb.setImageDrawable(red);
                }
            } catch (NumberFormatException ex) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "You need to enter only numbers",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Enter 6 digits and then press the \"Check\" key",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}