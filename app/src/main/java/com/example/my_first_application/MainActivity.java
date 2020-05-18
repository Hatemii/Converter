package com.example.my_first_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);


        String[] from = {"USD","EUR","CHF","LEK"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"EUR","LEK","CHF"};
        ArrayAdapter aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(aa);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total;
                Double amount = Double.parseDouble(ed1.getText().toString());
                        if(sp1.getSelectedItem().toString() == "USD" &&
                        sp2.getSelectedItem().toString() == "LEK"){
                            total = amount * 123.3;
                            Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                        }
                        else if(sp1.getSelectedItem().toString() == "USD" &&
                               sp2.getSelectedItem().toString() == "EUR"){
                                    total = amount * 5.5;
                                    Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                        }
                        else if(sp1.getSelectedItem().toString() == "USD" &&
                                sp2.getSelectedItem().toString() == "CHF"){
                            total = amount * 10.5;
                            Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                        }
            }
        });
    }
}
