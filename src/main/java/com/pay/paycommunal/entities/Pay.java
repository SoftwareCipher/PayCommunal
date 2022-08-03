package com.pay.paycommunal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_pattern")
    private Long pattern;
    @Column(name = "cart_number")
    private Long cartNumber;
    @Column(name = "suma")
    private Long sum;
    @Column(name = "status")
    private String status;
    @Column(name = "date_creation")
    private LocalDateTime  createTime;
    @Column(name = "date_change")
    private LocalDateTime changeTime;
}
