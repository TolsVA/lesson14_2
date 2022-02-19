package com.geekbrains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        int[] arr = new int[10];
        try {
            myTest.newArray(myTest.fillArray(arr));
        } catch (RuntimeException e) {
            LOGGER.error(e);
        }

        int[] arr1 = new int[] {1, 1, 4, 1, 4, 4, 1, 4, 4, 1};
        myTest.oneFour(arr1);

        serverStarted();
        int password = 1234;
        errorOccurred(password);
        password = 4321;
        errorOccurred(password);
    }

    private static String messageCommand(String s) {
        return s + " Сменить пароль - 1234";
    }

    private static void serverStarted() {
        // какая-то логика
        // инфо
        LOGGER.info("Сервер запущен");
    }

    private static void errorOccurred(int i) {
        int j = 4321;
        try {
            if (i != j) {
                throw new MyRuntimeException("Произошла ошибка введен не верный пароль.");
            }
            LOGGER.info("Клиент подключился.");
            LOGGER.info(messageCommand("Клиент прислал сообщение/команду."));
        } catch (MyRuntimeException e) {
            LOGGER.error(e);
        }
    }
}
