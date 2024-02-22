package edu.eci.arsw.blueprints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BluePrintApplication implements CommandLineRunner {
    @Autowired
    BlueprintsServices bs;

    public static void main(String[] args) {
        SpringApplication.run(BluePrintApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception{
        Point[] points = new Point[]{new Point(0, 2), new Point(2, 4), new Point(2, 0), new Point(4, 2)};
        int planos = 5;
        String author2 = "Andres Arias";
        String author1 = "Sebastian Blanco";
        for (int i = 0; i < planos; i++) {
            bs.addNewBlueprint(new Blueprint(author1, "plano " + i,points));
            bs.addNewBlueprint(new Blueprint(author2, "plano " + i,points));
        }

        //System.out.println("--------PLANOS--------");
        //System.out.println(bs.getAllBlueprints());
        System.out.println("--------PLANOS POR AUTOR--------");
        System.out.println("--------PLANOS DE ANDRES--------");

        Set<Blueprint> blueprintSet = bs.getAllBlueprints();
       for(Blueprint bps : blueprintSet){
           if(bps.getAuthor().equals(author2)){
               System.out.println(bps + "Puntos" + bps.getStringPoints());
           }
       }

       System.out.println("--------PLANOS DE SEBASTIAN--------");
        System.out.println(bs.getBlueprintsByAuthor(author1));
    }
}
