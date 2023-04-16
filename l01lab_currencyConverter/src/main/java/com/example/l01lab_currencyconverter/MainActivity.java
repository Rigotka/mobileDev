package com.example.l01lab_currencyconverter;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private LinearLayout _layoutCurrencyList;

    private int _value;

    private String _exchangeRates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _layoutCurrencyList = findViewById(R.id.layoutCurrenceList);

        EditText editText = findViewById(R.id.valueEditText);
        editText.setOnKeyListener((v, keyCode, event) -> {
            String valueString = editText.getText().toString();
            if(event.getAction() == KeyEvent.ACTION_UP)
            {
                _value = Integer.parseInt(valueString);
                updateCurrencyList();
                return true;
            }
            return false;
        });

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencyList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String _selectedCurrency = (String)parent.getItemAtPosition(pos);

        Resources res = getResources();
        int idSelectedCurrency = res.getIdentifier(_selectedCurrency, "string", getPackageName());
        _exchangeRates = res.getString(idSelectedCurrency);
        updateCurrencyList();
    }

    public void onNothingSelected(AdapterView<?> parent) {}
    
    public void updateCurrencyList(){
        _layoutCurrencyList.removeAllViews();
        String[] exchangeRatesArray = _exchangeRates.split(" ");

        for (String s : exchangeRatesArray) {
            View currency_card = getLayoutInflater().inflate(R.layout.currency_card, null);

            String[] keyAbdValue = s.split(":");

            String value = keyAbdValue[1];
            TextView valueCurrency =  currency_card.findViewById(R.id.currencyValueTextView);
            double result = Double.parseDouble(value) * _value;
            valueCurrency.setText(String.format(Locale.US, "%,.2f", result));

            String sym = keyAbdValue[0];
            TextView symCurrency = currency_card.findViewById(R.id.currencySymTextView);
            symCurrency.setText(sym);

            _layoutCurrencyList.addView(currency_card);
        }
    }
}