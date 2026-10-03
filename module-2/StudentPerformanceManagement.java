import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentPerformanceManagement extends Frame {
    private final TextField nameField = new TextField(15);
    private final TextField rollField = new TextField(8);
    private final TextField[] markFields = {
            new TextField(5), new TextField(5), new TextField(5)
    };
    private final Label result = new Label("Enter student details and marks");

    public StudentPerformanceManagement() {
        super("Student Performance Management");
        setLayout(new FlowLayout());
        add(new Label("Name:"));
        add(nameField);
        add(new Label("Roll number:"));
        add(rollField);

        Panel marksPanel = new Panel(new FlowLayout());
        for (int index = 0; index < markFields.length; index++) {
            marksPanel.add(new Label("Mark " + (index + 1) + ":"));
            marksPanel.add(markFields[index]);
        }
        add(marksPanel);

        Button calculate = new Button("Calculate");
        calculate.addActionListener(event -> calculateResult());
        add(calculate);
        add(result);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });
        setSize(500, 220);
        setVisible(true);
    }

    private void calculateResult() {
        try {
            double total = 0;
            for (TextField field : markFields) {
                double mark = Double.parseDouble(field.getText());
                if (mark < 0 || mark > 100) {
                    result.setText("Marks must be between 0 and 100");
                    return;
                }
                total += mark;
            }
            result.setText(nameField.getText() + " (Roll " + rollField.getText()
                    + ") — Total: " + total + ", Average: " + total / markFields.length);
        } catch (NumberFormatException e) {
            result.setText("Enter valid marks");
        }
    }

    public static void main(String[] args) {
        new StudentPerformanceManagement();
    }
}
