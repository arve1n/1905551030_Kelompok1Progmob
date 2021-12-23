package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView showNama, showNo, showEmail, showAlamat, showJK, showUmur, showKategori;
    String nama, no, email, alamat, jeniskelamin, umur1, kategori;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        showNama = (TextView) findViewById(R.id.showNama);
        showNo = (TextView) findViewById(R.id.showNo);
        showEmail = (TextView) findViewById(R.id.showEmail);
        showAlamat = (TextView) findViewById(R.id.showAlamat);
        showJK = (TextView) findViewById(R.id.showJK);
        showUmur = (TextView) findViewById(R.id.showUmur);
        showKategori = (TextView) findViewById(R.id.showKategori);

        //validasi, menyimpan nilai variabel dari intent, set text pada textview untuk menampilkan nilai
        if (getIntent().getStringExtra("nama") != "") {
            nama = getIntent().getStringExtra("nama");
            showNama.setText(nama);
        }
        if (getIntent().getStringExtra("no") != "") {
            no = getIntent().getStringExtra("no");
            showNo.setText(no);
        }
        if (getIntent().getStringExtra("email") != "") {
            email = getIntent().getStringExtra("email");
            showEmail.setText(email);
        }
        if (getIntent().getStringExtra("alamat") != "") {
            alamat = getIntent().getStringExtra("alamat");
            showAlamat.setText(alamat);
        }
        if (getIntent().getStringExtra("jeniskelamin") != "") {
            jeniskelamin = getIntent().getStringExtra("jeniskelamin");
            showJK.setText(jeniskelamin);
        }
        if (getIntent().getStringExtra("umur1") != "") {
            umur1 = getIntent().getStringExtra("umur1");
            showUmur.setText(umur1);
        }
        if (getIntent().getStringExtra("kategori") != "") {
            kategori = getIntent().getStringExtra("kategori");
            showKategori.setText(kategori);
        }
    }

    //button kembali
    public void Kembali (View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Tampilan profil dimulai",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Tampilan profil sedang berjalan",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Tampilan profil berhenti sementara",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Tampilan profil berhenti",Toast.LENGTH_SHORT).show();
    }

}
