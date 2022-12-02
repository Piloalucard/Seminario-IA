/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsOn7;

import javax.swing.JOptionPane;

/**
 *
 * @author GustavoPadilla
 */
public class Gradiente {
    
    MeanSquare MS = new MeanSquare();
    
    boolean Cambiante = MS.MeanSquared();
    double b0 = MS.getB0();
    double b1 = MS.getB1();
    
    public void displayGradienteEquation(){
        
        System.out.println("                               ┌                ┐");
        System.out.println("                               │ a/aB0 ƒ(B0,B1) │");
        System.out.println("Gradient Equation ▼ƒ(B0, B1) =│                │");
        System.out.println("                               │ a/aB1 ƒ(B0,B1) │");
        System.out.println("                               └                ┘");
        
    }
    public void Error(){
        System.out.println("Error: " + String.format("%.7f", MS.getError()));
        
    }
    public double predict(){
        double Valor = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el valor a predecir"));
        double predict = (Valor * b0) + b1;
        System.out.println("Predict: " + predict);
        
        return predict;
    }
    public void Beta0(){
        System.out.println("B0: " + b0);
    }
    public void Beta1(){
        System.out.println("B1: " + b1);
        
    }
    
}
