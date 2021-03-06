package com.example.pruebafalsamapitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Indique extends AppCompatActivity {
    TextView ori, des,fec,lat,lon;
    Button ind;
    String origen,destino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indique);
        ori = (TextView) findViewById(R.id.txt_ori);
        des = (TextView) findViewById(R.id.txt_des);
        fec = (TextView) findViewById(R.id.txt_fecha);
        lat = (TextView) findViewById(R.id.txt_lati);
        lon = (TextView) findViewById(R.id.txt_lon);
        ind = (Button) findViewById(R.id.btn_indique);

        Bundle b = getIntent().getExtras();
        origen = b.getString("SOrigen");
        destino = b.getString("SDestino");
        Double latitud = b.getDouble("Slat");
        Double lonjitud = b.getDouble("Slot");

        ori.setText("Origen: "+origen);
        des.setText("Destino: "+destino);
        lat.setText(""+latitud);
        lon.setText(""+lonjitud);

        ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),Mapa.class);
                I.putExtra("SOrigen", origen);
                I.putExtra("SDestino", destino);
                startActivity(I);
            }
        });
    }
}