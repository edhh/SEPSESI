/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;



/**
 *
 * @author heriberto.perez
 */
public class CuadranteVO {
    
    private Integer idCuadrante;
    
    private Integer idInmueble;
    
    private String Inmueble;
    
    private String cuadrante;

    public Integer getIdCuadrante() {
        return idCuadrante;
    }

    public void setIdCuadrante(Integer idCuadrante) {
        this.idCuadrante = idCuadrante;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }


    public String getInmueble() {
        return Inmueble;
    }

    public void setInmueble(String Inmueble) {
        this.Inmueble = Inmueble;
    }

    public String getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(String cuadrante) {
        this.cuadrante = cuadrante;
    } 
    
}
