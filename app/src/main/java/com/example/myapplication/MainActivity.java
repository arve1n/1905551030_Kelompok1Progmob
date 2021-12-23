package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText TextNama;
    EditText TextNo;
    EditText TextEmail;
    EditText TextAlamat;
    RadioGroup rg;
    RadioButton rb;
    SeekBar sb;
    TextView umur;
    CheckBox cb1, cb2, cb3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextNama = (EditText) findViewById(R.id.TextNama);
        TextNo = (EditText) findViewById(R.id.TextNo);
        TextEmail = (EditText) findViewById(R.id.TextEmail);
        TextAlamat = (EditText) findViewById(R.id.TextAlamat);

        //jenis kelamin
        rg = findViewById(R.id.rg);

        //umur
        sb = findViewById(R.id.sb);
        umur = findViewById(R.id.umur);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                umur.setText(String.valueOf(progress + "Tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //checkbox
        cb1 = (CheckBox) findViewById(R.id.kategori1);
        cb2 = (CheckBox) findViewById(R.id.kategori2);
        cb3 = (CheckBox) findViewById(R.id.kategori3);

    }


    public void submit(View view) {
        int radio = rg.getCheckedRadioButtonId();
        rb = findViewById(radio);


        String nama = TextNama.getText().toString();
        String no = TextNo.getText().toString();
        String email = TextEmail.getText().toString();
        String alamat = TextAlamat.getText().toString();
        String jeniskelamin = rb.getText().toString();
        String umur1 = umur.getText().toString();
        String kategori = "";

        //checkbox
        if (cb1.isChecked()) {
            kategori += "Gitar, ";
        }
        if (cb2.isChecked()) {
            kategori += "Bass, ";
        }
        if (cb3.isChecked()) {
            kategori += "Drum, ";
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selamat Datang !!!");
        builder.setMessage("Nama : " + String.valueOf(nama) + "\n" + "No Telp :" + String.valueOf(no)
                + "\n" + "Email :" + String.valueOf(email)
                + "\n" + "Alamat :" + String.valueOf(alamat) + "\n" + "Jenis Kelamin :" + String.valueOf(jeniskelamin)
                + "\n" + "Umur :" + String.valueOf(umur1) + "\n" + "Produk Pesanan :" + String.valueOf(kategori)).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openActivity2();
                    }
                });

        AlertDialog dialoghasil = builder.create();
        dialoghasil.show();


    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);

        int radio = rg.getCheckedRadioButtonId();
        rb = findViewById(radio);


        String nama = TextNama.getText().toString();
        String no = TextNo.getText().toString();
        String email = TextEmail.getText().toString();
        String alamat = TextAlamat.getText().toString();
        String jeniskelamin = rb.getText().toString();
        String umur1 = umur.getText().toString();
        String kategori = "";

        //checkbox
        if (cb1.isChecked()) {
            kategori += "Gitar, ";
        }
        if (cb2.isChecked()) {
            kategori += "Bass, ";
        }
        if (cb3.isChecked()) {
            kategori += "Drum, ";
        }
            intent.putExtra("nama", nama);
            intent.putExtra("no", no);
            intent.putExtra("email", email);
            intent.putExtra("alamat", alamat);
            intent.putExtra("jeniskelamin", jeniskelamin);
            intent.putExtra("umur1", umur1);
            intent.putExtra("kategori", kategori);

        startActivity(intent);
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Registrasi dimulai",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Registrasi sedang berjalan",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Registrasi berhenti sementara",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Registrasi berhenti",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Aplikasi ditutup, selamat tinggal",Toast.LENGTH_SHORT).show();
    }
}
