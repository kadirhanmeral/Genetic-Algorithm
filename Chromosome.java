/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geneticalgorithm;

/**
 *
 * @author kadirhanmeral
 */
public class Chromosome {
    
    
    private  StringBuilder gnome = new StringBuilder();
    
    private  int fitness ;
    
    
    
    
    

    public Chromosome() {
        
        gnome.setLength(0);

        fitness=0;
    }
     public void append(char a){
        
        gnome.append(a);
    }
    
   

    public  int getFitness() {
        return fitness;
    }

    public  void setFitness(int fitness) {
        this.fitness = fitness;
    }



    public  StringBuilder getGnome() {
        return gnome;
    }

    public  void setGnome(StringBuilder gnome) {
        this.gnome = gnome;
    }
    
   
    
    
    
    
    
    
    
    
    
}
