/*
file name:      LifeSimualtion.java
Author:        Azeem Gbolahan
It runs may simulations / rounds of the game by opratiing on the landscape class and its display 

How to run:     java -ea LifeSimulation
*/


public class LifeSimulation {
    //this main method sets up the game and initalizes amd rund the board 
    public static void main(String[] args)throws InterruptedException {
  


        Landscape scape = new Landscape(100, 100, .25);


        LandscapeDisplay display = new LandscapeDisplay(scape, 6);
         while (true) {
        Thread.sleep(250);
        scape.advance();
        display.repaint();
    }
    
    }
}


/*public class LifeSimulation {
    public static void main(String[] args) {
        int rows = Integer.parseInt(args[0]); // grid rows from command-line
        int cols = Integer.parseInt(args[1]); // grid columns from command-line
        double initialChance = Double.parseDouble(args[2]); // initial chance from command-line

        Landscape landscape = new Landscape(rows, cols, initialChance);
        for (int round = 0; round < 1000; round++) {
            landscape.advance();
        }

        System.out.println("Living Cells: " + landscape.getLivingCells());
    }
}
*/

