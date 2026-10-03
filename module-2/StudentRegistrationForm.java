import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentRegistrationForm extends Frame {
    private final TextField nameField = new TextField(20);
    private final TextField registerField = new TextField(20);
    private final Choice courseChoice = new Choice();
    private final Checkbox hostelBox = new Checkbox("Hostel required");
    private final Label resultLabel = new Label("Enter details and select Submit");

    public StudentRegistrationForm() {
        super("Student Registration");
        setLayout(new FlowLayout());

        courseChoice.add("Computer Science");
        courseChoice.add("Information Technology");
        courseChoice.add("Business");

        addRow("Name:", nameField);
        addRow("Register number:", registerField);
        addRow("Course:", courseChoice);

        Panel options = new Panel(new FlowLayout());
        options.add(hostelBox);
        add(options);

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        submit.addActionListener(event -> showDetails());
        clear.addActionListener(event -> clearFields());
        add(submit);
        add(clear);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });

        setSize(420, 260);
        setVisible(true);
    }

    private void addRow(String title, java.awt.Component field) {
        Panel row = new Panel(new FlowLayout(FlowLayout.LEFT));
        row.add(new Label(title));
        row.add(field);
        add(row);
    }

    private void showDetails() {
        resultLabel.setText("Name: " + nameField.getText() + ", Register: "
                + registerField.getText() + ", Course: " + courseChoice.getSelectedItem()
                + ", Hostel: " + (hostelBox.getState() ? "Yes" : "No"));
    }

    private void clearFields() {
        nameField.setText("");
        registerField.setText("");
        hostelBox.setState(false);
        resultLabel.setText("Enter details and select Submit");
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
