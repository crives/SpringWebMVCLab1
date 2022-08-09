package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Signup")
public class Signup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 0, max = 23)
    private int time;
    private Date created_at;
    private Date updated_at;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Camper camper;
}
