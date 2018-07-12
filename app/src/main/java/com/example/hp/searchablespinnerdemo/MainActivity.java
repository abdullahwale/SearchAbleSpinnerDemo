package com.example.hp.searchablespinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;
    Button buSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initems();
        spinnerDialog=new SpinnerDialog(MainActivity.this,items,"Select Items");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this, "Select : "+ item, Toast.LENGTH_SHORT).show();
            }
        });
        buSearch=(Button) findViewById(R.id.button);
        buSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialog.showSpinerDialog();
            }
        });
    }

    public void initems(){
        for(int i=0;i<100;i++){
            items.add("Items"+ (i+1));
        }
    }


}
