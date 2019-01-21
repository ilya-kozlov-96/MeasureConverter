package by.bsu.kozlov.converter.impl;

import by.bsu.kozlov.IncorrectInputException;
import by.bsu.kozlov.converter.IConvert;
import by.bsu.kozlov.entity.Measures;

public class ConvertLength implements IConvert {

    private static ConvertLength instance;

    private static final Double METERS_TO_MILE = 1609.334;
    private static final Double VERST_TO_METER = 1066.8;
    private static final Double MILES_TO_VERST = 1.50857;

    public static synchronized ConvertLength getInstance() {
        if (instance == null) {
            instance = new ConvertLength();
        }
        return instance;
    }


    @Override
    public Double convert(Double value, String convertFrom, String convertTo) {
        if (convertFrom.equals(Measures.METERS.name())) {
            if (convertTo.equals(Measures.METERS.name())) {
                return value;
            } else if (convertTo.equals(Measures.MILES.name())) {
                return value / METERS_TO_MILE;
            } else if (convertTo.equals(Measures.VERST.name())) {
                return value / VERST_TO_METER;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.MILES.name())) {
            if (convertTo.equals(Measures.METERS.name())) {
                return value * METERS_TO_MILE;
            } else if (convertTo.equals(Measures.MILES.name())) {
                return value;
            } else if (convertTo.equals(Measures.VERST.name())) {
                return value * MILES_TO_VERST;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.VERST.name())) {
            if (convertTo.equals(Measures.METERS.name())) {
                return value * VERST_TO_METER;
            } else if (convertTo.equals(Measures.MILES.name())) {
                return value / MILES_TO_VERST;
            } else if (convertTo.equals(Measures.VERST.name())) {
                return value;
            } else throw new IncorrectInputException();

        } else throw new IncorrectInputException();
    }
}
