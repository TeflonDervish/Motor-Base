package forms;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AuthForm extends JFrame {

    public AuthForm() {
        // Настройка основного окна
        setTitle("Authentication Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание табов (вкладок)
        JTabbedPane tabbedPane = new JTabbedPane();

        // Вкладка авторизации
        JPanel loginPanel = createLoginPanel();
        tabbedPane.addTab("Login", loginPanel);

        // Вкладка регистрации
        JPanel registerPanel = createRegisterPanel();
        tabbedPane.addTab("Register", registerPanel);

        // Добавляем табы в окно
        add(tabbedPane);
    }

    // Метод для создания панели авторизации
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(44, 62, 80));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Логотип
        JLabel logoLabel = new JLabel();
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Замените путь к изображению своим, если оно есть
        logoLabel.setIcon(new ImageIcon("logo.png"));

        // Заголовок
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Поле ввода имени пользователя с placeholder
        JTextField usernameField = new JTextField(15);
        addPlaceholder(usernameField, "Username");
        styleTextField(usernameField);

        // Поле ввода пароля с placeholder
        JPasswordField passwordField = new JPasswordField(15);
        addPlaceholder(passwordField, "Password");
        stylePasswordField(passwordField);

        // Кнопка входа
        JButton loginButton = new JButton("Login");
        styleButton(loginButton);

        // Добавляем элементы на панель
        panel.add(logoLabel); // Логотип
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(loginButton);

        return panel;
    }

    // Метод для создания панели регистрации
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(44, 62, 80));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Логотип
        JLabel logoLabel = new JLabel();
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Замените путь к изображению своим, если оно есть
        logoLabel.setIcon(new ImageIcon("logo.png"));

        // Заголовок
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Поле ввода имени пользователя с placeholder
        JTextField usernameField = new JTextField(15);
        addPlaceholder(usernameField, "Username");
        styleTextField(usernameField);

        // Поле ввода email с placeholder
        JTextField emailField = new JTextField(15);
        addPlaceholder(emailField, "Email");
        styleTextField(emailField);

        // Поле ввода пароля с placeholder
        JPasswordField passwordField = new JPasswordField(15);
        addPlaceholder(passwordField, "Password");
        stylePasswordField(passwordField);

        // Кнопка регистрации
        JButton registerButton = new JButton("Register");
        styleButton(registerButton);

        // Добавляем элементы на панель
        panel.add(logoLabel); // Логотип
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(registerButton);

        return panel;
    }

    // Метод для добавления placeholder в текстовое поле
    private void addPlaceholder(JTextComponent field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
    }

    // Метод для стилизации текстовых полей
    private void styleTextField(JTextField field) {
        field.setMaximumSize(new Dimension(300, 40));
        field.setFont(new Font("Arial", Font.PLAIN, 18));
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        field.setBackground(new Color(44, 62, 80));
        field.setForeground(Color.WHITE);
    }

    // Метод для стилизации полей пароля
    private void stylePasswordField(JPasswordField field) {
        field.setMaximumSize(new Dimension(300, 40));
        field.setFont(new Font("Arial", Font.PLAIN, 18));
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        field.setBackground(new Color(44, 62, 80));
        field.setForeground(Color.WHITE);
    }

    // Метод для стилизации кнопок
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        // Создание и отображение формы
        SwingUtilities.invokeLater(() -> new AuthForm().setVisible(true));
    }
}
