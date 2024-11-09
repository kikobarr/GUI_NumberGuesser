
/**
 * Fork this repl to use as the starting point
 * for your project
 *
 * You will be modifying the actionPerformed method
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class Main extends JFrame implements ActionListener {

    private JLabel guessLabel;
    private JTextField guessField;
    private JButton higherButton;
    private JButton lowerButton;
    private JButton correctButton;
    private JButton resetButton;

    private NumberGuesser guesser;

    public Main() {
        // Used to specify GUI component layout
        GridBagConstraints positionConst = null;

        // Set frame's title
        setTitle("Number Guesser");

        // Create the display for the guess
        guessLabel = new JLabel("Is it?");

        guessField = new JTextField(15);
        guessField.setEditable(false);
        guessField.setText("0");

        // Create the buttons Lower, Higher, Correct, Reset
        lowerButton = new JButton("Lower");
        higherButton = new JButton("Higher");
        correctButton = new JButton("Correct");
        resetButton = new JButton("Reset");

        // Use "this" class to handle button presses
        lowerButton.addActionListener(this);
        higherButton.addActionListener(this);
        correctButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        // 10 pixels vert, 5 horizontal around components
        positionConst.insets = new Insets(10, 5, 10, 5);

        // Add component using the specified constraints
        positionConst.gridx = 0;
        positionConst.gridy = 0;
        add(guessLabel, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 0;
        add(guessField, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 0;
        add(resetButton, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        add(lowerButton, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 2;
        add(higherButton, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 2;
        add(correctButton, positionConst);

        // Get Ready to play the game
        this.guesser = new NumberGuesser(1, 100);
        this.guessField.setText("" + guesser.getCurrentGuess());
    }

    /*
     * Method is automatically called when a button is pressed
     *
     * It needs some work. The logic here doesn't play a guessing game. It just
     * provides some examples that you can use.
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        // buttonPressed will be initialized with a
        // reference to the button object that was pressed.
        // One of the four buttons: Higher, Lower, Correct, Reset
        Object buttonPressed = event.getSource();

        if (buttonPressed == this.lowerButton) {
            try {
                this.guesser.lower();
            }
            catch (NumberGuesserIllegalStateException e) {
                throw new RuntimeException(e);
            }
            this.guessField.setText("" + guesser.getCurrentGuess());
            //Show a JOptionPane that alerts the user that you are onto their schemes.
        }

        if (buttonPressed == this.higherButton) {
            // When the Higher button is pressed invoke this.guesser.higher()
            // and then put the new guess into the this.guessField
            try {
                this.guesser.higher();
            } catch (NumberGuesserIllegalStateException e) {
                throw new RuntimeException(e);
            }
            this.guessField.setText("" + guesser.getCurrentGuess());
            // Show a JOptionPane that alerts the user that you are onto their schemes.
        }

        if (buttonPressed == this.correctButton) {
            // When the Correct button is pressed, exit the app using System.exit(0)
            System.exit(0);
        }

        if (buttonPressed == this.resetButton) {
            // When the Reset button is pressed, invoke this.guesser.reset()
            // and then put the new guess into the this.guessField
            this.guesser.reset();
            this.guessField.setText("" + guesser.getCurrentGuess());
        }
    }

    public static void main(String[] args) {
        Main myFrame = new Main();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}