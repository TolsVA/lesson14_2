package com.geekbrains;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MyTestTest {
    private MyTest myTest;

    @BeforeEach
    void setUp() {
        myTest = new MyTest();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Все тесты были выполнены");
    }


    @Test
    void newArray() {
        int[] arr = new int[]{1, 2, 3, 9, 3, 6, 7, 8};
        Assertions.assertThrows(RuntimeException.class, () -> {
            myTest.newArray(arr); // Проверяет наличие 4 если нет возвращает - throw new RuntimeException();
        });
    }

    @Disabled("Тест отключен")
    @CsvSource({ "1, 3, 4, 6, 8, 9, 2, 3",
            "2, 5, 5, 6, 9, 0, 0, 1",
            "3, 3, 7, 8, 9, 0, 1, 2",
            "4, 5, 4, 1, 3, 2, 8, 5" })
    @ParameterizedTest
    public void massTestAdd(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            myTest.newArray(new int[]{a1, a2, a3, a4, a5, a6, a7, a8}); // throw new RuntimeException();
        });
    }

    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void testAddOperation(int[] arr) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            myTest.newArray(arr); // throw new RuntimeException();
        });
    }

    public static Stream<Arguments> dataForAddOperation() { List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int[] arr = new int[(int) (Math.random() * 9) + 5];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * 5);
            }
            out.add(Arguments.arguments(arr));
        }
        return out.stream();
    }

    @CsvSource({ "1, 1, 1, 4, 4, 1, 4, 4",   // -> true
            "1, 4, 4, 4, 4, 4, 4, 4 ",       // -> true
            "1, 1, 1, 1, 1, 1, 1, 4",        // -> true
            "1, 4, 4, 1, 1, 4, 3, 1" })      // -> false
    @ParameterizedTest
    public void testOneFour(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8){
        int[] arr = new int[]{a1, a2, a3, a4, a5, a6, a7, a8};
        Assertions.assertTrue(myTest.oneFour(arr));
    }


    @CsvSource({ "1, 1, 1, 4, 4, 1, 4, 4",   // -> false
            "1, 1, 1, 1, 1, 1, 1, 1 ",       // -> true
            "4, 4, 4, 4, 4, 4, 4, 4",        // -> true
            "1, 4, 4, 1, 1, 4, 3, 1" })      // -> true
    @ParameterizedTest
    public void testOneFour1(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8){
        int[] arr = new int[]{a1, a2, a3, a4, a5, a6, a7, a8};
        Assertions.assertFalse(myTest.oneFour(arr));
    }

    @ParameterizedTest
    @MethodSource("dataForAddOperation1")
    public void testOneFour2(int[] arr) {
        Assertions.assertTrue(myTest.oneFour(arr));
    }

    @ParameterizedTest
    @MethodSource("dataForAddOperation1")
    public void testOneFour3(int[] arr) {
        Assertions.assertFalse(myTest.oneFour(arr));
    }

    public static Stream<Arguments> dataForAddOperation1() { List<Arguments> out = new ArrayList<>();
        int[] arr1 = new int[] {1, 1, 4, 4, 1, 3, 4, 4, 4, 1};
        for (int i = 0; i < 5; i++) {
            int[] arr = new int[(int) (Math.random() * 9) + 5];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = arr1[(int) (Math.random() * 10)];
            }
            out.add(Arguments.arguments(arr));
        }
        return out.stream();
    }

}