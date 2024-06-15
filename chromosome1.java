/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geneticalgorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random; 
import java.util.Collections;

import java.util.List; 

/**
 *
 * @author kadirhanmeral
 */
public class chromosome1 {
    
    private static  final String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .-;:_!\"#%&/()=?@${[]}"; 
    private static final String TARGET = "(Generative AI) "; 
    
    
    
    private static int randomNumber(int start,int end){
        
        Random rnd = new Random();
        
        return rnd.nextInt(end-start+1) + start;

    }
    
    private static char createGene(){
        
        
        int random = randomNumber(0,GENES.length()-1);
        
        return GENES.charAt(random);
       
    }
    
    private static Chromosome createGnome(){
        
        Chromosome gnome = new Chromosome();
        for(int i=0 ; i<TARGET.length() ;i++){
            char x = createGene();
            gnome.append(x);
            
        }

        
        
        return gnome;
    }
    
    private static void  calculateFitness(Chromosome gnome){
        int fitness=0;
        
        for(int i = 0;i<TARGET.length();i++){
            if (gnome.getGnome().charAt(i)!=TARGET.charAt(i)){
                fitness+=1;
            }
            
        }
        
        gnome.setFitness(fitness);
        
        
    }
    
    private static Chromosome crossover(Chromosome parent1, Chromosome parent2){
        
        Chromosome child = new Chromosome();
        for(int i= 0; i<TARGET.length();i++){
            
            float p = randomNumber(0, 100) / 100f; 
            
            if (p < 0.45){
                
                child.append(parent1.getGnome().charAt(i));
                
            }
            else if (p<0.9){
                child.append(parent2.getGnome().charAt(i));
            }
            
            else{
                
                char k = createGene();
                child.append(k);
            }

        
        }
        calculateFitness(child);
        //System.out.println(child.getGnome()+" .     "+child.getFitness());
        
        return child;
    }
    
    private static List<Chromosome> createPopulation(int pNumber){
       
        
        List<Chromosome> population = new ArrayList<>(); 
        
        
        
        for (int i = 0; i < pNumber; i++) { 
            
            Chromosome gnome = createGnome();
            calculateFitness(gnome);
            population.add(gnome);
            //System.out.println(gnome.getFitness());
            

            
        } 
        
        
      
        
        
        return population;
        
    }
    private static class ValueComparator implements Comparator<Chromosome> {

    
        public int compare(Chromosome o1, Chromosome o2) {
        return Integer.compare(o1.getFitness(), o2.getFitness());
    }
   
        
        
    } 
    
    private static void  sortPopulation(List<Chromosome> population){
        
        Collections.sort(population, new ValueComparator());

    }
    
    
    public static void findTarget(){
        List<Chromosome> population = createPopulation(100);
        
        int genCount=0;
        
        
        while (true){
            sortPopulation(population);
            
            
            
            if (population.get(0).getFitness() <= 0) { 
                System.out.print("Generation: " + genCount + "\t"); 
                System.out.print("Keyword: " + population.get(0).getGnome() + "\t"); 
                System.out.println("Fitness: " + population.get(0).getFitness()); 
                break;
                
            } 
            List<Chromosome> nextPopulation = new ArrayList<>();
            for (int i = 0; i < population.size()*10/100; i++) { 
                
                nextPopulation.add(population.get(i));
            
            } 
            for (int i = 0; i < population.size()*90/100; i++) { 
                
                int p1 = randomNumber(0,50); 
                int p2 = randomNumber(0,50);

                
                Chromosome child = crossover(population.get(p1),population.get(p2));
                
                nextPopulation.add(child);
            
            } 
            
            population=nextPopulation;
            
            System.out.print("Generation: " + genCount + "\t"); 
            System.out.print("Keyword: " + population.get(0).getGnome() + "\t"); 
            System.out.println("Fitness: " + population.get(0).getFitness()); 
  
            genCount++; 
            
            
        }
        

    }
    
    
   
    
}
