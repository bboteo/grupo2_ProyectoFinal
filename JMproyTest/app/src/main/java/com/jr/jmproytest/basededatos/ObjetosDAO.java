package com.jr.jmproytest.basededatos;

import android.content.Context;
import android.widget.Toast;

import com.jr.jmproytest.complementos.Constantes;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ObjetosDAO implements ConsultasObjetos, Response.Listener<JSONObject>, Response.ErrorListener {
    private Integer banderaDeUso = 0;

    @Override
    public boolean consultarOrdJoin(ObjetosVO ovo, int mesa, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        //ArrayList<ObjetosVO> consultaOrden = new ArrayList<>();
          boolean resultado = false;
            try {
                String url = Constantes.IPSERVER+"Api/consOrdJ.php?nMesa="+mesa;
                RequestQueue requestQueue = Volley.newRequestQueue(context);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                        listener, errorListener);
                requestQueue.add(jsonObjectRequest);
                resultado = true;
            }
            catch (Exception e){
                Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            return resultado;
    }



    @Override
    public boolean respOrdJoin(ObjetosVO ovo, JSONObject respuesta) {
        boolean resultado = false;
        JSONArray jsonArray = respuesta.optJSONArray("orden");
        try{
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            ovo.setNumMesa(jsonObject.optInt("num_mesa"));
            ovo.setJoinEstadoOrden(jsonObject.optString("estado_orden"));
            ovo.setIdOrden(jsonObject.optInt("id_orden"));
            ovo.setJoinIdRegistro(jsonObject.optInt("id_registro"));
            String identificadorError = jsonObject.optString("error");
            if(identificadorError.isEmpty()){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return  resultado;
    }

    @Override
    public boolean insertarOrd(ObjetosVO ovo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.INSERTAR;
        // orden
        try{
            String url = Constantes.IPSERVER+"Api/insertTomaOrd.php?nMesa="+ovo.getNumMesa()+"&tVenta="+ovo.getSubTotal()+"&fIdUsuario="+ ovo.getFkIdUsuario()+"&fIdRestaurant="+ovo.getFkIdRestaurante()+"&fIdCliente="+ovo.getFkIdCliente();
            RequestQueue requestQueue = Volley.newRequestQueue(context);//define el acceso a la activity para salir a consumir el servicio
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, null, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        //reg ord
        try{
            String url = Constantes.IPSERVER+"Api/insertRegOrd.php?fechaOrd="+ovo.getFechaRegOrd()+"&estOrd="+ovo.getEstadoRegOrden()+"&fIdOrd="+ ovo.getFkIdOrden();
            RequestQueue requestQueue = Volley.newRequestQueue(context);//define el acceso a la activity para salir a consumir el servicio
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, null, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public boolean insertarDetOrd(ObjetosVO ovo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.INSERTAR;

        // detalle orden
        try{
            String url = Constantes.IPSERVER+"Api/insertDetOrd.php?cantDetOrd="+ovo.getCantidadDetOrd()+"&subTotDetOrd="+ovo.getSubTotalDetOrd()+"&fIdOrdDetOrd="+ ovo.getFkIdOrdenDetOrd()+"&fIdProdDetOrd="+ ovo.getFkIdProductDetOrd();
            RequestQueue requestQueue = Volley.newRequestQueue(context);//define el acceso a la activity para salir a consumir el servicio
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, null, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return resultado;

    }
////
    @Override
    public boolean consultaProd(ObjetosVO ovo, int x, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        if (x == 1) {
            try {
                String url = Constantes.IPSERVER + "Api/consProd.php?";
                RequestQueue requestQueue = Volley.newRequestQueue(context);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        listener, errorListener);
                requestQueue.add(jsonObjectRequest);
                resultado = true;
            } catch (Exception e) {
                Toast.makeText(context, "Error en la conexion " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        return resultado;
    }

    @Override
    public ArrayList<ObjetosVO> respProd(JSONObject respuesta) {

        ArrayList<ObjetosVO> arrayListVO = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("producto");
        try{
            for (int i =0; i<jsonArray.length(); i++) {
           // for (int i =0; i<9; i++) {
                ObjetosVO ovo = new ObjetosVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ovo.setIdProducto(jsonObject.optInt("id_producto"));
                ovo.setNombreProducto(jsonObject.optString("nombre"));
                ovo.setPrecioProducto(jsonObject.optDouble("precio"));
                ovo.setDescripcProducto(jsonObject.optString("descripcion"));
                arrayListVO.add(ovo);
            }

        }catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return  arrayListVO;
    }

    @Override
    public boolean loggin(ObjetosVO ob, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;

        try {
            String url = Constantes.IPSERVER+"Api/loggin.php?usr="+ob.getUsr()+"&contrasena="+ob.getContra();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(json);
            resultado = true;
        }catch (Exception e){
            Toast.makeText(context, "Error en la conexion"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public boolean respuestaLoggin(ObjetosVO obm, JSONObject respuesta) {
        boolean resultado = false;
        JSONArray jsonArray = respuesta.optJSONArray("login");
        try{
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            obm.setUsr(jsonObject.optString("usr"));
            obm.setContra(jsonObject.optString("contrasena"));

            String identificadorError = jsonObject.optString("error");
            if(identificadorError.isEmpty()){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return  resultado;
    }


//    @Override
//    public boolean consultaUltima(ObjetosVO ovo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
//        boolean resultado = false;
//        try {
//            String url = Constantes.IPSERVER+"Api/consUltima.php?";
//            RequestQueue requestQueue = Volley.newRequestQueue(context);
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
//                    listener, errorListener);
//            requestQueue.add(jsonObjectRequest);
//            resultado = true;
//        }
//        catch (Exception e){
//            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        return resultado;
//    }

//    @Override
//    public boolean respConsultaUltima(ObjetosVO ovo, JSONObject respuestas) {
//        boolean resultado = false;
//        JSONArray jsonArray = respuestas.optJSONArray("orden");
//        try{
//            JSONObject jsonObject = jsonArray.getJSONObject(0);
//            ovo.setIdUltimaOrden(jsonObject.optInt("id_orden"));
//            String identificadorError = jsonObject.optString("error");
//            if(identificadorError.isEmpty()){
//                resultado = true;
//            }
//            else{
//                resultado = false;
//            }
//        }catch (JSONException e){
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        }
//        return  resultado;
//    }



















    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso){
            case 1://INSERTAR
                System.err.println(error);
                break;
            case 2://ACTUALIZAR
                System.err.println(error);
                break;
            case 3:
                System.err.println(error);
                break;
        }

    }

    @Override
    public void onResponse(JSONObject response) {
        switch (banderaDeUso){

        }

    }
}


