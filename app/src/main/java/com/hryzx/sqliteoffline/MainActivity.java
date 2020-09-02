package com.hryzx.sqliteoffline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModels userModels = new UserModels();
                DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
                userModels.setId(1);
                userModels.setName(editText1.getText().toString());
                userModels.setTall(editText2.getText().toString());
                handler.addRecord(userModels);
                userModels = handler.getContact(1);
                System.out.println(userModels.getId() +" "+ userModels.getName() +" "+ userModels.getTall());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModels userModels = new UserModels();
                DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
                userModels = handler.getContact(2);
                System.out.println(userModels.getId() +" "+ userModels.getName() +" "+ userModels.getTall());
                editText1.setText(userModels.getName());
                editText2.setText(userModels.getTall());
            }
        });
    }

}
