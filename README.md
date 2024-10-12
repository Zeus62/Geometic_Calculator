# Geometric Calculator

## Overview

The Geometric Calculator is a Java application that calculates the area and perimeter of various geometric shapes, including circles, rectangles, and squares. It utilizes object-oriented programming (OOP) principles and provides a graphical user interface (GUI) for ease of use.

## Features

- **Shape Selection:** Users can choose from three geometric shapes: Circle, Rectangle, and Square.
- **Dynamic Input Fields:** Based on the selected shape, the application dynamically adjusts the input fields to collect necessary dimensions.
- **Calculation and Display:** The application calculates the area and perimeter based on user input and displays the results.

## Technologies Used

- Java (JDK 8 or higher)
- Swing (for GUI)
- Object-Oriented Programming (OOP) concepts

## Structure

The project is structured into multiple classes:

- **`MyProject`:** The main class that launches the application.
- **`GeometricObject`:** An abstract class representing the common interface for all geometric shapes.
- **`Circle`, `Rectangle`, `Square`:** Concrete classes extending `GeometricObject` to implement specific area and perimeter calculations.
- **`Framee`:** The GUI class that handles user interactions and displays the results.

## Usage

### Select Shape
Use the dropdown menu to select the geometric shape for which you want to calculate the area and perimeter.

### Enter Dimensions
- **For Circle:** Enter the radius.
- **For Square:** Enter the side length.
- **For Rectangle:** Enter the width and height.

### Calculate
Click the **"Calculate and Display"** button to see the results for both area and perimeter.

### Reset Fields
The fields will reset based on the selected shape.

## Error Handling
This application includes robust error handling to ensure that user inputs are valid and to manage potential exceptions gracefully. Key features of the error handling include:

### Input Validation
- The application checks if the entered values are numeric and positive.
- If the user enters invalid data (e.g., negative numbers or non-numeric values), a dialog box will display an error message.

### Try and Catch Blocks
The calculations and input parsing are wrapped in `try` and `catch` blocks to handle exceptions:
- **NumberFormatException:** Catches errors when parsing user input into a double. If the input cannot be converted to a numeric value, an error message will be shown.
- **IllegalArgumentException:** Custom exceptions are thrown when a user provides a non-positive value. The error message is displayed to inform the user of the issue.


## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Zeus62/Geometic_Calculator.git
