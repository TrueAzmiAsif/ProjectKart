package com.example.ProjectKart.Model;

import com.example.ProjectKart.Enum.Status;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Builder
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String orderNumber;
    @CreationTimestamp
    Date orderDate;
    int quantity;
    String cardUsed;
    int total;
    @ManyToOne
    @JoinColumn
    Customer customer;
    @OneToMany(mappedBy = "ordered",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
