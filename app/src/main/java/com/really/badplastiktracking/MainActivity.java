package com.really.badplastiktracking;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean add = true;
    private String balance;
    private Button button;
    private int BLUE = 0xFF448AFF;
    private int ORANGE = 0xFFFF5722;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        TextView cashView = (TextView) findViewById(R.id.cardTotal);
        SharedPreferences settings = getPreferences(0);
        balance = settings.getString("cashBal", "$0.00"); // restore previous balance, or $0.00 if there is none
        cashView.setText(balance);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("cashBal", balance);
        editor.commit();
    }

    public void changeCash(View v) {
        TextView cashView = (TextView) findViewById(R.id.cardTotal);
        float totes = Float.valueOf(cashView.getText().toString().substring(1));
        float multiplier;

        if (add)
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
        balance = cashView.getText().toString();
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
        switchColors(view, add);
    }

    public void switchColors(View v, boolean colorType) {
        int color = BLUE;
        if (!colorType)
            color = ORANGE;
        // Since I'm too lazy to think of a good way to automate this process
        this.button = (Button) this.findViewById(R.id.change1);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();

        this.button = (Button) this.findViewById(R.id.change5);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();

        this.button = (Button) this.findViewById(R.id.change10);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();

        this.button = (Button) this.findViewById(R.id.changePenn);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();

        this.button = (Button) this.findViewById(R.id.changeNick);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();

        this.button = (Button) this.findViewById(R.id.changeDime);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_exit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
