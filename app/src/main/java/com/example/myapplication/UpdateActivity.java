package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Button update_button, delete_button;
    EditText name_input, category_input, price_input;

    String id, name, category, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input2);
        category_input = findViewById(R.id.category_input2);
        price_input = findViewById(R.id.price_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper myDB = new Helper(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                category = category_input.getText().toString().trim();
                price = price_input.getText().toString().trim();
                myDB.updateData(id, name, category, price);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }


    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("category") &&
                getIntent().hasExtra("price")){
            //mendapatkan data dari intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            category = getIntent().getStringExtra("category");
            price = getIntent().getStringExtra("price");

            //Set data intent
            name_input.setText(name);
            category_input.setText(category);
            price_input.setText(price);
            Log.d("app", name+" "+category+" "+price );
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + "?");
        builder.setMessage("Sure to delete" + name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Helper myDB = new Helper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        builder.create().show();
    }

}
