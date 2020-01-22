package com.example.hp.location;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class change extends AppCompatActivity {
    private Button button;
    public EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        editText=(EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phoneNumber=editText.getText().toString();




                DatabaseHelper  mysqliteopenhelper = new DatabaseHelper(getApplicationContext());
                boolean flag=mysqliteopenhelper.update(phoneNumber);
                if(flag)
                {
                    Toast.makeText(change.this, "Saved Successfully", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(change.this, "Error!!!!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
