package com.example.Gestion_Offres_CRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "immobiliers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Immobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String img;
    private int bedroom;
    private int bathroom;
    private double price;
    private String address;
    private double latitude;
    private double longitude;

}
