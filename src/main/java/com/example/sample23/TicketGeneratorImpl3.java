package com.example.sample23;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketGeneratorImpl3 {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";

    private static final String CHARACTERS = NUMBERS + ALPHABET;
    private final SecureRandom secureRandom = new SecureRandom();

    public synchronized String generateTicket() {
        char[] ticket = new char[11];
        Arrays.fill(ticket, 0, 5, CHARACTERS.charAt(secureRandom.nextInt(NUMBERS.length())));
        Arrays.fill(ticket, 5, 11, CHARACTERS.charAt(secureRandom.nextInt(ALPHABET.length())));
        List myList = Collections.singletonList(ticket);
        Collections.shuffle(myList, secureRandom);

        return Arrays.toString(myList.toArray());
    }
}
