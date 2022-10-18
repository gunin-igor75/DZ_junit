package pro.sky.dz_junit.service;

import org.junit.jupiter.api.Test;
import pro.sky.dz_junit.exeption.BadRequestException;
import pro.sky.dz_junit.exeption.ZeroDivideException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.dz_junit.service.ValuesTest.*;

class CalculatorServiceImpTest {
    private final CalculatorServiceImp calcService = new CalculatorServiceImp();

    @Test
    void plusOneTest() {
        assertAll("Testing plus",
                () -> assertThrows(BadRequestException.class, () -> calcService.plus(null,ONE)),
                () -> assertEquals(ONE + TWO, calcService.plus(ONE, TWO)));
    }

    @Test
    void plusTwoTest() {
        assertAll("Testing plus",
                () -> assertThrows(BadRequestException.class, () -> calcService.plus(null,null)),
                () -> assertEquals(FIVE + ONE, calcService.plus(FIVE, ONE)));
    }

    @Test
    void minusOneTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.minus(null, FIVE)),
                () -> assertEquals(FIVE - TWO, calcService.minus(FIVE, TWO)));
    }
    @Test
    void minusTwoTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.minus(null, null)),
                () -> assertEquals(ZERO - TWO, calcService.minus(ZERO, TWO)));
    }
    @Test
    void multiplyOneTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.multiply(null, FIVE)),
                () -> assertEquals(FIVE * TWO, calcService.multiply(FIVE, TWO)));
    }
    @Test
    void multiplyTwoTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.multiply(null, null)),
                () -> assertEquals(ZERO * TWO, calcService.multiply(ZERO, TWO)));
    }

    @Test
    void divideOneTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.divide(null, FIVE)),
                () -> assertEquals((double)FIVE / TWO, calcService.divide(FIVE, TWO)),
                () -> assertThrows(ZeroDivideException.class, () -> calcService.divide(ONE, ZERO)));
    }
    @Test
    void divideTwoTest() {
        assertAll("Testing minus",
                () -> assertThrows(BadRequestException.class, () -> calcService.divide(null, null)),
                () -> assertEquals((double)ZERO / TWO, calcService.divide(ZERO, TWO)),
                () -> assertThrows(ZeroDivideException.class, () -> calcService.divide(FIVE, ZERO)));
    }
}