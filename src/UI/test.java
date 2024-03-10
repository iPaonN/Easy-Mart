import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame {
    private JLabel notificationBadge;
    private int notificationCount = 10;

    public test() {
        setTitle("Button Notification Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton button = new JButton("Notifications");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset notification count and update badge
                notificationCount = 0;
                updateNotificationBadge();
                
                // You can add your notification handling logic here
                // For example, opening a notification popup, etc.
            }
        });
        
        notificationBadge = new JLabel();
        notificationBadge.setForeground(Color.RED);
        notificationBadge.setHorizontalAlignment(SwingConstants.CENTER);
        notificationBadge.setPreferredSize(new Dimension(20, 20));
        updateNotificationBadge();
        
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(notificationBadge);
        
        getContentPane().add(panel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void updateNotificationBadge() {
        if (notificationCount > 0) {
            notificationBadge.setText(Integer.toString(notificationCount));
            notificationBadge.setVisible(true);
        } else {
            notificationBadge.setText("");
            notificationBadge.setVisible(false);
        }
    }
    
    // Method to increment notification count
    public void incrementNotificationCount() {
        notificationCount++;
        updateNotificationBadge();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new test();
            }
        });
    }
}