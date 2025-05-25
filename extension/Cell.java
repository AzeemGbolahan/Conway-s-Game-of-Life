/**
 * File name:     Cell.java
 * Author:        Azeem Gbolahan
 * 
 * Description:
 * This class defines a Cell object used in a grid-based simulation of Conway's Game of Life.
 * Each Cell represents a single "spot" in the grid and keeps track of whether it is alive or dead.
 * 
 * The game follows simple rules:
 *  - A live cell with 2 or 3 live neighbors stays alive.
 *  - A dead cell with exactly 3 live neighbors becomes alive.
 *  - In all other cases, the cell becomes or stays dead.
 * 
 * This class includes methods to:
 *  - Check if a cell is alive
 *  - Set a cell’s alive/dead status
 *  - Update the cell’s status based on neighbors
 *  - Return a simple text version ("1" = alive, "0" = dead)
 * 
 * How to run:
 * Compile the file and run the main method to test basic functionality:
 *    javac Cell.java
 *    java -ea Cell
 */

 import java.util.ArrayList;

 public class Cell {
 
     // Stores the life status of a cell: true = alive, false = dead
     private boolean alive;
 
     /**
      * Constructs a new cell that is initially dead.
      */
     public Cell() {
         this(false); // Use the other constructor, and set status to dead (false)
     }
 
     /**
      * Constructs a new cell with a specified life status.
      * 
      * @param status true for alive, false for dead
      */
     public Cell(boolean status) {
         this.alive = status; // Set the cell's status
     }
 
     /**
      * Returns whether the cell is currently alive.
      * 
      * @return true if the cell is alive, false otherwise
      */
     public boolean getAlive() {
         return this.alive;
     }
 
     /**
      * Updates the cell’s alive/dead status.
      * 
      * @param status true to make the cell alive, false to make it dead
      */
     public void setAlive(boolean status) {
         this.alive = status;
     }
 
     /**
      * Updates the cell’s status based on its neighbors,
      * following Conway's Game of Life rules.
      * 
      * @param neighbors a list of neighboring cells around this one
      */
     public void updateState(ArrayList<Cell> neighbors) {
         int life = 0; // Count of alive neighbors
         boolean living = this.getAlive(); // Current status of this cell
 
         // Check each neighbor to see if it's alive
         for (Cell neighbor : neighbors) {
             if (neighbor.getAlive()) {
                 life++; // Increase count if neighbor is alive
             }
         }
 
         // Apply Conway's Game of Life rules
         if (living && (life == 2 || life == 3)) {// if the cell is alive and 2 or 3 of its neighbor is alive 
             this.setAlive(true); // Cell survives
         } else if (!living && life == 3) {// if the cell is dead and exactly 3 of its neighbor is alive
             this.setAlive(true); // Cell is born
         } else {// otherwise
             this.setAlive(false); // Cell dies or remains dead
         }
     }
 
     /**
      * Returns a string version of the cell:
      * "1" if alive, "0" if dead.
      * 
      * @return string representing the cell's life status
      */
     public String toString() {
         if (this.getAlive()) {
             return "1"; // Alive
         }
         return "0";     // Dead
     }
 
     /**
      * A short tester for the Cell class to demonstrate basic behavior.
      * 
      * @param args not used
      */
     public static void main(String[] args) {
         Cell cell = new Cell(false); // Create a dead cell
 
         // Show initial state
         System.out.println("Initial state of the cell:   " + cell.toString());
         System.out.println("Is this cell alive?          " + cell.getAlive());
 
         // Change the state to alive
         cell.setAlive(true);
 
         // Show updated state
         System.out.println("State after setting to alive: " + cell.toString());
         System.out.println("Is this cell alive?          " + cell.getAlive());
     }
 }
 