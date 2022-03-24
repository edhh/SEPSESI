/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.util;

import java.util.Arrays;

/**
 *
 * @author sonia.ortiz
 */
public class ExpresionRegular {
    
    
    public String reemplazarCaracteresEspeciales(String palabra) {
        String[] caracteresMalos =  {"-" , "¡" , "'" , "¿" , "Ñ", "ñ", "?"};
        String[] caracteresBuenos = {"/" , "+" , "-" , "=" , ":", ";", "_"};
        for (String letraMala : caracteresMalos) {
            if(palabra.contains(letraMala)){
                palabra = palabra.replace(letraMala,caracteresBuenos[Arrays.asList(caracteresMalos).indexOf(letraMala)]);
            }
        }
        return palabra;
    }
    
    
//    public static void main(String[] args){    
//        try{
//            String s = "httpsÑ--sesiprue.sep.gob.mx-mvc-qr-validacionCredencial.jsp-JYoG03kvxvRWw2LrWZFRDvW7-wOG8-mHkDzdJr-qViBuQq34YOmwFswP7Ll0R9l0elf-zDLgzs47QncXzmnPMw¿¿";            
//            System.out.println("salida ==> " + new ExpresionRegular().reemplazarCaracteresEspeciales(s));
//        }catch(Exception e){
//            System.out.println(" e " + e.getMessage());
//        }        
//    }
    
}
