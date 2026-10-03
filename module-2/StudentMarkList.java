import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class StudentMarkList extends JFrame {
    private final JTextField nameField = new JTextField();
    private final JTextField registerField = new JTextField();
    private final JTextField[] markFields = {
            new JTextField(), new JTextField(), new JTextField()
    };
    private final JTextArea resultArea = new JTextArea(5, 28);

    public StudentMarkList() {
        super("Student Mark List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fields = new JPanel(new GridLayout(0, 2, 5, 5));
        fields.add(new JLabel("Name:"));
        fields.add(nameField);
        fields.add(new JLabel("Register number:"));
        fields.add(registerField);
        for (int index = 0; index < markFields.length; index++) {
            fields.add(new JLabel("Subject " + (index + 1) + " mark:"));
            fields.add(markFields[index]);
        }

        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JButton exit = new JButton("Exit");
        calculate.addActionListener(event -> calculate());
        clear.addActionListener(event -> clear());
        exit.addActionListener(event -> dispose());

        JPanel buttons = new JPanel();
        buttons.add(calculate);
        buttons.add(clear);
        buttons.add(exit);

        add(fields, java.awt.BorderLayout.NORTH);
        add(resultArea, java.awt.BorderLayout.CENTER);
        add(buttons, java.awt.BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculate() {
        try {
            double total = 0;
            for (JTextField field : markFields) {
                double mark = Double.parseDouble(field.getText());
                if (mark < 0 || mark > 100) {
                    resultArea.setText("Each mark must be between 0 and 100.");
                    return;
                }
                total += mark;
            }
            double average = total / markFields.length;
            String grade = average >= 90 ? "A" : average >= 75 ? "B"
                    : average >= 60 ? "C" : average >= 40 ? "D" : "F";
            resultArea.setText("Name: " + nameField.getText()
                    + "\nRegister number: " + registerField.getText()
                    + "\nTotal: " + total + "\nAverage: " + average + "\nGrade: " + grade);
        } catch (NumberFormatException e) {
            resultArea.setText("Enter a valid number for each subject mark.");
        }
    }

    private void clear() {
        nameField.setText("");
        registerField.setText("");
        for (JTextField field : markFields) {
            field.setText("");
        }
        resultArea.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(StudentMarkList::new);
    }
}
