package ru.mipinapi.resttrain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.mipinapi.resttrain.model.Request;

import static org.junit.jupiter.api.Assertions.*;

class RequestServiceImplTest {

    String parameter = "1,100,1000", result;
    Integer postNumber = 1000;

    RequestService requestService;

    public RequestServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        requestService = new RequestServiceImpl();
    }

    @Test
    void getEndpointA() {
        result = requestService.getEndpointA(parameter);
        assertEquals("2, 101, 1001", result);
    }

    @Test
    void postEndpointB() {
        result = requestService.postEndpointB(parameter, postNumber);
        assertEquals("1001, 1100, 2000", result);
    }

    @Test
    void postEndpointBWithRequestBody() {

        // given
        Request request = Request.builder().number("1000").build();

        // when
        result = requestService.postEndpointB(parameter, request);

        // then
        assertEquals("1001, 1100, 2000", result);
    }
}
