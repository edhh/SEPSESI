/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import mx.sep.sesi.datos.vo.ConfigUsuarioVO;

/**
 *
 * @author angel.adame
 */
public interface ConfiguracionServicio {
       
     void cambioContrasena(ConfigUsuarioVO configUsuarioVO) throws Exception;
     
}
