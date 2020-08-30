package ru.mipinapi.resttrain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class Request {

    @Column(name = "number")
    private Integer number;
}
