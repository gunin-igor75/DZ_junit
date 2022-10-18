package pro.sky.dz_junit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dz_junit.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculator;

    public CalculatorController(CalculatorService calculator) {
        this.calculator = calculator;
    }

    @GetMapping
    public String calculator() {
        return calculator.calculator();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer num1,
                       @RequestParam(value = "num2", required = false) Integer num2) {

        int result = calculator.plus(num1, num2);
        return String.format("<h2>%d + %d = %d<h2/>", num1, num2, result);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {
        int result = calculator.minus(num1, num2);
        return String.format("<h2>%d - %d = %d<h2/>", num1, num2, result);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam (value = "num1", required = false)  Integer num1,
                           @RequestParam (value = "num2", required = false) Integer num2){
        int result = calculator.multiply(num1, num2);
        return String.format("<h2>%d * %d = %d<h2/>", num1, num2, result);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam (value = "num1", required = false)  Integer num1,
                         @RequestParam (value = "num2", required = false) Integer num2){
        double result = calculator.divide(num1, num2);
        return String.format("<h2>%d / %d = %f<h2/>", num1, num2, result);
    }
}
