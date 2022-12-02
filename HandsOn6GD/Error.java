/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.pow;
/**
 *
 * @author GustavoPadilla
 */
public class Error {
    
    DataSet DS = new DataSet();
    
    double [] aux = DS.getMatrizx();
    double [] auy = DS.getMatrizy();
    double Error;
    
    public double Error(double b0, double b1){
        for(int i=0; i<9; i++){ // i<9
            Error = pow((auy[i] - (b0 + b1 * aux[i])), 2);
        }
        Error = 1 * Error/9;
        return Error;
    }
    
}
