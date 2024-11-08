package com.example.Gestion_Offres_CRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "offres")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //offer sur un immobilier
    @ManyToOne
    @JoinColumn(name = "immobilier_id", nullable = false)
    private Immobilier immobilier;
    //offer pour un user

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private LocalDate dateDePublication;
}
