package forms;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    public MainForm() {
        // Настройка основного окна
        setTitle("E-commerce Template");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Верхняя панель (Header)
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(64, 128, 255));

        // Логотип
        JLabel logoLabel = new JLabel("MyShop");
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Строка поиска
        JTextField searchField = new JTextField("Search products...");
        searchField.setPreferredSize(new Dimension(400, 30));
        headerPanel.add(searchField, BorderLayout.CENTER);

        // Кнопка поиска
        JButton searchButton = new JButton("Search");
        headerPanel.add(searchButton, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        // Левая панель (Фильтры)
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.setBackground(Color.WHITE);

        filterPanel.add(new JLabel("Фильтры"));

        JCheckBox filter1 = new JCheckBox("Акции и скидки");
        JCheckBox filter2 = new JCheckBox("Новинки");
        JCheckBox filter3 = new JCheckBox("Популярные");

        filterPanel.add(filter1);
        filterPanel.add(filter2);
        filterPanel.add(filter3);

        filterPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Пробел

        JComboBox<String> categoryFilter = new JComboBox<>(new String[]{"Категория", "Одежда", "Электроника", "Книги"});
        filterPanel.add(categoryFilter);

        JComboBox<String> priceFilter = new JComboBox<>(new String[]{"Цена", "до 1000 руб.", "1000-5000 руб.", "5000-10000 руб."});
        filterPanel.add(priceFilter);

        add(filterPanel, BorderLayout.WEST);

        // Центральная панель (Продукты)
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(2, 2, 15, 15));
        productPanel.setBackground(Color.WHITE);

        // Пример продуктов
        productPanel.add(createProductPanel("Продукт 1", "1000 руб.", "path_to_image"));
        productPanel.add(createProductPanel("Продукт 2", "5000 руб.", "path_to_image"));
        productPanel.add(createProductPanel("Продукт 3", "3000 руб.", "path_to_image"));
        productPanel.add(createProductPanel("Продукт 4", "7000 руб.", "path_to_image"));

        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Метод для создания панели продукта
    private JPanel createProductPanel(String productName, String price, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Вставить изображение товара
        JLabel imageLabel = new JLabel(); // Здесь можно вставить ImageIcon для картинки
        imageLabel.setPreferredSize(new Dimension(150, 150));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Имя товара и цена
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(new JLabel(productName));
        infoPanel.add(new JLabel(price));

        panel.add(infoPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainForm::new);
    }
}
