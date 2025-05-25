/*
file name:      LifeSimulation.java
Author:        Azeem Gbolahan
It runs may simulations / rounds of the game by opratiing on the landscape class and its display 

How to run:     java -ea LifeSimulation
*/





public class LifeSimulation {
    //this main method sets up the game and initalizes amd run the board 
    public static void main(String[] args)throws InterruptedException {
        if (args.length < 4) {
            System.out.println("Not enough arguments");
            return;
        }


        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        double chance = Double.parseDouble(args[2]);
        int round = Integer.parseInt(args[3]);


        Landscape scape = new Landscape(rows, cols, chance);
        //Landscape scape = new Landscape(rows,cols, .25);

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        // Uncomment below when advance() has been finished
        for (int i = 0; i < round; i++) {
            Thread.sleep(250);
            scape.advance();
            display.repaint();
    }
        int living = scape.getLivingCells();
        System.out.println("The number of living cells in this simulation: " + living);
    
    }
}
