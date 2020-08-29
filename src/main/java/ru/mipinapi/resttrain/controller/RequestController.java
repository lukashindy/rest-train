package ru.mipinapi.resttrain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mipinapi.resttrain.service.RequestService;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    /**
     *
     * @param data
     * @return
     */
    @GetMapping("/{data}")
    public ResponseEntity<String> getEndpointA(@RequestBody @PathVariable String data) {
        String response = requestService.getEndpointA(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     *
     * @param number
     * @return number - Check with Postman API: http://127.0.0.1:8080/api/4234234 as example
     */
    @PostMapping("/{number}")
    public ResponseEntity<Integer> postEndpointB(@RequestBody @PathVariable Integer number) {
        return ResponseEntity.ok(number);
    }
}
