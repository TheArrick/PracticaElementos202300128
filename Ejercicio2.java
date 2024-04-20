
/**
 * Write a description of class Ejercicio1 here.
 *
 * @author Jose Ignacio Jaldin Janko
 * @CodigoSiss 202300128
 * 
 */
public class Ejercicio2{
    
    public boolean puedoGenerar(String[]a, String x){
        return puedoGenerar(a, x, "", 0, 0);
    }

    private boolean puedoGenerar(String[] a, String x, String aux, int y, int z){
        boolean res;
        if(z < a.length){
            if(y< a.length){
                String prueba = aux + a[y];
                if(prueba.equals(x)){
                    res = true;
                }else{
                    res = puedoGenerar(a, x, aux, y+1, z); 
                }
            }else{
                res = puedoGenerar(a, x, aux + a[z], z+1, z+1);
            }
        }else{
            res = false;
        } 
        return res;  
    }
}
