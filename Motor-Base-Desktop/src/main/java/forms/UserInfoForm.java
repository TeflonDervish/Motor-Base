package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoForm extends JFrame {

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField phoneField;
    private JTextArea outputArea;

    public UserInfoForm() {
        setTitle("User Information Form");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание панелей
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Поля для ввода
        inputPanel.add(new JLabel("Имя:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Фамилия:"));
        surnameField = new JTextField();
        inputPanel.add(surnameField);

        inputPanel.add(new JLabel("Телефон:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        JButton submitButton = new JButton("Отправить");
        submitButton.addActionListener(new SubmitButtonListener());
        inputPanel.add(submitButton);

        // Область вывода
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(10, 10, 10, 10));

        // Добавление панелей к фрейму
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setLocationRelativeTo(null); // Центрировать окно
        setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String phone = phoneField.getText();
            outputArea.setText("Имя: " + name + "\nФамилия: " + surname + "\nТелефон: " + phone);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserInfoForm::new);
    }
}
