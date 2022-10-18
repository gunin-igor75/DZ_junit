package pro.sky.dz_junit.service;

import org.springframework.stereotype.Service;
import pro.sky.dz_junit.exeption.BadRequestException;
import pro.sky.dz_junit.exeption.ZeroDivideException;

@Service
public class CalculatorServiceImp implements CalculatorService {
    @Override
    public String calculator() {
        return "<h1>Добро пожаловать в калькулятор<h1/>";
    }

    @Override
    public int plus(Integer num1, Integer num2) {
        check(num1,num2);
        return num1 + num2;
    }


    @Override
    public int minus(Integer num1, Integer num2) {
        check(num1,num2);
        return num1 - num2;
    }

    @Override
    public int multiply(Integer num1, Integer num2) {
        check(num1,num2);
        return num1 * num2;
    }

    @Override
    public double divide(Integer num1, Integer num2) {
        check(num1,num2);
        if (num2 == 0) {
            throw new ZeroDivideException();
        }
        return (double) num1 / num2;
    }

    private boolean check(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
        return true;
    }
}
