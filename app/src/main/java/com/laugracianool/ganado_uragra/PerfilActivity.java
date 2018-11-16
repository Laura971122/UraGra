package com.laugracianool.ganado_uragra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class PerfilActivity extends AppCompatActivity {
    private TextView usuario;
    private String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle args = getIntent().getExtras();
        if (args != null) {
            correo = args.getString("correo");

        }
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //asignar el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //programar el menu
        int id = item.getItemId();
        if (id == R.id.usuario) {
            Intent i = new Intent(PerfilActivity.this, MainActivity.class);
            i.putExtra("correo", correo);
            startActivity(i);
        } else {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
}
