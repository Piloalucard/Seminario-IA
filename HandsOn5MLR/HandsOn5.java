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


public class HandsOn5 extends Agent{
	private GUI gui;

    @Override
    protected void setup(){
        System.out.println("Empezando Agente del HANDS ON 5 MLR");

        
        gui = new GUI(this);
        gui.showGui();
    }

    @Override
    protected void takeDown(){
		gui.dispose();
        System.out.println("Hands On 5 Terminando");
    }

    public void predict(final double factor1, final double factor2){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
            	
                double[][] exampleData = {{23, 651}, {26, 762}, {30, 856}, {34, 1063}, {43, 1190}, {48, 1298}, {52, 1421}, {57, 1440}, {58, 1518}};
                Dataset dataset = new Dataset(exampleData);
                MultipleLinearRegression mlr = new MultipleLinearRegression(dataset);
            	mlr.printEquation();
                mlr.predict(factor1, factor2);
            }
        });
    }
}
