package com.jr.jmproytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jr.jmproytest.basededatos.ObjetosDAO;
import com.jr.jmproytest.basededatos.ObjetosVO;

import org.json.JSONObject;

public class MALogin extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private EditText editTextUsr, editTextPass;
    private Button button;
    private ObjetosDAO odao = new ObjetosDAO();
    private ObjetosVO ob = new ObjetosVO();
    private String password, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malogin);

        editTextUsr = findViewById(R.id.edtUsuario);
        editTextPass = findViewById(R.id.edtContra);
        button = findViewById(R.id.btnIngresar);
        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }


    private void login(){
        if(!editTextUsr.getText().toString().isEmpty() && !editTextPass.getText().toString().isEmpty()){
            ob.setUsr(editTextUsr.getText().toString()) ;
            ob.setContra(editTextPass.getText().toString());
            if (!odao.loggin(ob, getApplicationContext(),this,this)){
                Toast.makeText(this, "Error de comunicacion", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Cargando...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        if(odao.respuestaLoggin(ob,response)){
            Intent intent = new Intent(getApplicationContext(), MAMesas.class);
            startActivity(intent);
        }
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }


}