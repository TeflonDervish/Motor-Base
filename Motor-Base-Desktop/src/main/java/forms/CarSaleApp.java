package forms;

import javax.swing.*;
import java.awt.*;

public class CarSaleApp extends JFrame {

    public CarSaleApp() {
        setTitle("Продажа автомобилей");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        // Панель для строки поиска
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(255, 255, 255));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Поиск");
        searchButton.setBackground(new Color(0, 120, 215));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);

        searchPanel.add(new JLabel("Поиск:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Панель фильтров
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(0, 1));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Фильтры"));
        filterPanel.setBackground(new Color(255, 255, 255));

        // Создание выпадающих списков для фильтров
        String[] brands = {"Все", "Toyota", "Ford", "BMW", "Mercedes"};
        String[] models = {"Все", "Модель 1", "Модель 2", "Модель 3"};
        String[] years = {"Все", "2020", "2021", "2022", "2023"};
        String[] mileages = {"Все", "0-10000", "10001-20000", "20001-50000"};
        String[] colors = {"Все", "Красный", "Синий", "Черный", "Белый"};
        String[] bodyTypes = {"Все", "Седан", "Хэтчбек", "Кроссовер", "Универсал"};

        JComboBox<String> brandComboBox = new JComboBox<>(brands);
        JComboBox<String> modelComboBox = new JComboBox<>(models);
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        JComboBox<String> mileageComboBox = new JComboBox<>(mileages);
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        JComboBox<String> bodyTypeComboBox = new JComboBox<>(bodyTypes);

        filterPanel.add(new JLabel("Марка:"));
        filterPanel.add(brandComboBox);
        filterPanel.add(new JLabel("Модель:"));
        filterPanel.add(modelComboBox);
        filterPanel.add(new JLabel("Год выпуска:"));
        filterPanel.add(yearComboBox);
        filterPanel.add(new JLabel("Пробег:"));
        filterPanel.add(mileageComboBox);
        filterPanel.add(new JLabel("Цвет:"));
        filterPanel.add(colorComboBox);
        filterPanel.add(new JLabel("Тип кузова:"));
        filterPanel.add(bodyTypeComboBox);

        JButton applyFiltersButton = new JButton("Применить фильтры");
        applyFiltersButton.setBackground(new Color(0, 120, 215));
        applyFiltersButton.setForeground(Color.WHITE);
        applyFiltersButton.setFocusPainted(false);
        applyFiltersButton.setBorderPainted(false);

        filterPanel.add(applyFiltersButton);

        // Панель для списка автомобилей
        JPanel carListPanel = new JPanel();
        carListPanel.setLayout(new BoxLayout(carListPanel, BoxLayout.Y_AXIS));
        carListPanel.setBorder(BorderFactory.createTitledBorder("Список автомобилей"));
        carListPanel.setBackground(new Color(255, 255, 255));

        // Пример автомобилей
        for (int i = 1; i <= 5; i++) {
            JPanel carPanel = new JPanel();
            carPanel.setLayout(new BorderLayout());
            carPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
            carPanel.setBackground(new Color(240, 240, 240));
            carPanel.setPreferredSize(new Dimension(750, 60));

            JLabel carLabel = new JLabel("Автомобиль " + i);
            carLabel.setFont(new Font("Arial", Font.BOLD, 16));
            carLabel.setHorizontalAlignment(SwingConstants.LEFT);
            carPanel.add(carLabel, BorderLayout .CENTER);

            JButton buyButton = new JButton("Купить");
            buyButton.setBackground(new Color(0, 120, 215));
            buyButton.setForeground(Color.WHITE);
            buyButton.setFocusPainted(false);
            buyButton.setBorderPainted(false);
            carPanel.add(buyButton, BorderLayout.EAST);

            carListPanel.add(carPanel);
        }

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(filterPanel, BorderLayout.WEST);
        mainPanel.add(carListPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CarSaleApp().setVisible(true);
            }
        });
    }
}