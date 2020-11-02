package com.cybercube.homework.data.processor.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class PersonDataDto {
    private UUID uid;
    private String firstName;
    private String lastName;
    private int age;
    private double seed;
}