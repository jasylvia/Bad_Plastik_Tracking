package com.really.badplastiktracking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean add = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeCash(View v) {
        TextView cashView = (TextView) findViewById(R.id.cardTotal);
        float totes = Float.valueOf(cashView.getText().toString().substring(1));
        float multiplier;

        if (add == true)
            multiplier = 1.00f;
        else
            multiplier = -1.00f;

        switch (v.getId()) {
            case R.id.change1:
                totes += 1.00f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
            case R.id.change5:
                totes += 5.00f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
            case R.id.change10:
                totes += 10.00f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
            case R.id.changePenn:
                totes += 0.01f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
            case R.id.changeNick:
                totes += 0.05f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
            case R.id.changeDime:
                totes += 0.10f * multiplier;
                cashView.setText("$");
                cashView.append(String.format("%.2f", totes));
                break;
        }
    }

    public void addOrSub(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton)view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioAdd:
                if (checked)
                    add = true;
                    break;
            case R.id.radioSub:
                if (checked)
                    add = false;
                    break;
        }
    }
}
