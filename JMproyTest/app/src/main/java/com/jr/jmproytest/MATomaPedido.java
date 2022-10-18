package com.jr.jmproytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jr.jmproytest.basededatos.ObjetosDAO;
import com.jr.jmproytest.basededatos.ObjetosVO;
import com.jr.jmproytest.complementos.Extras;

import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MATomaPedido extends AppCompatActivity implements   Response.Listener<JSONObject>, Response.ErrorListener, View.OnClickListener {
    Button btnAceptar, btnCancelar, btnServido, btnCerrarMesa;
    TextView lbMenu1, lbMenu2, lbMenu3, lbMenu4, lbMenu5, lbMenu6, lbMenu7, lbMenu8, lbMenu9;
    TextView txtNumOrden, lbMesa, lbEstadoMesa;
    EditText txtM1, txtM2, txtM3, txtM4, txtM5, txtM6, txtM7, txtM8, txtM9;

    ObjetosDAO odao = new ObjetosDAO();
    ObjetosVO ovo = new ObjetosVO();
    Extras extra = new Extras();

    //SUMATORIA
    Double totalOrden =0.0;

    //productos
    ArrayList<ObjetosVO> prodConsulta = new ArrayList<>();

    ArrayList<ObjetosVO> consUltima = new ArrayList<>();

    Integer ultimaOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matoma_pedido);
        lbMenu1 = findViewById(R.id.lbMenu1);
        lbMenu2 = findViewById(R.id.lbMenu2);
        lbMenu3 = findViewById(R.id.lbMenu3);
        lbMenu4 = findViewById(R.id.lbMenu4);
        lbMenu5 = findViewById(R.id.lbMenu5);
        lbMenu6 = findViewById(R.id.lbMenu6);
        lbMenu7 = findViewById(R.id.lbMenu7);
        lbMenu8 = findViewById(R.id.lbMenu8);
        lbMenu9 = findViewById(R.id.lbMenu9);

       txtNumOrden = findViewById(R.id.txtNumOrden);
        lbMesa = findViewById(R.id.lbMesa);
        lbEstadoMesa = findViewById(R.id.lbEstadoMesa);

        txtM1 = findViewById(R.id.txtM1);
        txtM2 = findViewById(R.id.txtM2);
        txtM3 = findViewById(R.id.txtM3);
        txtM4 = findViewById(R.id.txtM4);
        txtM5 = findViewById(R.id.txtM5);
        txtM6 = findViewById(R.id.txtM6);
        txtM7 = findViewById(R.id.txtM7);
        txtM8 = findViewById(R.id.txtM8);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnServido = findViewById(R.id.btnServido);
        btnCerrarMesa  = findViewById(R.id.btnCerrarMesa);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(this);
        btnServido.setOnClickListener(this);
        btnCerrarMesa.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        consultarProducto();

    }
