package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class  Car{
    private Integer ID;
    private String type;
    private String mark;
    private String model;
    private Integer year_make;
    private Integer run;
    private String color;
    private String type_body;
    private String gearbox;
    private String engine_powers;
    private String engine_volume;
    private String all_driver;

    public Car(String type, String mark, String model, Integer year_make, String color, String type_body) {
        this.type = type;
        this.mark = mark;
        this.model = model;
        this.year_make = year_make;
        this.color = color;
        this.type_body = type_body;
    }

    @Override
    public String toString() {
        return "Тип автомобиля: " + type + ", " +
                "Марка: " + mark + ", " +
                "Модель: " + model + ", " +
                "Год выпуска: " + year_make + ", " +
                "Цвет: " + color + ", " +
                "Тип кузова: " + type_body;
    }
}
