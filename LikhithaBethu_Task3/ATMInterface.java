import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.BorderFactory;
public class ATMInterface{
    static JButton depositButton;
    static JButton withdrawButton;
    static JButton balanceButton;
    static JButton exitButton;
    static JTextField field;
    static JLabel resultLabel;
    static JTextArea historyArea;
    static int BalanceAmount = 500000;
    static JButton transferButton;
    static JButton logoutButton;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setTitle("ATM Interface");
        JLabel title = new JLabel("ATM INTERFACE");
        title.setBounds(120,10,200,30);

        JLabel info = new JLabel("Enter amount and choose an operation");
        info.setBounds(70,30,250,20);

        frame.add(title);
        frame.add(info);

        resultLabel = new JLabel("Current Balance: ₹" + BalanceAmount);
        resultLabel.setBounds(50,50,300,30);

        field = new JTextField();

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            Integer amount = getAmount();
            if(amount != null)
            deposit(amount);
        });
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            Integer amount = getAmount();
            if(amount != null)
                withdraw(amount);
        });
        
        balanceButton = new JButton("Check Balance");  
        balanceButton.addActionListener(e -> balance());

        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setBorder(
        BorderFactory.createTitledBorder("Transaction History")
        );

        JScrollPane scrollPane = new JScrollPane(historyArea);

        transferButton = new JButton("Transfer");
        transferButton.addActionListener(e -> {
            Integer amount = getAmount();
            if(amount != null)
                transfer(amount);
        });

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            frame.dispose();
            LoginPage.main(null);
        });
        title.setFont(new Font("Arial", Font.BOLD, 22));

        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        depositButton.setFont(new Font("Arial", Font.BOLD, 13));
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 13));
        transferButton.setFont(new Font("Arial", Font.BOLD, 13));
        balanceButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 13));

        field.setBounds(180,100,120,30);
        depositButton.setBounds(80,160,120,35);
        withdrawButton.setBounds(260,160,120,35);
        transferButton.setBounds(80,220,120,35);
        balanceButton.setBounds(260,220,120,35);
        scrollPane.setBounds(50,280,380,180);
        logoutButton.setBounds(80,500,120,35);
        exitButton.setBounds(260,500,120,35);

        frame.add(transferButton);   
        frame.add(logoutButton);
        frame.add(scrollPane);
        frame.add(resultLabel);
        frame.add(field);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(balanceButton);
        frame.add(exitButton);
        frame.setSize(500,650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    private static Integer getAmount() {
        try {
            int amount = Integer.parseInt(field.getText().trim());

            if(amount <= 0){
                resultLabel.setText("Enter a positive amount.");
                field.setText("");
                field.requestFocus();
                return null;
            }

            return amount;
        }
        catch(NumberFormatException e){
            resultLabel.setText("Enter a valid number.");
            field.setText("");
            field.requestFocus();
            return null;
        }
    }
    private static void deposit(int amount){
        BalanceAmount += amount;

        resultLabel.setText(
            "Deposited ₹" + amount +
            " | Balance: ₹" + BalanceAmount
        );
        historyArea.append("[" + getTime() + "] Deposited ₹" + amount + "\n");
        field.setText("");
        field.requestFocus();
    }
    private static void withdraw(int amount){

        if(amount > BalanceAmount){
            resultLabel.setText("Insufficient Balance!");
            field.setText("");
            field.requestFocus();
            return;
        }
        if(amount > 100000){
            resultLabel.setText("Amount exceeds limit.");
            field.setText("");
            field.requestFocus();
            return;
        }
        BalanceAmount -= amount;

        resultLabel.setText(
            "Withdrawn ₹" + amount +
            " | Balance: ₹" + BalanceAmount
        );
        historyArea.append("[" + getTime() + "] Withdrawn ₹" + amount + "\n");
        field.setText("");
        field.requestFocus();
    }
    private static void balance(){
        resultLabel.setText("Current Balance: ₹" + BalanceAmount);
        field.requestFocus();
    }
    private static void transfer(int amount){
        if(amount > BalanceAmount){
            resultLabel.setText("Insufficient Balance!");
            field.setText("");
            field.requestFocus();
            return;
        }
        if(amount > 100000){
            resultLabel.setText("Amount exceeds limit.");
            field.setText("");
            field.requestFocus();
            return;
        }
        BalanceAmount -= amount;

        resultLabel.setText(
            "Transferred ₹" + amount +
            " | Balance: ₹" + BalanceAmount
        );
        historyArea.append("[" + getTime() + "] Transferred ₹" + amount + "\n");
        field.setText("");
        field.requestFocus();
    }
    private static String getTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}