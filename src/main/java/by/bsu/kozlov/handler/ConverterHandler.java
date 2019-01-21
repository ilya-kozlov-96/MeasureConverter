package by.bsu.kozlov.handler;

import by.bsu.kozlov.converter.IConvert;
import by.bsu.kozlov.exception.IncorrectInputException;
import by.bsu.kozlov.utils.ChainOfResponsibility;
import by.bsu.kozlov.utils.ConverterUtil;
import org.springframework.stereotype.Service;

@Service
public class ConverterHandler {

    private static final String ERR = "Incorrect Input!";

    public Double convert(Double value, String convertFrom, String convertTo) {
        int converterType = ConverterUtil.getConverterType(convertFrom, convertTo);
        IConvert iConvert = ChainOfResponsibility.getConverter(converterType);
        Double response;
        try {
            response = iConvert.convert(value, convertFrom, convertTo);
        } catch (NullPointerException e) {
            throw new IncorrectInputException(e.getMessage());
        }
        return response;
    }

}
