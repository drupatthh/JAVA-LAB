import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtCalculator extends Frame {
    private final TextField firstField = new TextField(10);
    private final TextField secondField = new TextField(10);
    private final Label resultLabel = new Label("Result");

    public AwtCalculator() {
        super("Simple Calculator");
        setLayout(new FlowLayout());
        add(new Label("First number:"));
        add(firstField);
        add(new Label("Second number:"));
        add(secondField);

        addOperation("+", (first, second) -> first + second);
        addOperation("-", (first, second) -> first - second);
        addOperation("*", (first, second) -> first * second);
        addOperation("/", (first, second) -> first / second);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });

        setSize(420, 160);
        setVisible(true);
    }

    private void addOperation(String label, Operation operation) {
        Button button = new Button(label);
        button.addActionListener(event -> calculate(label, operation));
        add(button);
    }

    private void calculate(String operator, Operation operation) {
        try {
            double first = Double.parseDouble(firstField.getText());
            double second = Double.parseDouble(secondField.getText());
            if (operator.equals("/") && second == 0) {
                resultLabel.setText("Cannot divide by zero");
                return;
            }
            resultLabel.setText("Result: " + operation.apply(first, second));
        } catch (NumberFormatException e) {
            resultLabel.setText("Enter valid numbers");
        }
    }

    @FunctionalInterface
    private interface Operation {
        double apply(double first, double second);
    }

    public static void main(String[] args) {
        new AwtCalculator();
    }
}
