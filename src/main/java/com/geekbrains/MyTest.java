package com.geekbrains;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;

public class MyTest {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Main.class);
    public void newArray(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            if (arr[i - 1] == 4) {
                int[] arr1 = new int[(arr.length - i)];
                System.arraycopy(arr, i, arr1, 0, arr.length - i);
                LOGGER.info("Создали массив пример - Вх:  " + Arrays.toString(arr) + " -> вых: " +
                        Arrays.toString(arr1) + ".");
                return;
            }
        }
        throw new MyRuntimeException("Это сообщение ошибки - RuntimeException");
    }

    public int[] fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 5);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public boolean oneFour(int[] arr1) {
        System.out.println(Arrays.toString(arr1));

        IntStream stream = IntStream.of(arr1)
                .filter((int val) -> val == 1 || val == 4);

        if (arr1.length != stream.count()) {
            return false;
        } else {
            IntStream stream1 = IntStream.of(arr1);
            int sum = stream1.sum();
            return sum != arr1.length && sum != arr1.length * 4;
        }
    }
}
