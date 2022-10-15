package com.jogom.appsor.basededatos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jogom.appsor.complementos.Constantes;
import com.jogom.appsor.complementos.ConsultasDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ObjetosDAO implements ConsultasDAO, Response.Listener<JSONObject>,Response.ErrorListener {
    private Integer banderaDeUso = 0;

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
    public boolean respuestaLoggin(ObjetosVO obm,JSONObject respuesta) {
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

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
