/**
 * File name:    Landscape.java
 * Author:       Azeem Gbolahan
 * 
 * Description:
 * This class represents the main game board for Conway's Game of Life.
 * It manages a grid of `Cell` objects and handles all the game logic, such as:
 * - Initializing a grid of cells (either all dead or randomly alive)
 * - Getting the neighbors of a specific cell
 * - Updating all cells to the next generation using the Game of Life rules
 * - Resetting the board
 * - Counting all living cells on the board
 * - Drawing the board visually using Java Graphics
 *
 * Think of this class as the "brain" that controls the entire grid and manages the rules
 * for how cells live or die in each generation.
 * 
 * How to run:
 *     Compile with: javac Landscape.java
 *     Run with:     java -ea Landscape
 */

 import java.awt.Color;
 import java.awt.Graphics;
 import java.util.ArrayList;
 import java.util.Random;
 
 public class Landscape {
 
     private Cell[][] landscape;      // 2D array representing the entire game board
     private double initialChance;    // Probability of each cell starting as alive
     private int rows;                // Number of rows in the grid
     private int columns;             // Number of columns in the grid
 
     /**
      * Creates a new Landscape with all cells initially dead.
      * 
      * @param rows    number of rows in the grid
      * @param columns number of columns in the grid
      */
     public Landscape(int rows, int columns) {
         this.rows = rows;
         this.columns = columns;
         landscape = new Cell[rows][columns]; // Create the grid
         reset(); // Initialize the grid with all dead cells
     }
 
     /**
      * Creates a new Landscape with a chance of each cell being alive.
      * 
      * @param rows    number of rows in the grid
      * @param columns number of columns in the grid
      * @param chance  probability (0 to 1) that a cell starts alive
      */
     public Landscape(int rows, int columns, double chance) {
         this.rows = rows;
         this.columns = columns;
         this.initialChance = chance;
         landscape = new Cell[rows][columns]; // Create the grid
 
         Random randomizer = new Random(); // Random number generator
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 // If a random number is less than the chance, make the cell alive
                 this.landscape[i][j] = new Cell(randomizer.nextDouble() < chance);
             }
         }
     }
 
     /**
      * Resets the entire grid based on the initial chance of a cell being alive.
      */
     public void reset() {
         Random randomizer = new Random();
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 landscape[i][j] = new Cell(randomizer.nextDouble() < initialChance);
             }
         }
     }
 
     public int getRows() {
         return landscape.length;
     }
 
     public int getCols() {
         return columns;
     }
 
     /**
      * Gets the cell at the given row and column.
      * Returns null if the position is out of bounds.
      */
     public Cell getCell(int row, int col) {
         if (row >= 0 && row < rows && col >= 0 && col < columns) {
             return landscape[row][col];
         }
         return null; // Invalid position
     }
 
     /**
      * Returns a string version of the entire grid.
      * Each cell is shown as "1" if alive, "0" if dead.
      */
     public String toString() {
         StringBuilder s = new StringBuilder();
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 s.append(landscape[i][j].toString()).append(" ");
             }
             s.append("\n"); // New line after each row
         }
         return s.toString();
     }
 
     /**
      * Returns a list of neighboring cells for a given cell at (row, col).
      * Only includes valid neighbors (ignores ones outside the grid).
      */
     public ArrayList<Cell> getNeighbors(int row, int col) {
         ArrayList<Cell> neighbors = new ArrayList<>(); // List to store neighboring cells
 
         // Check all positions around the current cell (8 possible neighbors)
         for (int i = -1; i <= 1; i++) {        // Row offset: -1 (above), 0 (same), 1 (below)
             for (int j = -1; j <= 1; j++) {    // Col offset: -1 (left), 0 (same), 1 (right)
                 if (i == 0 && j == 0) continue; // Skip the cell itself
 
                 int newRow = row + i;         // Get neighbor's row
                 int newCol = col + j;         // Get neighbor's column
 
                 // If within grid bounds, add the neighbor to the list
                 if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                     neighbors.add(landscape[newRow][newCol]);
                 }
             }
         }
         return neighbors;
     }
 
     /**
      * Advances the game by one generation using the Game of Life rules.
      */
     public void advance() {
         Cell[][] temporary_grid = new Cell[rows][columns]; // Temporary copy of the grid
 
         // Copy the current state of the cells
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 temporary_grid[i][j] = new Cell(landscape[i][j].getAlive());
             }
         }
 
         // Update each cell in the new grid using the original grid's neighbors
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 temporary_grid[i][j].updateState(this.getNeighbors(i, j));
             }
         }
 
         // Replace the old grid with the updated one
         landscape = temporary_grid;
     }
 
     /**
      * Returns the number of living (alive) cells currently on the board.
      */
     public int getLivingCells() {
         int livingCellCount = 0;
         for (int x = 0; x < getRows(); x++) {
             for (int y = 0; y < getCols(); y++) {
                 if (landscape[x][y].getAlive()) {
                     livingCellCount++;
                 }
             }
         }
         return livingCellCount;
     }
 
     /**
      * Draws the current state of the grid onto a graphics panel.
      * Alive cells are black; dead cells are gray.
      * 
      * @param g      the graphics context to draw on
      * @param scale  how big each cell should be (in pixels)
      */
     public void draw(Graphics g, int scale) {
         for (int x = 0; x < getRows(); x++) {
             for (int y = 0; y < getCols(); y++) {
                 g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.GRAY);
                 g.fillOval(x * scale, y * scale, scale, scale);
             }
         }
     }
 
     /**
      * Main method to demonstrate how this class works.
      * Creates a board, prints it, and shows neighbors of a specific cell.
      */
     public static void main(String[] args) {
         Landscape l1 = new Landscape(5, 5);
         System.out.println("Landscape with all dead cells:\n" + l1);
 
         Landscape l2 = new Landscape(5, 5, 0.3);
         System.out.println("Landscape with random alive cells:\n" + l2);
 
         System.out.println("Neighbors of cell (3,3):");
         ArrayList<Cell> neighbors = l2.getNeighbors(3, 3);
 
         for (Cell c : neighbors) {
             System.out.print(c + " ");
         }
         System.out.println();
 
         l2.reset();
         System.out.println("Landscape after reset:\n" + l2);
     }
 }
 