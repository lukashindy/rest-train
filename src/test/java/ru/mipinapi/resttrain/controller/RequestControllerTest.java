package ru.mipinapi.resttrain.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.mipinapi.resttrain.model.Request;
import ru.mipinapi.resttrain.service.RequestService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RequestControllerTest {

    @Mock
    RequestService requestService;

    @InjectMocks
    RequestController requestController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        requestController = new RequestController(requestService);
        mockMvc = MockMvcBuilders.standaloneSetup(requestController).build();
    }

    @Test
    void getEndpointA() throws Exception {
        mockMvc.perform(get("/api/1,2,3,4,5")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void postEndpointB() throws Exception {
        mockMvc.perform(post("/api/1,2,3,4,5/100")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void postEndpointBSecondWayWithBody() throws Exception {
        Request request = Request.builder().number("1").build();

//        mockMvc.perform(post("/api/1,2,3,4,5")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(mapToJson(request)))
//                .andExpect(status().isOk())
//                .andReturn();
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
