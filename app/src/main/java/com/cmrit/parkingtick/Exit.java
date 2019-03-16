package com.cmrit.parkingtick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exit extends AppCompatActivity {

    String vcn;
    Button exit;
    EditText vehicle_nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        vehicle_nu=(EditText)findViewById(R.id.vehicle_no);
        exit=(Button)findViewById(R.id.exit_btn);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vcn=vehicle_nu.getText().toString();
               check(vcn);
            }
        });
    }
    public void check(String vcn){
        //to complete section
    }

}
