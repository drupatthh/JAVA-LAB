import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class LoginForm extends JFrame {
    private static final String VALID_USERNAME = "student";
    private static final String VALID_PASSWORD = "java123";

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public LoginForm() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fields = new JPanel(new GridLayout(2, 2, 5, 5));
        fields.add(new JLabel("Username:"));
        fields.add(usernameField);
        fields.add(new JLabel("Password:"));
        fields.add(passwordField);

        JButton login = new JButton("Login");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        login.addActionListener(event -> authenticate());
        reset.addActionListener(event -> resetFields());
        exit.addActionListener(event -> dispose());

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(reset);
        buttons.add(exit);

        add(fields, java.awt.BorderLayout.CENTER);
        add(buttons, java.awt.BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password",
                    "Login failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(LoginForm::new);
    }
}
