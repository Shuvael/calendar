import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainFrame extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;
    LocalDate today = LocalDate.now();
    LocalDate yesterday = LocalDate.now().minusDays(1);
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    CalendarFrame calendarFrame = new CalendarFrame();

    public void initialize(){
        /****** Form Panel ****** */
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont((mainFont));

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("First Name");
        lbLastName.setFont((mainFont));

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1,5,5));
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfFirstName);

        /************** Welcome Label **************/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);


        /********* Buttons Panel **********/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName);
            }
            
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
        
        });

        JButton btnLastDay = new JButton(yesterday.toString());
        btnLastDay.setFont(mainFont);
        btnLastDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CalendarFrame lastDayFrame = new CalendarFrame();
                lastDayFrame.initialize(today);
            }
        });        


        JPanel  buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2,2,5,5));
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);
        buttonsPanel.add(btnLastDay);




        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        JPanel calendarPanel = calendarFrame.initialize(today);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(mainPanel);
        splitPane.setRightComponent(calendarPanel);

        add(splitPane);


        setTitle("Mein Kalender");
        setSize(500,500);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args){
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}