- How to Run the Program:
  - To run the program, compile the LifeSimulation.java file and execute it with the appropriate arguments:
    1. **Compile the program**:
       LifeSimulation.java
    2. **Run the program** with the required arguments:
       java LifeSimulation <rows> <columns> <chance> <Number of iterations>
       - <rows>: The number of rows in the grid (must be an integer).
       - <columns>: The number of columns in the grid (must be an integer).
       - <chance>: The probability that a cell is alive ( can be either a double or integer when it is 1) to control the density of the initial board in terms of living cells
       - <Number of iterations>: How many times the game should run / the board state should change to reflect new cell states (must be an integer).
   
   Example 1: Run the game such that it is on a 100 * 100 grid and the probability of a cell being alive is 0.3, the game should run for 1000 times:
   java LifeSimulation 100 100 0.3 1000

   Example 2: Run the game such that it is on a 50 * 50 grid and the probability of a cell being alive is 0.6, the game should run for 10000 times:
   java LifeSimulation 50 50 0.6 10000

- Program Behavior:
  - The program simulates the Conway Game of Life according to the parameters specified by the user (rows x columns).
  - The program changes the state of the board after 250ms and runs it for the number of times specified by the user 
- Expected Output:
  - A window showing the Conway Game of Life Simulation.
  - The window updates in a split of second to reflect the changes and simulates different shapes or patterns formed by black cells (living) and grey cells(dead)

- Command Line Arguments:
<rows>: The number of rows in the grid (e.g. 100).
- <columns>: The number of columns in the grid (e.g 100).
- <chance>: The probability that a cell is alive ( can be either a double or integer when it is 1) to control the density of the initial board in terms of living cells(e.g. 0.3)
- <Number of iterations>: How many times the game should run / the board state should change to reflect new cell states (e.g. 1000).
  
  Example:
  java LifeSimulation 100 100 0.3 1000

- Functions Explained:
  - advance()- it updates the state of the board
  - repaints()- it displays the board with the cells
  
