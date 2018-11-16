package com.laugracianool.ganado_uragra;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private String correo, password;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("contactos");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Bundle args = getIntent().getExtras();

        /*if (args !=null){
            correo = args.getString("correo");
            password = args.getString("password");
        }*/

        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    public void cerrarSesionClicked(View view){
        mAuth.signOut();
        goLoginActivity();
    }

    private void goLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //asignar el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){ //programar el menu
        int id=item.getItemId();
        if (id==R.id.Perfil){
            Intent i= new Intent (MainActivity.this, PerfilActivity.class);
            i.putExtra("correo", correo);
            i.putExtra("password", password);
            startActivity(i);
        }
        else{
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