// codigo
private void consultarProducto() {
        odao.consultaProd(ovo, 1, getApplicationContext(), this, this);
        Bundle bundle = getIntent().getExtras();
        Integer numMesa = bundle.getInt("nMesa");
        String estadoMesa = bundle.getString("eMesa");
        Integer idOrden = bundle.getInt("idOrden");
        this.ultimaOrd = bundle.getInt("ultOrden") +1;

        lbMesa.setText(String.valueOf(numMesa));
    Toast.makeText(this, this.ultimaOrd + " y " + idOrden, Toast.LENGTH_SHORT).show();
        if (estadoMesa.equals("libre")){

            txtNumOrden.setText(String.valueOf(ultimaOrd));
            lbEstadoMesa.setText(estadoMesa);

        }else{

            txtNumOrden.setText(String.valueOf(idOrden));
            lbEstadoMesa.setText(estadoMesa);

            Toast.makeText(this, "mesa: " + numMesa+ " orden: " +idOrden + " estado :" + estadoMesa, Toast.LENGTH_SHORT).show();
        }





//** TEMP DESDE ACA
//    prodConsulta = odao.consultarP();
//
//    this.lbMenu1.setText(prodConsulta.get(0).getNombreProducto());
//    this.lbMenu2.setText(prodConsulta.get(1).getNombreProducto());
//    this.lbMenu3.setText(prodConsulta.get(2).getNombreProducto());
//    this.lbMenu4.setText(prodConsulta.get(3).getNombreProducto());
//    this.lbMenu5.setText(prodConsulta.get(4).getNombreProducto());
//    this.lbMenu6.setText(prodConsulta.get(5).getNombreProducto());
//    this.lbMenu7.setText(prodConsulta.get(6).getNombreProducto());
//    this.lbMenu8.setText(prodConsulta.get(7).getNombreProducto());
//    //VER DONDE SE VAN A INGRESAR LAS IMAGENES.

// HASTA ACA
}

    private ArrayList<String[]> leerDatos(){
        ArrayList<String[]> tomaOrden = new ArrayList<>();
           Integer cantM1 =  Integer.parseInt(txtM1.getText().toString());
           Integer cantM2 =  Integer.parseInt(txtM2.getText().toString());
           Integer cantM3 =  Integer.parseInt(txtM3.getText().toString());
           Integer cantM4 =  Integer.parseInt(txtM4.getText().toString());
           Integer cantM5 =  Integer.parseInt(txtM5.getText().toString());
           Integer cantM6 =  Integer.parseInt(txtM6.getText().toString());
           Integer cantM7 =  Integer.parseInt(txtM7.getText().toString());
           Integer cantM8 =  Integer.parseInt(txtM8.getText().toString());

        System.out.println("METODO LEER DATOS");
        System.out.println(this.prodConsulta.get(0).getPrecioProducto());
        System.out.println("ANTES DE PRIMER CONSULTA");
        // variable = codigo,  nombre, cantidad,  precio unitario, sub Total.
        if(cantM1>0 && cantM1<100){
            Double total = Integer.parseInt(txtM1.getText().toString()) * prodConsulta.get(0).getPrecioProducto();

            String[] variable = {String.valueOf(prodConsulta.get(0).getIdProducto()) , lbMenu1.getText().toString(),  txtM1.getText().toString(), String.valueOf(prodConsulta.get(0).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM2>0 && cantM2<100){
            Double total = Integer.parseInt(txtM2.getText().toString()) * prodConsulta.get(1).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(1).getIdProducto()) , lbMenu2.getText().toString(),  txtM2.getText().toString(), String.valueOf(prodConsulta.get(1).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM3>0 && cantM3<100){
            Double total =Integer.parseInt(txtM3.getText().toString()) * prodConsulta.get(2).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(2).getIdProducto()) , lbMenu3.getText().toString(),  txtM3.getText().toString(), String.valueOf(prodConsulta.get(2).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM4>0 && cantM4<100){
            Double total =Integer.parseInt(txtM4.getText().toString()) * prodConsulta.get(3).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(3).getIdProducto()) , lbMenu4.getText().toString(),  txtM4.getText().toString(), String.valueOf(prodConsulta.get(3).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM5>0 && cantM5<100){
            Double total = Integer.parseInt(txtM5.getText().toString()) * prodConsulta.get(4).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(4).getIdProducto()) , lbMenu5.getText().toString(),  txtM5.getText().toString(), String.valueOf(prodConsulta.get(4).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM6>0 && cantM6<100){
            Double total =Integer.parseInt(txtM6.getText().toString()) * prodConsulta.get(5).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(5).getIdProducto()) , lbMenu6.getText().toString(),  txtM6.getText().toString(), String.valueOf(prodConsulta.get(5).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(cantM7>0 && cantM7<100){
            Double total = Integer.parseInt(txtM7.getText().toString()) * prodConsulta.get(6).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(6).getIdProducto()) , lbMenu7.getText().toString(),  txtM7.getText().toString(), String.valueOf(prodConsulta.get(6).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }
        if(cantM8>0 && cantM8<100){
            Double total = Integer.parseInt(txtM8.getText().toString()) * prodConsulta.get(7).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(7).getIdProducto()) , lbMenu8.getText().toString(),  txtM8.getText().toString(), String.valueOf(prodConsulta.get(7).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

// HASTA ACA

        return tomaOrden;

    }

    private void limpiar() {
        //txtDetalle.setText("");
//        txtM1.setText(0);
//        txtM2.setText(0);
//        txtM3.setText(0);
//        txtM4.setText(0);
//        txtM5.setText(0);
//        txtM6.setText(0);
//        txtM7.setText(0);
//        txtM8.setText(0);

    }


    private void cerrarMesa(int i) {

        // REGISTRO ORDEN
        ovo.setFechaRegOrd(extra.fechaHoy());
        ovo.setFkIdOrden(Integer.parseInt(txtNumOrden.getText().toString()));

        System.out.println(extra.fechaHoy());
        System.out.println(txtNumOrden.getText().toString());

        if (i == 1) {
            ovo.setFechaRegOrd(extra.fechaHoy());
            ovo.setFkIdOrden(Integer.parseInt(txtNumOrden.getText().toString()));
            ovo.setEstadoRegOrden("servida");

        }
        if (i == 2){
            ovo.setFechaRegOrd(extra.fechaHoy());
            ovo.setFkIdOrden(Integer.parseInt(txtNumOrden.getText().toString()));
            ovo.setEstadoRegOrden("libre");

        }


        if (odao.insertarOrd(ovo, getApplicationContext())){
            Toast.makeText(this, "Datos registrados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Problema al agregar la informacion", Toast.LENGTH_SHORT).show();
        }

    }


    private void insertarTomaDatos() {
//        odao.consultaUltima(ovo, getApplicationContext(), this, this );
            ultimaOrd = Integer.parseInt(txtNumOrden.getText().toString());
        //ORDEN
        ovo.setNumMesa(Integer.parseInt(lbMesa.getText().toString()));
        ovo.setSubTotal(this.totalOrden);  // total
        ovo.setFkIdUsuario(1);
        ovo.setFkIdRestaurante(2);
        ovo.setFkIdCliente(1);


        // REGISTRO ORDEN
        ovo.setFechaRegOrd(extra.fechaHoy());
        ovo.setEstadoRegOrden("orden");
        ovo.setFkIdOrden(Integer.parseInt(txtNumOrden.getText().toString()));

        if (odao.insertarOrd(ovo, getApplicationContext())) {

            // DETALLE DE ORDEN
            // variable = codigo,  nombre, cantidad,  precio unitario, sub Total.

            for(String[] valorPedido : leerDatos()) {
                ovo.setCantidadDetOrd(Integer.parseInt(valorPedido[2]));
                ovo.setSubTotalDetOrd(Double.parseDouble(valorPedido[4]));
                ovo.setFkIdOrdenDetOrd(ultimaOrd);
                ovo.setFkIdProductDetOrd(Integer.parseInt(valorPedido[0]));
                odao.insertarDetOrd(ovo, getApplicationContext());
            }

                Toast.makeText(this, "CLIENTE REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "ERROR EN EL REGISTRO", Toast.LENGTH_SHORT).show();
        }

    }



// botones
    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btnAceptar){
//            //ESCRIBIR DATOS A CAJA TEXTO
//            // variable = cantidad,  nombre,  precio unitario, sub Total.

            for(String[] valorPedido : leerDatos()){
                System.out.println(valorPedido[2] + "). " + valorPedido[1] + ".  " + " Q" + valorPedido[3] + "      SubTotal: " + valorPedido[4] + "\n");
                this.totalOrden += Double.valueOf(valorPedido[4]);
            }
            System.out.println("LLAMANDO A INSERTAR");
            insertarTomaDatos();
        }

        if (view.getId() == R.id.btnCancelar ){

            finish();
        }

        if (view.getId() == R.id.btnServido ){
            //  if ((lbEstadoMesa.getText().toString().equals("orden"))) {
                cerrarMesa(1);

//            }else{
//                Toast.makeText(this, "La mesa no tiene Orden", Toast.LENGTH_SHORT).show();
//            }

        }



        if (view.getId() == R.id.btnCerrarMesa ){
            if (!(lbEstadoMesa.getText().toString().equals("libre"))) {
                cerrarMesa(2);
            }else{
                Toast.makeText(this, "La mesa No debe estar libre para cerrar la Mesa", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

        System.out.println("SE EJECUTA EL RESPONSE");
        this.prodConsulta = odao.respProd(response);
        lbMenu1.setText(prodConsulta.get(0).getNombreProducto());
        lbMenu2.setText(prodConsulta.get(1).getNombreProducto());
        lbMenu3.setText(prodConsulta.get(2).getNombreProducto());
        lbMenu4.setText(prodConsulta.get(3).getNombreProducto());
        lbMenu5.setText(prodConsulta.get(4).getNombreProducto());
        lbMenu6.setText(prodConsulta.get(5).getNombreProducto());
        lbMenu7.setText(prodConsulta.get(6).getNombreProducto());
        lbMenu8.setText(prodConsulta.get(7).getNombreProducto());

        System.out.println("PRODCONSULTA EN EL RESPONSE");
        System.out.println(this.prodConsulta.get(0).getIdUltimaOrden());

    }

}