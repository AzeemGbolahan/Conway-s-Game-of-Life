
- How to Run the Program:
  - To run the program, compile the Grid.java file and execute it with the appropriate arguments:
    1. **Compile the program**:
       javac Grid.java
    2. **Run the program** with the required arguments:
       java Grid <rows> <columns> [randomRange]
       - <rows>: The number of rows in the grid (must be an integer).
       - <columns>: The number of columns in the grid (must be an integer).
       - [randomRange] (optional): The upper bound for the random numbers to populate the grid. Default is 100 if not provided.
   
   Example 1: Create a 5x5 grid with default random range:
   java Grid 5 5

   Example 2: Create a 5x5 grid with random numbers between 0 and 50:
   java Grid 5 5 50

- Program Behavior:
  - The program generates a grid of random integers with dimensions specified by the user (rows x columns).
  - The program transposes the grid and prints the transposed matrix.
  - It also compares two 2x2 arrays (arr1 and arr2) to check if they reference the same object and whether they have identical values, outputting the results.

- Expected Output:
  - A printed transposed matrix of the grid.
  - Output comparing whether the arrays arr1 and arr2 reference the same object, and whether they contain the same values.

- Command Line Arguments:
  - rows [integer]: Number of rows in the grid (e.g., 5).
  - cols [integer]: Number of columns in the grid (e.g., 5).
  - randomRange [integer] (optional): Range for random numbers (default is 100).
  
  Example:
  java Grid 5 5 50

- Functions Explained:
  - transpose(int[][] arr): Transposes the input grid (matrix).
  - gridEquals(int[][] arr1, int[][] arr2): Compares two 2D arrays to see if they have the same dimensions and identical values.
  - printMatrix(int[][] arr): Prints a matrix in a human-readable format.
