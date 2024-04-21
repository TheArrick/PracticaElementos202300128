/**
 * Write a description of class Ejercicio1 here.
 *
 * @author Jose Ignacio Jaldin Janko
 * @CodigoSiss 202300128
 * 
 */
public class Ejercicio3{

    public String simular(int n, int m, int cx, int cy, int tx, int ty){
        String res;

        String[][] chess = new String[n][m];
        if(valida(cx,cy, chess) && valida(tx, ty, chess)){
            for(int i=0;i<=n-1;i++){
                for(int j=0;j<=m-1;j++){
                    chess[i][j]="*";
                }
            }
            res = simular(chess, cx, cy, tx, ty);

        }else{
            res = "No valido";
        }
        return res;
    }
    
    private String simular(String[][] chess, int cx, int cy, int tx, int ty){
        String res;
        if(valida(cx, cy, chess)){
            if(cx == tx && cy == ty){
                res = "First";
            }else if(cx == tx || cy == ty){
                res = "Second";
            }else if(chess[cx][cy] == ""){
                //Visitado
                chess[cx][cy] = "V";
                res = simular(chess, cx-1, cy+2, tx, ty);
                if(res == "Draw"){
                    res = simular(chess, cx+1, cy+2, tx, ty);
                    if(res == "Draw"){
                        res = simular(chess, cx+2, cy+1, tx, ty);
                        if(res == "Draw"){
                            res = simular(chess, cx+2, cy-1, tx, ty);
                            if(res == "Draw"){
                                res = simular(chess, cx+1, cy-2, tx, ty);
                                if(res == "Draw"){
                                    res = simular(chess, cx-1, cy-2, tx, ty);
                                    if(res == "Draw"){
                                        res = simular(chess, cx-2, cy-1, tx, ty);
                                        if(res == "Draw"){
                                            res = simular(chess, cx-2, cy+1, tx, ty);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                chess[cx][cy] = "";
            }else{
                res = "Draw";
            }
        }else{
            res = "Draw";
        }
        return res;
    }

    public boolean valida(int x, int y, String [][]maze){
    
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
