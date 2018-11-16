package com.laugracianool.ganado_uragra;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText Correo_Electronico, ContraseñaR, RepContraseña;
    private Button bRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Correo_Electronico = findViewById(R.id.Correo_Electronico);
        ContraseñaR = findViewById(R.id.ContraseñaR);
        RepContraseña = findViewById(R.id.RepContraseña);
        bRegistrarse = findViewById(R.id.bRegistrarse);

        bRegistrarse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String correo,contraseña,rcontraseña;

                correo = Correo_Electronico.getText().toString();
                contraseña = ContraseñaR.getText().toString();
                rcontraseña = RepContraseña.getText().toString();

                if (correo.equals("") || contraseña.equals("") || rcontraseña.equals(""))
                    Toast.makeText(getApplicationContext(), "Debe de digitar todos los campos",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Cuenta creada exitosamente",Toast.LENGTH_SHORT).show();
                if (contraseña.equals(rcontraseña));
                else
                    Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RegistrarseClicked(View view) {

        Intent i = new Intent(RegistroActivity.this, LoginActivity.class);
        i.putExtra("correo",Correo_Electronico.getText().toString());
        i.putExtra("contraseña",ContraseñaR.getText().toString());
        setResult(RESULT_OK,i);
        finish();

    }
}
