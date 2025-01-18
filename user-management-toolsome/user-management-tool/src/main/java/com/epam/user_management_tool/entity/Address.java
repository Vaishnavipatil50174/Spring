package com.epam.user_management_tool.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="addressName")
    private String addressName;

    @Column(name = "addressType")
    private String addressType;

    @Column(name="addressCity")
    private String addressCity;

    public Address(int i, String satara, String work, String satara1) {
    }
}
