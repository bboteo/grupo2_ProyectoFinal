package com.jr.jmproytest.basededatos;

import com.jr.jmproytest.basededatos.ObjetosVO;
import android.content.Context;
import com.android.volley.Response;
import java.util.ArrayList;
import org.json.JSONObject;

public interface ConsultasObjetos {
    public boolean consultarOrdJoin(ObjetosVO ovo, int mesa, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respOrdJoin(ObjetosVO ovo, JSONObject respuesta);

    public boolean insertarOrd(ObjetosVO ovo, Context context);

    public boolean insertarDetOrd(ObjetosVO ovo, Context context);

    public boolean consultaProd(ObjetosVO ovo, int x, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public ArrayList<ObjetosVO> respProd(JSONObject respuesta);

//    public boolean consultaUltima(ObjetosVO ovo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
//    public boolean respConsultaUltima(ObjetosVO ovo, JSONObject respuesta);

    public boolean loggin(ObjetosVO ob, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaLoggin(ObjetosVO obm, JSONObject respuesta);

}
