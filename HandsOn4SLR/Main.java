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


public class Handson4Agent extends Agent{
    private Handson4GUI gui;
    SLR slr = new SLR();
    @Override
    protected void setup(){
        System.out.println("Empezando Agente del HANDS ON 4 SLR");
        double [][] dataSet = {{23, 651}, {26, 762}, {30, 856}, {34, 1063}, {43, 1190}, {48, 1298}, {52, 1421}, {57, 1440}, {58, 1518}};
        slr = new SLR(dataSet);
        gui = new Handson4GUI(this);
        gui.showGui();
    }

    @Override
    protected void takeDown(){
		gui.dispose();
        System.out.println("Hands On 4"+getAID().getName()+" Terminando");
    }

    public void predict(final double factor){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                slr.predict(new double[]{factor});
            }
        });
    }
}