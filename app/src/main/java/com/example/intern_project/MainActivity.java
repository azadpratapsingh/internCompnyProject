package com.example.intern_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {//base class for activities that wish to use some of the newer platform features on
    //older android devices
    private EditText edittext1, edittext2;
    private Button show, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //savedInstanceEstate is a reference to a bundle object that is passed onto the on create method of every android activity.
        //to restore themselves to the previous state using the data stored in the bundle.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        edittext1 = (EditText) findViewById(R.id.editText);
        //findViewById finds a view  object given its Id number;
        edittext2 = (EditText) findViewById(R.id.editText2);
        show = (Button) findViewById(R.id.show);
        next = (Button) findViewById(R.id.next);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = edittext1.getText().toString();
                String str2 = edittext2.getText().toString();
                String str3 = str1 + str2;

                Toast.makeText(getApplicationContext(), str3, Toast.LENGTH_LONG).show();
                //getApplicationContext returns the context for the entire appication
                //we cn ue "this" if we need a context tied to the lifecycle of the entire application.
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                //Android Intent is the message that is passed between components such as activities,
                // content providers, broadcast receivers, services etc.
                //The dictionary meaning of intent is intention or purpose. So, it can be described as the intention to do action
                // Implicit Intent doesn't specifiy the component. In such case, intent provides information of available
                // components provided by the system that is to be invoked.
                //Explicit Intent specifies the component. In such case, intent provides the external class to be invoked. 
                startActivity(intent);
            }
        });
    }
}



