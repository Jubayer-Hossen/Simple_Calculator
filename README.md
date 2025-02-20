# Calculator Application

This is a simple calculator application built using Java Swing. It provides basic arithmetic operations such as addition, subtraction, multiplication, division, and modulus. The calculator has a user-friendly interface with a custom button UI.

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, division, and modulus.
- Clear (`AC`) button to reset the input.
- Delete (`<=`) button to remove the last digit.
- Negate (`(-)`) button to toggle the sign of the current number.
- Decimal point (`.`) button for floating-point operations.
- Custom button UI with anti-aliasing and oval shapes.

## Code Explanation

### `Calculator` Class

The `Calculator` class implements the `ActionListener` interface and provides the main functionality of the calculator.

#### Instance Variables

- `JFrame frame`: The main window of the application.
- `JTextField textfield`: The display area for the calculator.
- `JButton[] numberButtons`: Array of buttons for digits (0-9).
- `JButton[] functionButtons`: Array of buttons for functions (e.g., `+`, `-`, `*`, `/`, `%`).
- `Font myFont`: Custom font for the buttons and text field.
- `double num1, num2, result`: Variables to store operands and result.
- `char operator`: Variable to store the current operator.

#### Constructor

The constructor initializes the frame, text field, buttons, and panel. It sets the layout, colors, and event listeners for the buttons.

#### `actionPerformed` Method

This method handles the button click events and performs the corresponding arithmetic operations.

#### `styleButton` Method

This method applies the custom styling to the buttons, including background color, border, and custom UI with anti-aliasing and oval shapes.

## Usage

To run the calculator application, simply create an instance of the `Calculator` class in the `main` method.

```java
public static void main(String[] args) {
    Calculator calc = new Calculator();
}
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

- **Jubayer Hossen**

Current Date and Time: 2025-02-20 13:35:42 UTC

## Acknowledgements

- Decompiler used: FernFlower
```` ▋