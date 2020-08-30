package ru.mipinapi.resttrain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class Request {

    @Column(name = "number")
    private String number;

    @Builder
    public Request(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Request{" +
                "number='" + number + '\'' +
                '}';
    }
}
