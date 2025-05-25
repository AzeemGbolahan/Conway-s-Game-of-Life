# 🧬 Conway's Game of Life Simulation

Welcome to a grid-based simulation of **Conway's Game of Life**, implemented in Java!  
This project brings to life the classic cellular automaton by simulating thousands of generations based on deterministic rules, showcasing the beauty of emergent behavior from simple logic.

---

## 🎯 Project Objective

The main goal of this project is to **explore emergence and complexity through simulation**. Using simple birth and survival rules, the program continuously evolves a grid of cells to analyze:

- How patterns grow, oscillate, or die out
- Interactions between localized groups of cells
- Behavior of user-created or random initial states

---

## 🛠 Features

- ✅ Full implementation of Conway’s Game of Life mechanics  
- 🖼 GUI interface using Java Swing for real-time visualization  
- 📏 Configurable grid size and simulation speed  
- 📦 Modular OOP design: `Cell`, `Grid`, `Landscape`, `Display`, `Simulation`  
- 🧪 Unit test coverage for major components  
- 📄 Supports both static and dynamic pattern evolution  

---

## 📁 File Structure

```
src/
├── Cell.java               # Represents an individual cell (alive or dead)
├── Grid.java               # Manages 2D grid of cells and rules
├── Landscape.java          # Abstracted environment to hold the grid
├── LandscapeDisplay.java   # GUI rendering of the simulation using Swing
├── LifeSimulation.java     # Main driver for running the simulation
├── *Tests.java             # JUnit test classes for components
├── README.txt              # Additional usage info
```

```
extension/
├── Same files as above but enhanced or extended versions for further experimentation
```

---

## 🧪 How to Run the Simulation

### Step 1: Compile the code

```bash
cd src
javac *.java
```

### Step 1A: Compile the code: extension

```bash
cd extension
javac *.java
```

### Step 2: Run the simulation

```bash
java LifeSimulation
```

---

## 🧪 Tests

This project includes tests for:

- Cell state transitions and neighbor calculations
- Grid update cycles
- GUI display functionality
- Simulation timing and iterations

To run tests, use a Java IDE or compile & run the `*Tests.java` files manually.

---

## 🧠 Concepts Explored

- Cellular Automata  
- Rule-based simulation  
- Object-Oriented Programming (OOP)  
- Java Swing and GUI rendering  
- Emergent systems  
- Test-driven development with JUnit  

---

## 📄 Report

A full breakdown of implementation logic, design decisions, experiments, and outcomes is included in the PDF report:  
📘 `Project2Report.pdf`

---

## 👨‍💻 Author

**Azeem Gbolahan**  
Student of Computer Science & Economics  
Colby College

---

## 🚀 Let’s Connect

If you're interested in simulation, AI, or complexity theory — feel free to reach out or fork the project!
