# Unit Converter App

This Android application converts weight from pounds (lbs) to kilograms (kg).

## Features

*   **Input:** Users can enter a numerical value in pounds into an `EditText` field.
*   **Conversion:** Clicking a `Button` triggers the conversion.
*   **Output:** The converted value in kilograms is displayed in a `TextView`.
*   **Error Handling:**
    *   If the input field is empty, a `Toast` message is shown, and the `TextView` prompts the user to enter a value.
    *   If the input is not a valid number, a `Toast` message is shown, and the `TextView` indicates an invalid input.
*   **User Feedback:** `Toast` messages provide feedback for empty input, invalid input, and successful conversion.
*   **Edge-to-Edge Display:** The app utilizes `EdgeToEdge.enable(this)` for a modern, immersive user interface that extends to the system bars.

## How it Works

1.  The `MainActivity` sets up the user interface by finding the `EditText` for input, the `Button` for triggering the conversion, and the `TextView` for displaying the result.
2.  An `OnClickListener` is attached to the button.
3.  When the button is clicked:
    *   It retrieves the text from the `EditText`.
    *   It checks if the input is empty. If so, it displays an appropriate message and exits.
    *   It attempts to parse the input string into a `double`.
        *   If parsing is successful, it calls the `convertPoundsToKg()` method.
        *   The `convertPoundsToKg()` method multiplies the pounds by `0.453592` to get the equivalent kilograms.
        *   The result is then formatted to two decimal places and displayed in the `TextView`. A "Converted!" `Toast` is shown.
        *   If parsing fails (e.g., the user enters text instead of numbers), a `NumberFormatException` is caught. An error message is displayed in the `TextView`, and an "Invalid input format" `Toast` is shown.
4.  The app also handles window insets to ensure content is not obscured by system bars, providing a clean edge-to-edge layout.

## Code Structure

*   **`MainActivity.java`**: Contains the core logic for the application, including UI element initialization, event handling, input validation, and the conversion calculation.
    *   `onCreate()`: Initializes the activity, sets the content view, and wires up UI elements and listeners.
    *   `onClick()` (within `OnClickListener`): Handles the button click event, performs input validation, calls the conversion method, and updates the UI.
    *   `convertPoundsToKg(double pounds)`: A private helper method that takes pounds as input and returns the equivalent value in kilograms.

## Dependencies

The project uses standard AndroidX libraries:

*   `androidx.appcompat:appcompat`: For app compatibility.
*   `androidx.activity:activity`: For activity management.
*   `androidx.core:core-ktx` (implicitly, often used with Java projects for some core functionalities, though not directly visible in this Java file, it's a common Jetpack component)
*   Standard Android SDK components for UI elements like `Button`, `EditText`, `TextView`, and `Toast`.

## Setup and Build

1.  Clone the repository or import the project into Android Studio.
2.  Ensure you have the Android SDK installed and configured.
3.  Build the project using Gradle (usually done automatically by Android Studio).
4.  Run the application on an Android emulator or a physical device.

## To-Do / Potential Improvements

*   Add conversion for other units (e.g., kilograms to pounds, other types of units like length, temperature).
*   Implement a more sophisticated UI, perhaps using `Spinner`s to select units.
*   Add input validation to restrict input to numeric characters only as the user types.
*   Persist the last entered value or conversion.
*   Write unit tests for the conversion logic.
