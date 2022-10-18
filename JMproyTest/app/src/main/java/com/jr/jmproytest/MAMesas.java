package com.jr.jmproytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jr.jmproytest.basededatos.ObjetosDAO;
import com.jr.jmproytest.basededatos.ObjetosVO;
import com.jr.jmproytest.complementos.Extras;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class MAMesas extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener, View.OnClickListener {
    ObjetosDAO odao = new ObjetosDAO();
    ObjetosVO ovo = new ObjetosVO();
    Extras extra = new Extras();


    Button btnActualizar;
    ImageButton btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9;
    TextView txtTimeM1, txtTimeM2, txtTimeM3, txtTimeM4, txtTimeM5 ,txtTimeM6 ,txtTimeM7, txtTimeM8, txtTimeM9, jlbNombre, jlbFecha;

    Timer timer;
    TimerTask timerTask;
    int miTime = 0;


    String[] estadoMesa = {"libre","libre","libre","libre","libre","libre","libre","libre","libre","libre"};   //new String[10];   // los unos son temporales para simular el estado.
    //String[] estadoMesa = new String[10];
            Integer ultimaOrd =0;
            Integer[] numeroOrden = new Integer[10];
            String usuario = "XXXXX";


    Integer[] tM1 = {0,0,0}, tM2 = {0,0,0}, tM3 = {0,0,0}, tM4 = {0,0,0};
    Integer[] tM5 = {0,0,0}, tM6 = {0,0,0}, tM7 = {0,0,0}, tM8 = {0,0,0}, tM9 = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamesas);

        txtTimeM1 = findViewById(R.id.txtTimeM1);
        txtTimeM2 = findViewById(R.id.txtTimeM2);
        txtTimeM3 = findViewById(R.id.txtTimeM3);
        txtTimeM4 = findViewById(R.id.txtTimeM4);
        txtTimeM5 = findViewById(R.id.txtTimeM5);
        txtTimeM6 = findViewById(R.id.txtTimeM6);
        txtTimeM7 = findViewById(R.id.txtTimeM7);
        txtTimeM8 = findViewById(R.id.txtTimeM8);
        txtTimeM9 = findViewById(R.id.txtTimeM9);
        jlbNombre = findViewById(R.id.jlbNombre);
        jlbFecha = findViewById(R.id.jlbFecha);

        btnMesa1 = findViewById(R.id.btnMesa1);
        btnMesa2 = findViewById(R.id.btnMesa2);
        btnMesa3 = findViewById(R.id.btnMesa3);
        btnMesa4 = findViewById(R.id.btnMesa4);
        btnMesa5 = findViewById(R.id.btnMesa5);
        btnMesa6 = findViewById(R.id.btnMesa6);
        btnMesa7 = findViewById(R.id.btnMesa7);
        btnMesa8 = findViewById(R.id.btnMesa8);
        btnMesa9 = findViewById(R.id.btnMesa9);
        btnActualizar = findViewById(R.id.btnActualizar);

        btnMesa1.setOnClickListener(this);
        btnMesa2.setOnClickListener(this);
        btnMesa3.setOnClickListener(this);
        btnMesa4.setOnClickListener(this);
        btnMesa5.setOnClickListener(this);
        btnMesa6.setOnClickListener(this);
        btnMesa7.setOnClickListener(this);
        btnMesa8.setOnClickListener(this);
        btnMesa9.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);

        timer = new Timer();
        crono();

        estadoMesas();
    }

