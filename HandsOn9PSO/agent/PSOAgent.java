package agent;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;


public class PSOAgent extends Agent{
    int iteration;
    int iterations;
    
    int d; // dimensions
    
    double [] x; 
    double [] v;

    double w;
    double [] r;
    double [] c;

    double pFitness;
    double [] pBest;
    static double gFitness;
    static double [] gBest;
    
    @Override
    protected void setup(){
        System.out.println("Hello! I'm the '" + getAID().getLocalName() + "' from the PSO");
        
        d = 2;
        iteration = 0;
        iterations = 500;
        
        x = new double[d];
        v = new double[d];
        for(int i = 0; i < d; i++){
            x[i] = Math.random()*5;
            v[i] = Math.random();
            x[i] += v[i];
        }

        w = 0.8; // 0.8
        r = new double[] {Math.random(), Math.random()}; // Math.random(), Math.random()
        c = new double[] {0.1, 0.1}; // 0.1, 0.1

        pFitness = f();
        pBest = new double[d];
        for(int i = 0; i < d; i++)
            pBest[i] = x[i];
        if(gFitness == 0 || pFitness < gFitness){
            gFitness = pFitness;
            gBest = new double[d];
            for(int i = 0; i < d; i++)
                gBest[i] = pBest[i];
        }
        printProgress();
        
        iteration();
    }
    @Override
    protected void takeDown(){
        System.out.println("Terminatting '" + getAID().getLocalName() + "' from the PSO");
    }
    
    public void iteration(){
        addBehaviour(new SimpleBehaviour(){
            @Override
            public void action(){
                for(int i = 0; i < d; i++){
                    v[i] = w*v[i] + c[0]*r[0]*(pBest[i] - x[i]) + c[1]*r[1]*(gBest[i] - x[i]);
                    x[i] += v[i];
                }
                // Check fitness
                if(f() < pFitness){
                    pFitness = f();
                    for(int i = 0; i < d; i++)
                        pBest[i] = x[i];
                    if(pFitness < gFitness){
                        gFitness = pFitness;
                        for(int i = 0; i < d; i++)
                            gBest[i] = pBest[i];
                    }
                }
                //iteration++;
                printProgress();
            }
            @Override
            public int onEnd(){
                myAgent.doDelete();
                return super.onEnd();
            }
            @Override
            public boolean done() {
                return iteration == iterations;
            }
        });
    }
    private double f(){

        return Math.pow(x[0], 2) + Math.pow(x[1], 2);
        
    }
    private String printArray(double [] array){
        String msg = "<";
        for(int i = 0; i < array.length; i++){
            msg += String.format("%.2f", array[i]);
            if(i + 1 != array.length)
                msg += ", ";
        }
        msg += ">\t";
        return msg;
    }
    private void printProgress(){
        // x, v, pBest(pFit), gBest(gFit)
        String msg = getAID().getLocalName() + ":\t";
        msg += "(" + String.format("%.2f", f()) + ")";
        msg += printArray(x);
        msg += printArray(v);
        msg += "(" + String.format("%.2f", pFitness) + ")";
        msg += printArray(pBest);
        msg += "(" + String.format("%.2f",gFitness) + ")";
        msg += printArray(gBest);
        System.out.println(msg);
    }
}
