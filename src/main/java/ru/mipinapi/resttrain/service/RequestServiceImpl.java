package ru.mipinapi.resttrain.service;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.mipinapi.resttrain.model.Request;

@Service
public class RequestServiceImpl implements RequestService {

    public RequestServiceImpl() {
    }

    public String getEndpointA(String data) {

        String[] subStr = data.split(",");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < subStr.length; i++) {
            if (i == subStr.length - 1)
                result.append(parseAndPlusOne(subStr[i]));
            else
                result.append(parseAndPlusOne(subStr[i])).append(", ");
        }
        return result.toString();
    }

    public String postEndpointB(String data, Integer number) {
        String[] subStr = data.split(",");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < subStr.length; i++) {
            if (i == subStr.length - 1)
                result.append(parse(subStr[i]) + number);
            else
                result.append(parse(subStr[i]) + number).append(", ");
        }
        return result.toString();
    }

    public String postEndpointB(String data, Request request) {
        String[] subStr = data.split(",");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < subStr.length; i++) {
            if (i == subStr.length - 1)
                result.append(parse(subStr[i]) + Integer.parseInt(request.getNumber()));
            else
                result.append(parse(subStr[i]) + Integer.parseInt(request.getNumber())).append(", ");
        }
        return result.toString();
    }

    private Integer parseAndPlusOne(String part) {
        return parse(part) + 1;
    }

    private Integer parse(String part) {
        return Integer.parseInt(part);
    }
}