// CRONOMETRO


    public Integer[] cronometro(Integer hor, Integer min, Integer seg){

        Integer timeCronometro[] = new Integer[3];

        seg +=1;
        if((seg != 0)&&(seg%60 == 0)){
            ++min;
            seg = 0;
            if(min%60 == 0){
                min=0;
                ++hor;
                if(hor%60 == 0){
                    hor = 0;
                }
            }
        }
        timeCronometro[0] = seg;
        timeCronometro[1] = min;
        timeCronometro[2] = hor;


        return timeCronometro;
    }



    private void crono(){

        timerTask =  new TimerTask(){
          @Override
            public void run(){
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      //miTime++;
                     // txtTimeM1.setText(String.valueOf(miTime));


                    if(estadoMesa[1].equals("orden")){
                    tM1 = cronometro(tM1[2], tM1[1], tM1[0]);

                    }
                    else{
                    tM1[0] = 0;
                    tM1[1] = 0;
                    tM1[2] = 0;
                    }
                    if(estadoMesa[2].equals("orden") ){
                    tM2 = cronometro(tM2[2], tM2[1], tM2[0]);
                    } else {
                    tM2[0] = 0;
                    tM2[1] = 0;
                    tM2[2] = 0;
                    }

                    if(estadoMesa[3].equals("orden")){
                    tM3 = cronometro(tM3[2], tM3[1], tM3[0]);
                    } else {
                    tM3[0] = 0;
                    tM3[1] = 0;
                    tM3[2] = 0;
                    }

                    if(estadoMesa[4].equals("orden")){
                    tM4 = cronometro(tM4[2], tM4[1], tM4[0]);

                    } else {
                    tM4[0] = 0;
                    tM4[1] = 0;
                    tM4[2] = 0;
                    }

                    if(estadoMesa[5].equals("orden")){
                    tM5 = cronometro(tM5[2], tM5[1], tM5[0]);
                    } else {
                    tM5[0] = 0;
                    tM5[1] = 0;
                    tM5[2] = 0;
                    }

                    if(estadoMesa[6].equals("orden")){
                    tM6 = cronometro(tM6[2], tM6[1], tM6[0]);
                    } else {
                    tM6[0] = 0;
                    tM6[1] = 0;
                    tM6[2] = 0;
                    }

                    if(estadoMesa[7].equals("orden")){
                    tM7 = cronometro(tM7[2], tM7[1], tM7[0]);
                    } else {
                    tM7[0] = 0;
                    tM7[1] = 0;
                    tM7[2] = 0;
                    }

                    if(estadoMesa[8].equals("orden")){
                    tM8 = cronometro(tM8[2], tM8[1], tM8[0]);
                    } else {
                    tM8[0] = 0;
                    tM8[1] = 0;
                    tM8[2] = 0;
                    }

                    if(estadoMesa[9].equals("orden")){
                    tM9 = cronometro(tM9[2], tM9[1], tM9[0]);
                    } else {
                    tM9[0] = 0;
                    tM9[1] = 0;
                    tM9[2] = 0;
                    }

        txtTimeM1.setText((tM1[2]<10? ("0"+tM1[2]):(tM1[2]))+ ":"+(tM1[1]<10? ("0"+tM1[1]):(tM1[1]))+ ":"+ (tM1[0]<10 ? ("0"+ tM1[0]): (tM1[0])) );
        txtTimeM2.setText((tM2[2]<10? ("0"+tM2[2]):(tM2[2]))+ ":"+(tM2[1]<10? ("0"+tM2[1]):(tM2[1]))+ ":"+ (tM2[0]<10 ? ("0"+ tM2[0]): (tM2[0])) );
        txtTimeM3.setText((tM3[2]<10? ("0"+tM3[2]):(tM3[2]))+ ":"+(tM3[1]<10? ("0"+tM3[1]):(tM3[1]))+ ":"+ (tM3[0]<10 ? ("0"+ tM3[0]): (tM3[0])) );
        txtTimeM4.setText((tM4[2]<10? ("0"+tM4[2]):(tM4[2]))+ ":"+(tM4[1]<10? ("0"+tM4[1]):(tM4[1]))+ ":"+ (tM4[0]<10 ? ("0"+ tM4[0]): (tM4[0])) );
        txtTimeM5.setText((tM5[2]<10? ("0"+tM5[2]):(tM5[2]))+ ":"+(tM5[1]<10? ("0"+tM5[1]):(tM5[1]))+ ":"+ (tM5[0]<10 ? ("0"+ tM5[0]): (tM5[0])) );
        txtTimeM6.setText((tM6[2]<10? ("0"+tM6[2]):(tM6[2]))+ ":"+(tM6[1]<10? ("0"+tM6[1]):(tM6[1]))+ ":"+ (tM6[0]<10 ? ("0"+ tM6[0]): (tM6[0])) );
        txtTimeM7.setText((tM7[2]<10? ("0"+tM7[2]):(tM7[2]))+ ":"+(tM7[1]<10? ("0"+tM7[1]):(tM7[1]))+ ":"+ (tM7[0]<10 ? ("0"+ tM7[0]): (tM7[0])) );
        txtTimeM8.setText((tM8[2]<10? ("0"+tM8[2]):(tM8[2]))+ ":"+(tM8[1]<10? ("0"+tM8[1]):(tM8[1]))+ ":"+ (tM8[0]<10 ? ("0"+ tM8[0]): (tM8[0])) );
        txtTimeM9.setText((tM9[2]<10? ("0"+tM9[2]):(tM9[2]))+ ":"+(tM9[1]<10? ("0"+tM9[1]):(tM9[1]))+ ":"+ (tM9[0]<10 ? ("0"+ tM9[0]): (tM9[0])) );

                  }
              });

          }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }




    //// DIBUJAR MESA

    public void dibujarMesa(){


        for(int i=1 ; i<=9; i++){

            switch(i){
                case 1: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa1.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa1.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa1.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa1.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }

                    break;
                }
                case 2: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa2.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa2.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa2.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa2.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;
                }

                case 3: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa3.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa3.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa3.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa3.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa4.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa4.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa4.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa4.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;
                }

                case 5: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa5.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa5.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa5.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa5.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;

                }

                case 6: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa6.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa6.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa6.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa6.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;

                }

                case 7: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa7.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa7.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa7.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa7.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;

                }

                case 8: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa8.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa8.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa8.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa8.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;

                }

                case 9: {
                    if(this.estadoMesa[i].equals("libre")){  btnMesa9.setImageResource(R.drawable.ic_mesa_gris100);
                    }else {
                        if(this.estadoMesa[i].equals("orden")){  btnMesa9.setImageResource(R.drawable.ic_mesa_amarillo100);
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  btnMesa9.setImageResource(R.drawable.ic_mesa_azul100);
                            }else{
                                btnMesa9.setImageResource(R.drawable.ic_mesa_verde100);
                            }
                        }
                    }
                    break;
                }
            }
        }
    }


    private void estadoMesas(){


        //ESTADO INICIAL
        for(int i=1 ; i<=9; i++){
                System.out.println(odao.consultarOrdJoin(ovo, i, getApplicationContext(), this, this));
        }


        this.usuario = jlbNombre.getText().toString();
       jlbFecha.setText(extra.fechaHoy());
    }


    private void leerPedido(int x) {

        Intent intent = new Intent(getApplicationContext(), MATomaPedido.class);
        intent.putExtra("nMesa", x);
        intent.putExtra("eMesa", this.estadoMesa[x]);
        intent.putExtra("idOrden", this.numeroOrden[x]);
        intent.putExtra("ultOrden", ultimaOrd);

        startActivity(intent);




        //vRegOrd.lbUsuario.setText(usuario);
        //si  this.vRegOrd.lbMesa.setText(String.valueOf(x));
//si        this.vRegOrd.lbFecha.setText(extra.fechaHoy());
//si        this.vRegOrd.lbEstadoMesa.setText(this.estadoMesa[x]);



        // MESA LIBRE

        if(estadoMesa[x].equals("libre")){
        //s    this.vRegOrd.setVisible(true);

            //Nueva Orden
         //si   ordenVO = ordenDAO.consultaUltimaOrd();
         //si   Integer nuevaOrden = ordenVO.getIdOrden() +1;
        //si    this.vRegOrd.txtNumOrden.setText(String.valueOf(nuevaOrden));
        //si    this.vRegOrd.setLocationRelativeTo(vMesa);



            // MESA CON ORDEN DE PEDIDO EN CUALQUIER ESTADO
        }else{
            //si  this.vRegOrd.setVisible(true);
         //si   this.vRegOrd.setLocationRelativeTo(vMesa);


//si            for(OrdenVO ovo: ordenDAO.consultar(numeroOrden[x])){   // de aca
//si                vRegOrd.txtNumOrden.setText(String.valueOf(ovo.getIdOrden()));

//si                vRegOrd.lbMesa.setText(String.valueOf(ovo.getNumMesa()));
//si                vRegOrd.txtDetalle.append("MONTO TOTAL: " + String.valueOf(ovo.getSubTotal()) + " \n");
            }

 //si           for(DetalleOrdenVO dovo : dodao.consultar(numeroOrden[x])){


 //si               vRegOrd.txtDetalle.append(String.valueOf(dovo.getCantidad())+ " DE: ");
//si                pvo.setIdProducto(dovo.getFkIdProducto());
//si                vRegOrd.txtDetalle.append(pdao.consultaExactaP(pvo).get(0).getNombreProducto());///


 //si               vRegOrd.txtDetalle.append(" SUBTOTAL: " +String.valueOf(dovo.getSubTotal()) + "\n");

   //si         }   //hasta aca

//si        }
    }



    @Override
    public void onClick(View view) {

        //MESA 1
        if (view.getId() == R.id.btnMesa1){
            leerPedido(1);
        }

        //MESA 2
        if (view.getId() == R.id.btnMesa2){
            leerPedido(2);
        }

        if (view.getId() == R.id.btnMesa3){
            leerPedido(3);
        }

        if (view.getId() == R.id.btnMesa4){
            leerPedido(4);
        }

        if (view.getId() == R.id.btnMesa5){
            leerPedido(5);
        }

        if (view.getId() == R.id.btnMesa6){
            leerPedido(6);
        }

        if (view.getId() == R.id.btnMesa7){
            leerPedido(7);
        }

        if (view.getId() == R.id.btnMesa8){
            leerPedido(8);
        }

        if (view.getId() == R.id.btnMesa9){
            leerPedido(9);
        }

        //ACTUALIZAR
        if(view.getId() == R.id.btnActualizar){
            estadoMesas();
            dibujarMesa();
        }
    }


    @Override
    public void onResponse(JSONObject response) {

        if(odao.respOrdJoin(ovo, response) ) {

            if ((ovo.getNumMesa() != 0));
            this.estadoMesa[ovo.getNumMesa()] = ovo.getJoinEstadoOrden();
            this.numeroOrden[ovo.getNumMesa()] = ovo.getIdOrden();


            if (ultimaOrd<ovo.getIdOrden()) {
                this.ultimaOrd = ovo.getIdOrden();
            }
        }
    }



    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }


}

