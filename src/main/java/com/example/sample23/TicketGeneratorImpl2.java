package com.example.sample23;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class TicketGeneratorImpl2 implements TicketGenerator{


    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";

    private final SecureRandom secureRandom = new SecureRandom();

    public synchronized String generateTicket() {
        StringBuilder ticket = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            ticket.append(NUMBERS.charAt(secureRandom.nextInt(NUMBERS.length())));
        }
        for (int i = 0; i < 6; i++) {
            ticket.append(ALPHABET.charAt(secureRandom.nextInt(ALPHABET.length())));
        }

        String[] characters = ticket.toString().split("");
        List<String> myList = Arrays.asList(characters);
        Collections.shuffle(myList, secureRandom);

        return Arrays.toString(myList.toArray());
    }
}
