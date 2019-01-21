package by.bsu.kozlov.converter.impl;

import by.bsu.kozlov.IncorrectInputException;
import by.bsu.kozlov.converter.IConvert;
import by.bsu.kozlov.entity.Measures;

public class ConvertTemperature implements IConvert {

    private static ConvertTemperature instance;

    public static synchronized ConvertTemperature getInstance() {
        if (instance == null) {
            instance = new ConvertTemperature();
        }
        return instance;
    }


    @Override
    public Double convert(Double value, String convertFrom, String convertTo) {
        if (convertFrom.equals(Measures.CELSIUS.name())) {
            if (convertTo.equals(Measures.CELSIUS.name())) {
                return value;
            } else if (convertTo.equals(Measures.KELVINS.name())) {
                return value + 273.15;
            } else if (convertTo.equals(Measures.FAHRENHEIT.name())) {
                return value * 1.8 + 32;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.KELVINS.name())) {
            if (convertTo.equals(Measures.CELSIUS.name())) {
                return value - 273.15;
            } else if (convertTo.equals(Measures.KELVINS.name())) {
                return value;
            } else if (convertTo.equals(Measures.FAHRENHEIT.name())) {
                return value - 273.15 * 1.8 + 32;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.FAHRENHEIT.name())) {
            if (convertTo.equals(Measures.CELSIUS.name())) {
                return (value * 1.8) + 32;
            } else if (convertTo.equals(Measures.KELVINS.name())) {
                return (value - 32) * 5 / 9 + 273.15;
            } else if (convertTo.equals(Measures.FAHRENHEIT.name())) {
                return value;
            } else throw new IncorrectInputException();

        } else throw new IncorrectInputException();
    }
}
