// Jin Woo Yu <jinwooyu@stanford.edu>
// TipCalculator Version 1 - This app allows user to calculate tips they should pay
// by inputting the price of the meal, as well as their satisfaction rates.


package edu.stanford.cs193.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity1 extends AppCompatActivity {
    private double price;
    private double tip;
    private int tiprate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        price = 0;
        tip = 0;
        tiprate =0;
        updateinfo();
    }

    public void satisfact(View view) {
        if(view.getId() == R.id.button9)tiprate=9;
        else if(view.getId() == R.id.button12)tiprate=12;
        else if(view.getId() == R.id.button15)tiprate=15;
        else if(view.getId() == R.id.button18)tiprate=18;
        updateinfo();
    }

    public void getprice(View view) {
        EditText etprice = (EditText) findViewById(R.id.pricemeal);
        if(etprice!=null && !etprice.getText().toString().equals("")) {
                price = Double.parseDouble(etprice.getText().toString());
        }
        updateinfo();
    }

    public void updateinfo(){
        tip = price * tiprate / 100;
        TextView tipamount = (TextView) findViewById(R.id.finaltip);
        if(tipamount!=null)tipamount.setText(getString(R.string.resulttip,tip));
        TextView totalamount = (TextView) findViewById(R.id.finaltotal);
        if(totalamount!=null) totalamount.setText(getString(R.string.resulttotal,(tip + price)));
    }

}
