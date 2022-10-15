package com.jogom.appsor.complementos;

import android.content.Context;

import com.android.volley.Response;
import com.jogom.appsor.basededatos.ObjetosVO;

import org.json.JSONObject;

import java.util.ArrayList;

public interface ConsultasDAO {
    public boolean loggin(ObjetosVO ob, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaLoggin(ObjetosVO obm, JSONObject respuesta);
}
