/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author propietario
 */
public class dependencia {
 private String det;
 private String dep;
    
    public dependencia(String x,String x2){
        det=x;
        dep=x2;
    }//fin del constructor
    
    public String getDeterminante(){
        return det;
    }//fin del metodo
    
    public String getDependiente(){
        return dep;
    }
}
