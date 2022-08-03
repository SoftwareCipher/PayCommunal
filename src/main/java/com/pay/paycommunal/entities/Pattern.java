package com.pay.paycommunal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pattern")
public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_pattern")
    private String namePattern;
    @Column(name = "iban")
    private int Iban;
    @Column(name = "goal")
    private String goal;
    @Column(name = "phone")
    private Long phone;
}
