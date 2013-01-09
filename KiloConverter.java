import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The KiloConverter class displays a JFrame that
   lets the user enter a distance in kilometers. when
   the Calculate button is sclicked, a dialog box is
   displayed with the distance converted to miles.
*/

public class KiloConverter extends JFrame {
   private JPanel panel;                  // To reference a panel
   private JLabel messageLabel;           // To reference a label
   private JTextField kiloTextField;      // To reference a text field
   private JButton calcButton;            // To reference a button
   private final int WINDOW_WIDTH = 250;  // Window Width
   private final int WINDOW_HEIGHT = 100; // Window Height
   
   /**
      Constructor
   */
   
   public KiloConverter() {
      
      // set the window title
      setTitle("Kilometer Converter");
      
      // set the size of the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      // specify what happens when the close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // build the panel and add it to the frame
      buildPanel();
      
      // add the panel to the frames content pane.
      add(panel);
      
      // display the window
      setVisible(true);
   }
   
   /**
      The buildPanel method adds a label, a text field
      and a button to a panel.
   */
   
   private void buildPanel() {
      
      // create a label to display instructions.
      messageLabel = new JLabel("Enter a distance "+
         "in Kilometers");
         
      // creat a text field 10 characters wide
      kiloTextField = new JTextField(10);
      
      // create a button with the caption "calculate"
      calcButton = new JButton("Calculate");
      
      // add an action listener to the button
      calcButton.addActionListener(new CalcButtonListener());
      
      // create a JPanel object and let the panel
      // field reference it
      panel = new JPanel();
      
      // define some color attributes
      panel.setBackground(Color.DARK_GRAY);
      messageLabel.setForeground(Color.WHITE);
      kiloTextField.setBackground(Color.LIGHT_GRAY);
      kiloTextField.setForeground(Color.BLACK);
      calcButton.setBackground(Color.LIGHT_GRAY);
      calcButton.setForeground(Color.BLACK);
      
      // add the label, text field and button
      // components to the panel.
      panel.add(messageLabel);
      panel.add(kiloTextField);
      panel.add(calcButton);
   }
   
   /**
      CalcButtonListener is an action listener class for
      the Calculate button.
   */
   
   private class CalcButtonListener implements ActionListener {
      
      /**
         the actionPerformed method executes when the user
         clicks on the calculate button.
         @param e the event object.
      */
      
      public void actionPerformed(ActionEvent e) {
         
         final double CONVERSION = 0.6214;
         String input;  // to hold user input
         double miles;  // the number of miles
         
         // get the text entered by the user into the
         // text field.
         input = kiloTextField.getText();
         
         // conver the input to miles.
         miles = Double.parseDouble(input) * CONVERSION;
         
         // display the result
         JOptionPane.showMessageDialog(null, input +
            " kilometers is " + miles + " miles.");
      }
   }
   
   /**
      main method
   */
   
   public static void main(String[] args) {
      
      new KiloConverter();
   }
}