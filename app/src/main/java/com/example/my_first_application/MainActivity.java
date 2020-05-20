package com.example.my_first_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView f1;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);


        tv_result = (TextView) findViewById(R.id.tv_result);


        String[] from = {"liter","ounces","cups","gallon"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"ounces","gallon","cups","liter"};
        ArrayAdapter aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(aa);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total = 0.0;
                Double amount = Double.parseDouble(ed1.getText().toString());


                        // Liter
                        if (sp1.getSelectedItem().toString() == "liter" &&
                                sp2.getSelectedItem().toString() == "gallon") {
                            total = amount * 0.2641720524;

                        } else if (sp1.getSelectedItem().toString() == "liter" &&
                                sp2.getSelectedItem().toString() == "ounces") {
                            total = amount * 33.814022702;


                        } else if (sp1.getSelectedItem().toString() == "liter" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 4.2267528377;

                        }


                        // Gallon
                        else if (sp1.getSelectedItem().toString() == "gallon" &&
                                sp2.getSelectedItem().toString() == "liter") {
                            total = amount * 3.785411784;

                        } else if (sp1.getSelectedItem().toString() == "gallon" &&
                                sp2.getSelectedItem().toString() == "ounces") {
                            total = amount * 128;

                        } else if (sp1.getSelectedItem().toString() == "gallon" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 16;

                        }


                        // Ounces
                        else if (sp1.getSelectedItem().toString() == "ounces" &&
                                sp2.getSelectedItem().toString() == "liter") {
                            total = amount * 0.0295735296;

                        } else if (sp1.getSelectedItem().toString() == "ounces" &&
                                sp2.getSelectedItem().toString() == "gallon") {
                            total = amount * 0.0078125;

                        } else if (sp1.getSelectedItem().toString() == "ounces" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 0.125;

                        }


                        // Cups
                        else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "liter") {
                            total = amount * 0.2365882365;

                        } else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "gallon") {
                            total = amount * 0.0625;

                        } else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "ounces") {
                            total = amount * 8;

                        }



                tv_result.setText("Rezultati: " + total);

            }
        });



    }

}
