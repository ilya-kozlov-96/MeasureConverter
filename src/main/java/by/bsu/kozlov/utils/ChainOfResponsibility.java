package by.bsu.kozlov.utils;

import by.bsu.kozlov.converter.IConvert;
import by.bsu.kozlov.converter.impl.ConvertLength;
import by.bsu.kozlov.converter.impl.ConvertTemperature;
import by.bsu.kozlov.converter.impl.ConvertWeight;

public class ChainOfResponsibility {

    public static IConvert getConverter(int convertType) {

        IConvert iConvert;
        switch (convertType) {
            case 1:
                iConvert = ConvertLength.getInstance();
                break;
            case 2:
                iConvert = ConvertWeight.getInstance();
                break;
            case 3:
                iConvert = ConvertTemperature.getInstance();
                break;
            default:
                iConvert = null;
                break;

        }
        return iConvert;
    }
}
