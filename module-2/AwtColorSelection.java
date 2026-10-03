import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtColorSelection extends Frame {
    private final Panel colorPanel = new Panel();

    public AwtColorSelection() {
        super("Color Selection");
        setLayout(new FlowLayout());

        addColorButton("Red", Color.RED);
        addColorButton("Green", Color.GREEN);
        addColorButton("Blue", Color.BLUE);
        addColorButton("Yellow", Color.YELLOW);
        colorPanel.setPreferredSize(new java.awt.Dimension(300, 150));
        add(colorPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });

        setSize(350, 250);
        setVisible(true);
    }

    private void addColorButton(String title, Color color) {
        Button button = new Button(title);
        button.addActionListener(event -> colorPanel.setBackground(color));
        add(button);
    }

    public static void main(String[] args) {
        new AwtColorSelection();
    }
}
