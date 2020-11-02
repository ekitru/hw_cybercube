package com.cybercube.homework.data.collector.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class PersonDataDto {
    public UUID uid;
    public String firstName;
    public String lastName;
    public int age;
    public double seed;
}