package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    public LoginForm() {
        setTitle("Авторизация");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создаем панель с фоновым цветом
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(null);

        // Заголовок
        JLabel titleLabel = new JLabel("Вход в систему");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(100, 30, 200, 30);
        panel.add(titleLabel);

        // Поле для ввода логина
        JLabel usernameLabel = new JLabel("Логин:");
        usernameLabel.setBounds(50, 80, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 80, 200, 25);
        panel.add(usernameField);

        // Поле для ввода пароля
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(50, 120, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 200, 25);
        panel.add(passwordField);

        // Кнопка авторизации
        JButton loginButton = new JButton("Войти");
        loginButton.setBounds(150, 160, 100, 30);
        loginButton.setBackground(new Color(0, 120, 215));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);

        // Добавляем действие на кнопку
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Здесь можно добавить логику проверки логина и пароля
                JOptionPane.showMessageDialog(null, "Логин: " + username + "\nПароль: " + password);
            }
        });

        panel.add(loginButton);

        // Добавляем панель на фрейм
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}