package by.bsu.kozlov.controller;


import by.bsu.kozlov.exception.IncorrectInputException;
import by.bsu.kozlov.handler.ConverterHandler;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConverterController {

    @RequestMapping(value = "/convert", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String convert(@RequestParam("value") Double value, @RequestParam("convertFrom") String convertFrom, @RequestParam("convertTo") String convertTo) throws IncorrectInputException {
        ConverterHandler converterHandler = new ConverterHandler();
        return converterHandler.convert(value, convertFrom, convertTo).toString();
    }
}
