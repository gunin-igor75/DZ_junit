package pro.sky.dz_junit.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.dz_junit.exeption.BadRequestException;
import pro.sky.dz_junit.exeption.ZeroDivideException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.dz_junit.service.ValuesTest.*;

public class CalculateServiceImpParamTest {
    private final CalculatorServiceImp calcService = new CalculatorServiceImp();

    @ParameterizedTest
    @MethodSource("setNumbersOne")
    void plusTestOne(Integer int1, Integer int2) {
        assertEquals(int1 + int2, calcService.plus(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersTwo")
    void plusTestTwo(Integer int1, Integer int2) {
        assertThrows(BadRequestException.class, () -> calcService.plus(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersOne")
    void minusTestOne(Integer int1, Integer int2) {
        assertEquals(int1 - int2, calcService.minus(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersTwo")
    void minusTestTwo(Integer int1, Integer int2) {
        assertThrows(BadRequestException.class, () -> calcService.minus(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersOne")
    void multiplyTestOne(Integer int1, Integer int2) {
        assertEquals(int1 * int2, calcService.multiply(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersTwo")
    void multiplyTestTwo(Integer int1, Integer int2) {
        assertThrows(BadRequestException.class, () -> calcService.multiply(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersOne")
    void divideTestOne(Integer int1, Integer int2) {
        assertEquals((double) int1 / int2, calcService.divide(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersTwo")
    void divideTestTwo(Integer int1, Integer int2) {
        assertThrows(BadRequestException.class, () -> calcService.divide(int1, int2));
    }

    @ParameterizedTest
    @MethodSource("setNumbersDivide")
    void divideTestThree(Integer int1, Integer int2) {
        assertThrows(ZeroDivideException.class, () -> calcService.divide(int1, int2));
    }


    private static Stream<Arguments> setNumbersOne() {
        return Stream.of(
                Arguments.of(TWO, ONE),
                Arguments.of(ZERO, FIVE),
                Arguments.of(FIVE, ONE)
        );
    }


    private static Stream<Arguments> setNumbersTwo() {
        return Stream.of(
                Arguments.of(null, ONE),
                Arguments.of(ZERO, null),
                Arguments.of(null, null)
        );
    }

    private static Stream<Arguments> setNumbersDivide() {
        return Stream.of(
                Arguments.of(FIVE, ZERO)
        );
    }
}
