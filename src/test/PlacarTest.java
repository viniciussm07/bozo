package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Placar;


public class PlacarTest {
    private static Placar placar;

    @BeforeAll
    public static void init(){
        System.out.println("Before All init() method called");
        placar = new Placar();
    }

    @Test
    public void testPlacar(){
        
        int score = placar.getScore();
        assertEquals(0, score);
    }
}
