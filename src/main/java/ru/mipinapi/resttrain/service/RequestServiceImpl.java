package ru.mipinapi.resttrain.service;

import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    public String getEndpointA(String data) {

        String[] subStr = data.split(",");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < subStr.length; i++) {
            if (i == subStr.length - 1)
                result.append(parseAndPlusOne(subStr[i]));
            else
                result.append(parseAndPlusOne(subStr[i])).append(",");
        }
        return result.toString();
    }

    public String postEndpointB(String data) {

        return "";
    }

    private Integer parseAndPlusOne(String part) {
        return Integer.parseInt(part) + 1;
    }
}
