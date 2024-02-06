package com.gestionUser.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class formateur {
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column( nullable = false)
    private String prennom;
    private int age;
    @Column(length = 128, nullable = false, unique = true)
    private String email;
    @Column(length = 64 , nullable = false)
    private String password;
    @Column(length = 64 , nullable = false)
    private String specialité;
    private double salaire;
    @Column(length = 20 , nullable = false)
    private String telephone;
	
    

}