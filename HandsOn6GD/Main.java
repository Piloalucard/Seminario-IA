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

public class Handson6Agent extends Agent {
    private Handson6GUI gui;

    @Override
    protected void setup() {
        System.out.println("Empezando Agente del HANDS ON 6 MLR");

        gui = new Handson6GUI(this);
        gui.showGui();
    }

    @Override
    protected void takeDown() {
        gui.dispose();
        System.out.println("Hands On 6 Terminando");
    }

    public void predict() {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                Gradiente GR = new Gradiente();
                System.out.println("");
                GR.displayGradienteEquation();
                System.out.println("");
                GR.Beta0();
                GR.Beta1();
                System.out.println("");
                GR.Error();
                System.out.println("");
                GR.predict();
   
            }
        });
    }
}
