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


        String[] from = {"","liter (l)","ounces (fl oz)","cups","gallon (gal)"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"","ounces (fl oz)","gallon (gal)","cups","liter (l)"};
        ArrayAdapter aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(aa);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String total2 = "";
                Double total = 0.0;
                Double amount = Double.parseDouble(ed1.getText().toString());




                        // Liter
                        if (sp1.getSelectedItem().toString() == "liter (l)" &&
                                sp2.getSelectedItem().toString() == "gallon (gal)") {
                            total = amount * 0.2641720524;
                            total2 = total.toString() + " gal";

                        } else if (sp1.getSelectedItem().toString() == "liter" &&
                                sp2.getSelectedItem().toString() == "ounces (fl oz)") {
                            total = amount * 33.814022702;
                            total2 = total.toString() + " fl oz";


                        } else if (sp1.getSelectedItem().toString() == "liter (l)" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 4.2267528377;
                            total2 = total.toString() + " cups";

                        }


                        // Gallon
                        else if (sp1.getSelectedItem().toString() == "gallon (gal)" &&
                                sp2.getSelectedItem().toString() == "liter (l)") {
                            total = amount * 3.785411784;
                            total2 = total.toString() + " l";


                        } else if (sp1.getSelectedItem().toString() == "gallon (gal)" &&
                                sp2.getSelectedItem().toString() == "ounces (fl oz)") {
                            total = amount * 128;
                            total2 = total.toString() + " fl oz";


                        } else if (sp1.getSelectedItem().toString() == "gallon (gal)" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 16;
                            total2 = total.toString() + " cups";
                        }


                        // Ounces
                        else if (sp1.getSelectedItem().toString() == "ounces (fl oz)" &&
                                sp2.getSelectedItem().toString() == "liter (l)") {
                            total = amount * 0.0295735296;
                            total2 = total.toString() + " l";


                        } else if (sp1.getSelectedItem().toString() == "ounces (fl oz)" &&
                                sp2.getSelectedItem().toString() == "gallon (gal)") {
                            total = amount * 0.0078125;
                            total2 = total.toString() + " gal";


                        } else if (sp1.getSelectedItem().toString() == "ounces (fl oz)" &&
                                sp2.getSelectedItem().toString() == "cups") {
                            total = amount * 0.125;
                            total2 = total.toString() + " cups";
                        }


                        // Cups
                        else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "liter (l)") {
                            total = amount * 0.2365882365;
                            total2 = total.toString() + " l";


                        } else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "gallon (gal)") {
                            total = amount * 0.0625;
                            total2 = total.toString() + " gal";


                        } else if (sp1.getSelectedItem().toString() == "cups" &&
                                sp2.getSelectedItem().toString() == "ounces (fl oz)") {
                            total = amount * 8;
                            total2 = total.toString() + " fl oz";

                        }


                tv_result.setText("Rezultati: " + total2);
            }
        });

    }

}
