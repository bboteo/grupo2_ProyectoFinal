
package Modelo;

import java.util.ArrayList;


public interface ConsultaOrden {
    
    public boolean insertar (OrdenVO ordenVO);
    public ArrayList<OrdenVO> consultar();
    public void eliminiar (int ordElim);
    public ArrayList<OrdenVO> actualizar(OrdenVO ordenVO);
    
}
