package com.example.sample23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Sample23Application implements CommandLineRunner {

    @Autowired
    private TicketGenerator ticketGenerator;

    @Autowired
    private TicketRepository ticketRepository;

    public static void main(String[] args) {

        SpringApplication.run(Sample23Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        for(int i = 0; i < 5; i ++){
            String code = ticketGenerator.generateTicket();
            System.out.println(code);
        }
    }

    private void GenerateTickets() {
        System.out.println("Initiated....");
        List<String> codes = new ArrayList<>();
        for(int i = 0; i < 1000; i ++){
            codes.add(ticketGenerator.generateTicket());
        }

        List<Ticket> tickets = IntStream.range(0, 1000)
                .mapToObj(x -> {
                    Ticket ticket = new Ticket();
                    ticket.setCode(ticketGenerator.generateTicket());
                    return ticket;
                }).collect(Collectors.toList());

        System.out.println("Ticket generated...");
        ticketRepository.saveAll(tickets);
        System.out.println("Finished...");
    }
}
