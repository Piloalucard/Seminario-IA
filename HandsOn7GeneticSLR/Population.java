import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
    private Individual[] population;
    private double populationFitness = -1;

    public Population(int sizePopulation) {
        this.population = new Individual[sizePopulation];
    }

    public Population(int sizePopulation, int lengthChromosome) {
        this.population = new Individual[sizePopulation];
        for (int i = 0; i < sizePopulation; i++) {
            Individual individual = new Individual(lengthChromosome);
            this.population[i] = individual;
        }

    }

    public Individual[] getIndividuals() {
        return this.population;
    }

    public Individual getFittest(int offset) {
        Arrays.sort(this.population, new Comparator<Individual>() {
            public int compare(Individual s1, Individual s2) {
                if (s1.getFitness() > s2.getFitness()) {
                    return -1;
                } else if (s1.getFitness() < s2.getFitness()) {
                    return 1;
                }
                return 0;

            }
        });
        return this.population[offset];
    }

    public void setPopulationFitness(double fitness) {
        this.populationFitness = fitness;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public int getSize() {
        return this.population.length;
    }

    public Individual setIndividual(int offset, Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offset) {
        return population[offset];
    }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = population.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Individual a = population[index];
            population[index] = population[i];
            population[i] = a;
        }
    }

}