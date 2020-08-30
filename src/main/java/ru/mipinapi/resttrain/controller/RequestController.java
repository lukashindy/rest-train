package ru.mipinapi.resttrain.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mipinapi.resttrain.model.Request;
import ru.mipinapi.resttrain.service.RequestService;

import javax.persistence.Column;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    /**
     * @param data - string with numbers
     * @return response - Check with Postman API: http://127.0.0.1:8080/api/1,5,125,-123 as example
     */
    @GetMapping(value = "/{data}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEndpointA(@RequestBody @PathVariable String data) {
        String response = requestService.getEndpointA(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * @param number - number for post
     * @return response -> Check with Postman API: http://127.0.0.1:8080/api/1,100,1000/323 as example
     * result - 324, 423, 1323
     */
    @PostMapping(value = "/{data}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postEndpointB(@PathVariable String data,
                                                @PathVariable Integer number) {
        String response = requestService.postEndpointB(data, number);
        return ResponseEntity.ok(response);
    }


    /**
     * @param request - object of request with number as parameter
     * @return response - Check with Postman API: http://127.0.0.1:8080/api/1,100,1000,10000 as example
     * Body raw:
     * {
     *     "number" : 10000
     * }
     * result - 10001, 10100, 11000, 20000
     */
    @PostMapping(value = "/{data}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postEndpointBSecondWayWithBody(@PathVariable String data,
                                                                 @JsonFormat @RequestBody Request request) {
        String response = requestService.postEndpointB(data, request);
        return ResponseEntity.ok(response);
    }
}
