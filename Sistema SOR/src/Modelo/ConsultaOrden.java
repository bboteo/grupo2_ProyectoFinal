
package Modelo;

import java.util.ArrayList;


public interface ConsultaOrden {
    
    public boolean insertar (OrdenVO ordenVO);
    public ArrayList<OrdenVO> consultar(int mesa);
     public ArrayList<OrdenVO> consultarJoin(int mesa);
     public OrdenVO consultaUltimaOrd();
    public void eliminiar (int ordVOElim);
    public boolean actualizarXfac(OrdenVO ovo);
    
}
