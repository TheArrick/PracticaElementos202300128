/**
 * Write a description of class Ejercicio1 here.
 *
 * @author Jose Ignacio Jaldin Janko
 * @CodigoSiss 202300128
 * 
 */
public class Ejercicio1{
   
    public boolean puedoSalir(int n, String [][] maze){     
        return puedoSalir(0, 0, maze);
    } 



    private boolean puedoSalir(int x, int y, String [][]maze){
        boolean res;
        if(valida(x, y, maze)){
            if(maze[x][y] == "E"){
                res = true;
            }else if(maze[x][y] == "*" || maze[x][y]== "S"){
                maze[x][y] = "H";
                res = buscar(x-1, y, maze);
                if(!res){
                    res = buscar(x, y+1,maze);
                    if(!res){
                        res = buscar(x+1, y, maze);
                        if(!res){
                            res = buscar(x, y-1, maze);
                        }
                    }
                }
                maze[x][y] = "*";
            }else{
                res = false;
            }
        }else{
            res = false;
        }
        return res;
    }

    public boolean valida(int x, int y, String [][]maze){
    
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

}
