/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Gradiente {
    private double b[];
    private final double lR;
    private final int MI;
    private final double error;
    private boolean stop;
    
    public Gradiente()
    {
        this.lR = 0.0005; 
        this.MI = 100000;
        this.error = 0.00001;
        this.stop = false;
        this.b = new double[] {};
    }
    public Gradiente(double[][] data)
    {
        lR = 0.0005; 
        MI = 100000;
        error = 0.00001;
        stop = false;
        b = new double[data[0].length];
        for(int i = 0; i < b.length; i++)
        {
            b[i] = 0;
        }
        int step = 0;
        while(step < MI && !stop)
        {
            stepGradient(data);
            step++;
        }

        String string = "Paso " + step + ": ";
        for(int i = 0; i < b.length; i++)
            string += "b" + i + " = " + String.format("%.2f", b[i])+ ", ";


        string += String.format("e = %.5f", calcError(data));
        System.out.println(string);
        
        Ecuacion();
    }
    
    public final void gradientDescent(double[][] data)
    {}
    private void stepGradient(double[][] data)
    {
        if(Math.abs(calcError(data)) <= error){
            stop = true;
            return;
        }
        
        final int n = data.length;
        final int numberOfXs = data[0].length;
        double [] gradient = new double[numberOfXs];
        for(int i = 0; i < numberOfXs; i++)
            gradient[i] = 0;
        
        for(int i = 0; i < n; i++){
            double y = data[i][numberOfXs-1];
            double yHat = calcYHat(data[i]);
            
            gradient[0] += -(2.0/n) * (y - yHat);
            for(int k = 1; k < numberOfXs; k++)
                gradient[k] += -(2.0/n) * data[i][k-1] * (y - yHat);
        }
        
        for(int i = 0; i < numberOfXs; i++)
            b[i] = b[i] - (lR * gradient[i]);
    }
    private double calcError(double[][] data)
    { 
        double totalError = 0;
        for(int i = 0; i < data[0].length; i++){
            totalError += (data[i][data[i].length-1] - calcYHat(data[i]))* (data[i][data[i].length-1] - calcYHat(data[i]));
        }
        System.out.println("Error: " + totalError);
        return totalError / data.length;
    }
    private double calcYHat(double [] factor)
    {
        double yHat = b[0];
        for(int i = 0; i < factor.length - 1; i++)
            yHat += b[i+1] * factor[i];
        return yHat;
    }

    public void Ecuacion()
    {
        String equation = "Gradient descent.\nŷ = " + String.format("%.2f", b[0]);
        for(int i = 1; i < b.length; i++){
            equation += " + " + String.format("%.2f", b[i]) + "*X" + i;
        }
        System.out.println(equation);
    }

    public double predictFor(double x)
    {
        if(b.length == 0) return 0;
        double y = b[0];
        for(int i = 1; i < b.length; i++)
        {
            y += b[i] * x;
        }
        System.out.println("y = " + String.format("%.2f", y));
        return y;
    }
    public double[] getBetas(){
        return b;
    }
}
