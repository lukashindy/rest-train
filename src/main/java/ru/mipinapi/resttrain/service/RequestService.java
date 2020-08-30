package ru.mipinapi.resttrain.service;

import ru.mipinapi.resttrain.model.Request;

public interface RequestService {

    String getEndpointA(String data);

    String postEndpointB(String data, Request request);

    String postEndpointB(String data, Integer number);
}
