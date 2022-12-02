

/**
 *
 * @author GustavoPadilla
 */
public class DataSet {
    
    double [] x = {23,26,30,34,43,48,52,57,58};
    double [] y = {651,762,856,1063,1190,1298,1421,1440,1518};
    
    double b0 = 0;
    double b1 = 0;
    double a = 0.003;
    double error = 0;
    
    public double[] getMatrizx(){
        return x;
    }
    public double[] getMatrizy(){
        return y;
    }
    public double getB0(){
        return b0;
    }
    public double getB1(){
        return b1;
    }
    public double getA(){
        return a;
    }
    public double getError(){
        return error;
    }
}
