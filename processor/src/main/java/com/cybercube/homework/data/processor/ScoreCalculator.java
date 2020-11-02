package com.cybercube.homework.data.processor;

import org.springframework.stereotype.Component;

@Component
public class ScoreCalculator {

    public double calculateScore(double seed, int age) {
        return seed * age;
    }
}