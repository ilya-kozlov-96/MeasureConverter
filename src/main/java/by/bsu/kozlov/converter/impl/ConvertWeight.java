package by.bsu.kozlov.converter.impl;

import by.bsu.kozlov.IncorrectInputException;
import by.bsu.kozlov.converter.IConvert;
import by.bsu.kozlov.entity.Measures;

public class ConvertWeight implements IConvert {

    private static final Double POOD_TO_GRAMM = 16380.687;
    private static final Double POUND_TO_GRAMM = 453.592;
    private static final Double POUND_TO_POOD = 36.113;

    private static ConvertWeight instance;

    public static synchronized ConvertWeight getInstance() {
        if (instance == null) {
            instance = new ConvertWeight();
        }
        return instance;
    }

    @Override
    public Double convert(Double value, String convertFrom, String convertTo) {
        if (convertFrom.equals(Measures.GRAMS.name())) {
            if (convertTo.equals(Measures.GRAMS.name())) {
                return value;
            } else if (convertTo.equals(Measures.POUNDS.name())) {
                return value / POUND_TO_GRAMM;
            } else if (convertTo.equals(Measures.POODS.name())) {
                return value / POOD_TO_GRAMM;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.POUNDS.name())) {
            if (convertTo.equals(Measures.GRAMS.name())) {
                return value * POUND_TO_GRAMM;
            } else if (convertTo.equals(Measures.POUNDS.name())) {
                return value;
            } else if (convertTo.equals(Measures.POODS.name())) {
                return value / POUND_TO_POOD;
            } else throw new IncorrectInputException();

        } else if (convertFrom.equals(Measures.POODS.name())) {
            if (convertTo.equals(Measures.GRAMS.name())) {
                return value * POOD_TO_GRAMM;
            } else if (convertTo.equals(Measures.POUNDS.name())) {
                return value * POUND_TO_POOD;
            } else if (convertTo.equals(Measures.POODS.name())) {
                return value;
            } else throw new IncorrectInputException();

        } else throw new IncorrectInputException();
    }

}
