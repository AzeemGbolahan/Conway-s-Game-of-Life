# Conway's Game of Life

This is a Java implementation of Conway's Game of Life — a cellular automaton devised by the British mathematician John Horton Conway. It simulates the evolution of a grid of cells based on simple rules, demonstrating how complexity can arise from simplicity.

## 🌟 Features

- Interactive visualization of the Game of Life grid
- Customizable grid size and simulation parameters
- Modular design with clean OOP principles
- GUI using Java Swing
- Built-in test cases for core classes
- Extensions for advanced experiments

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse) or command-line tools

### Installation

1. Clone or download the repository.
2. Navigate to the `src` or `extension` directory.
3. Compile the Java files:

```bash
javac *.java
```

4. Run the simulation:

```bash
java LifeSimulation
```

## 🕹️ Usage

- Launch the application to see the grid animation.
- Each cell lives or dies based on the number of live neighbors:
  - Any live cell with 2 or 3 neighbors survives.
  - Any dead cell with exactly 3 neighbors becomes alive.
  - All other live cells die in the next generation.
- Adjust logic or size by modifying parameters in `LifeSimulation.java`.

## 📁 Project Structure

```
Conway's-Game-of-Life/
│
├── src/ or extension/
│   ├── Cell.java               # Represents individual grid cells
│   ├── Grid.java               # Manages the entire 2D grid of cells
│   ├── Landscape.java          # Handles environment abstraction
│   ├── LandscapeDisplay.java   # GUI rendering using Swing
│   ├── LifeSimulation.java     # Entry point and control loop
│   └── *Tests.java             # Unit tests
│
├── README.md
└── Project2Report.pdf          # Detailed project write-up
```

## ✅ Development and Testing

This project includes unit tests for key components. To run them:

```bash
javac *.java
java CellTests
java LandscapeTests
```

Tests confirm:
- Correct cell updates and transitions
- Accurate neighbor counting
- Grid consistency

## 👤 Author

Developed as part of a computer science coursework project.

## 📜 License

This project is open-source and free to use under the MIT License.
