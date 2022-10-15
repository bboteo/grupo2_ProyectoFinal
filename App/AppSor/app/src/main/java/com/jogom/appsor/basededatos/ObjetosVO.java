package com.jogom.appsor.basededatos;

public class ObjetosVO {
    private String usr;
    private String Contra;

    public ObjetosVO() {

    }

    public ObjetosVO(String usr, String contra) {
        this.usr = usr;
        Contra = contra;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String contra) {
        Contra = contra;
    }
}
