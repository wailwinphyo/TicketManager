package com.example.sample23;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;


public class TicketGeneratorImpl1 implements TicketGenerator{


    String[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    String[] NUMBERS = "0123456789".split("");

    public String generateTicket(){
        Optional<String> numbers = Arrays.asList(new String[5]).stream()
                .map(x -> NUMBERS[Double.valueOf(Math.random() * NUMBERS.length).intValue()])
                .reduce((a, b) -> a + b);

        Optional<String> alphabets = Arrays.asList(new String[6]).stream()
                .map(x -> ALPHABET[Double.valueOf(Math.random() * ALPHABET.length).intValue()])
                .reduce((a, b) -> a + b);
        return numbers.orElse("").concat(alphabets.get());
    }
}
