package ru.mipinapi.resttrain.utils;

import ru.mipinapi.resttrain.exceptions.RequestException;

public class ParseHelper {

    public static void checkParse(String data) {
        try {
            String[] subStr = data.split(",");
            Integer result;

            for (String s : subStr) result = Integer.parseInt(s);

        } catch (NumberFormatException exc) {
            throw new RequestException("The url is not correct");
        }
    }

}
