/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geneticalgorithm;
import java.util.ArrayList; 
import java.util.List; 
import java.time.Instant;
import java.time.Duration;
/**
 *
 * @author kadirhanmeral
 */
public class GeneticAlgorithm {

    /**
     */
    public static void main(String[] args) {
        
        
        
        

        System.out.println("Deneme 1");
        Instant start = Instant.now();
        chromosome1 deneme1 = new chromosome1();
        deneme1.findTarget();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("İşlem süresi: " + duration.toMillis()+ " milisaniye");
        
        
        
        System.out.println("Deneme 2");
        Instant start1 = Instant.now();
        chromosome1 deneme2 = new chromosome1();
        deneme2.findTarget();
        Instant end1 = Instant.now();
        Duration duration1 = Duration.between(start1, end1);
        System.out.println("İşlem süresi: " + duration1.toMillis() + " milisaniye");
    }
    
}
