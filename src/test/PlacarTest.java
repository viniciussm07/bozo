package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Placar;


public class PlacarTest {
    private static Placar placar;

    @BeforeAll
    public static void setupBeforeAll(){
        placar = new Placar();
    }

    @Test
    public void testPlacar(){
        
        int score = placar.getScore();
        assertEquals(0, score);
    }
}
