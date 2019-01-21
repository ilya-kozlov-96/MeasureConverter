package by.bsu.kozlov.utils;

import by.bsu.kozlov.entity.Measures;

public class ConverterUtil {

    public static int getConverterType(String valueFrom, String valueTo) {
        if (getConventionTypeIfValid(valueFrom) == (getConventionTypeIfValid(valueTo))) {
            return getConventionTypeIfValid(valueFrom);
        }
        return 0;
    }

    private static int getConventionTypeIfValid(String param) {
        for (Measures measure : Measures.values()) {
            if (measure.name().equals(param)) {
                return measure.getValue();
            }
        }
        return 0;
    }

}
