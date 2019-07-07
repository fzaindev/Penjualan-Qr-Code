package com.example.mydashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MenuUtama extends AppCompatActivity {
    private CardView btAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        /*Toast*/
        CardView daftar_barang = (CardView)
                findViewById(R.id.daftar_barang);
        daftar_barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtama.this, Daftar_Barang.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Daftar Barang", Toast.LENGTH_LONG).show();
            }
        });

        CardView stok_barang = (CardView)
                findViewById(R.id.stok_barang);
        stok_barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtama.this, UpdateBarang.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Stok Barang", Toast.LENGTH_LONG).show();
            }
        });

        CardView scan = (CardView)
                findViewById(R.id.scan_code);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtama.this, Scan.class);
                startActivity(intent);
            }
        });

        /*Tombol Pesan Allert*/
        btAlert = (CardView) findViewById(R.id.bt_allert);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MenuUtama.super.onBackPressed();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    /*Akhir Tombol Pesan Allert*/

    /*Pesan Allert Tombol Kembali*/
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MenuUtama.super.onBackPressed();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    /*Akhir Pesan Allert Tombol Kembali*/

}
