/**
 * File name:    Grid.java
 * Author:       Azeem Gbolahan
 * 
 * Description:
 * This class simulates a simple 2D grid using a two-dimensional array. It includes:
 * - Randomly generating numbers in a grid
 * - Converting the grid into a primitive `int[][]` array
 * - Transposing the grid (swapping rows with columns)
 * - Comparing two grids to check if they contain the same values
 * 
 * Additional array logic demonstrations are provided, such as:
 * - Checking if two arrays refer to the same object
 * - Verifying structural and value equality between arrays
 * 
 * How to run:
 * Compile and run with:
 *     javac Grid.java
 *     java -ea Grid <rows> <columns> [optional max random number]
 * Example:
 *     java -ea Grid 3 4 50
 * This will create a 3x4 grid with values from 0–49.
 */

 import java.util.Random;

 public class Grid {
     
     // Instance variable to hold the grid (not used in this demo but can be used for expansion)
     public Integer[][] grid;
 
     public static void main(String[] args) {
         if (args.length < 2) { // Ensure the user provides at least two arguments
             System.out.println("Not enough arguments");
             return; // Stop execution if arguments are insufficient
         }
 
         int rows = Integer.parseInt(args[0]); // Get the number of rows from command-line argument
         int cols = Integer.parseInt(args[1]); // Get the number of columns from command-line argument
         int randomRange = 100; // Default upper limit for random numbers (0 to 99)
 
         if (args.length >= 3) { // If a third argument is provided
             randomRange = Integer.parseInt(args[2]); // Use it as the upper limit for random values
         }
 
         // Step 1: Create and populate the grid with random values
         Integer[][] grid = new Integer[rows][cols]; // 2D array for storing random numbers
         Random randomizer = new Random(); // Object for generating random numbers
 
         for (int i = 0; i < grid.length; i++) { // Loop through each row
             for (int j = 0; j < grid[i].length; j++) { // Loop through each column
                 grid[i][j] = randomizer.nextInt(randomRange); // Assign a random value to each cell
             }
         }
 
         // Step 2: Convert Integer[][] to int[][] so it can be used in transpose method
         int[][] primitiveGrid = new int[rows][cols];
         for (int i = 0; i < rows; i++) { // Copy each value
             for (int j = 0; j < cols; j++) {
                 primitiveGrid[i][j] = grid[i][j];
             }
         }
 
         // Step 3: Transpose the primitive 2D array
         int[][] transposedArray = Grid.transpose(primitiveGrid);
 
         // Step 4: Print the transposed array
         Grid.printMatrix(transposedArray);
 
         // Step 5: Array comparison test to understand object references and content equality
         int[][] arr1 = new int[2][2];
         int[][] arr2 = new int[2][2];
         int[][] arr3;
 
         // Populate arr1 and arr2 with identical values
         for (int i = 0; i < 2; i++) {
             for (int j = 0; j < 2; j++) {
                 arr1[i][j] = i + j;
                 arr2[i][j] = i + j;
             }
         }
 
         arr3 = arr1; // arr3 now references the same object as arr1
 
         // Check and display various forms of equality
         System.out.println("Checking if arr1 and arr2 reference the same object: " + (arr1 == arr2)); // Should be false
         System.out.println("Checking if arr2 and arr3 reference the same object: " + (arr2 == arr3)); // Should be false
         System.out.println("Checking if arr1 and arr2 have the same values: " + gridEquals(arr1, arr2)); // Should be true
     }
 
     /**
      * Compares two 2D arrays to see if they contain the same values at each position.
      * 
      * @param arr1 First array to compare
      * @param arr2 Second array to compare
      * @return true if the arrays are equal in shape and values; false otherwise
      */
     public static boolean gridEquals(int[][] arr1, int[][] arr2) {
         if (arr1.length != arr2.length) return false; // Check if row counts match
 
         for (int i = 0; i < arr1.length; i++) {
             if (arr1[i].length != arr2[i].length) return false; // Check if column counts match
             for (int j = 0; j < arr1[i].length; j++) {
                 if (arr1[i][j] != arr2[i][j]) return false; // Check if each corresponding value matches
             }
         }
 
         return true; // All values match
     }
 
     /**
      * Transposes a 2D array: converts rows to columns and columns to rows.
      * 
      * @param arr the original 2D array
      * @return the transposed version of the array
      */
     public static int[][] transpose(int[][] arr) {
         int rows = arr.length;
         int cols = arr[0].length;
 
         int[][] transposed = new int[cols][rows]; // Create a new array with flipped dimensions
 
         for (int i = 0; i < rows; i++) { // For each row in the original
             for (int j = 0; j < cols; j++) { // For each column
                 transposed[j][i] = arr[i][j]; // Flip and assign the value
             }
         }
 
         return transposed; // Return the new transposed array
     }
 
     /**
      * Prints a 2D array in matrix format.
      * 
      * @param arr the 2D array to print
      */
     public static void printMatrix(int[][] arr) {
         for (int i = 0; i < arr.length; i++) { // For each row
             for (int j = 0; j < arr[i].length; j++) { // For each column in that row
                 System.out.print(arr[i][j] + " "); // Print the value followed by a space
             }
             System.out.println(); // Start a new line after each row
         }
     }
 }
 