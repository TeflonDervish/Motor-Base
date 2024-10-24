package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    public LoginForm() {
        // Настройка основного окна
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Основная панель
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(44, 62, 80));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Заголовок
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Поле ввода имени пользователя
        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(300, 40));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        usernameField.setBackground(new Color(44, 62, 80));
        usernameField.setForeground(Color.WHITE);

        // Поле ввода пароля
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(300, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        passwordField.setBackground(new Color(44, 62, 80));
        passwordField.setForeground(Color.WHITE);

        // Кнопка входа
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(52, 152, 219));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Обработчик нажатия кнопки
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Добавляем элементы на панель
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(loginButton);

        // Добавляем панель в окно
        add(panel);
    }

    public static void main(String[] args) {
        // Создание и отображение формы
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
