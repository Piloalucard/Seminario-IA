/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsOn7;

/**
 *
 * @author ANGEL
 */
class HelperArithmetic {
    
    DataSet DS = new DataSet();
    
    double [] aux = DS.getMatrizx();
    double [] auy = DS.getMatrizy();
    double CalcularB0;
    double CalcularB1;
    
    public double CalcularB0(double b0, double b1){
        for(int i = 0; i < 9; i++){
            CalcularB0 =+ (auy[i] - (b0 + b1 * aux[i]));
        }
        CalcularB0 = -2 * CalcularB0 / 9;
        return CalcularB0;
    }
    public double CalcularB1(double b0, double b1){
        for(int i = 0; i < 9; i++){
            CalcularB1 =+ (auy[i] - (b0 + b1 * aux[i]));
        }
        return CalcularB1;
    }
}
