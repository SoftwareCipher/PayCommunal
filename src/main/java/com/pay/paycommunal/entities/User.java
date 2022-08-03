package com.pay.paycommunal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "person")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Long phone;
}
