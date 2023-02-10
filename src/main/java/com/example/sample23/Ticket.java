package com.example.sample23;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;


    @Column(unique = true)
    private String code;


    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    @UpdateTimestamp
    private Instant testColumn;

    public Ticket(String code){
        this.code = code;
    }

    public Ticket() {

    }
}
