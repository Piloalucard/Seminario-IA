/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author GustavoPadilla
 */

public class HandsOn6 extends Agent{
    private GUI gui;
    Gradiente gradiente = new Gradiente();
    @Override
    protected void setup() {
        System.out.println("Empezando Agente del HANDS ON 6 MLR");
        double [][] dataSet = {{23, 651}, {26, 762}, {30, 856}, {34, 1063}, {43, 1190}, {48, 1298}, {52, 1421}, {57, 1440}, {58, 1518}};
        
        gradiente = new Gradiente(dataSet);
        gui = new GUI(this);
        gui.showGui();
    }

    @Override
    protected void takeDown() {
        gui.dispose();
        System.out.println("Hands On 6 Terminando");
    }

    public void predict(final double x){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                gradiente.predictFor(x);
            }
        });
    }
    public int getNumberOfFactors(){
        return gradiente.getBetas().length;
    }
}
