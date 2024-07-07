import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarFrame extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JLabel lbWelcome;

    public JPanel initialize(LocalDate date) {
        // TODO Auto-generated method stub
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        mainPanel.add(lbWelcome, BorderLayout.NORTH);

        return mainPanel;
    }
}