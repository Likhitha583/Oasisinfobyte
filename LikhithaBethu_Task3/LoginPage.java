import javax.swing.*;

public class LoginPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ATM Login");
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 50, 80, 25);

        JTextField userField = new JTextField();
        userField.setBounds(130, 50, 120, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 90, 80, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 90, 120, 25);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110, 140, 100, 30);

        loginButton.addActionListener(e -> {

            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if(user.equals("admin") && pass.equals("1234")) {

                frame.dispose(); // close login window

                ATMInterface.main(null); // open ATM

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "Invalid User ID or Password!"
                );
            }
        });

        JTextField field = new JTextField();

        field.addActionListener(e -> loginButton.doClick()); 
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}