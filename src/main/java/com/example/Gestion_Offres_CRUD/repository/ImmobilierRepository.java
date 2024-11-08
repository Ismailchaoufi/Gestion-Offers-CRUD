package com.example.Gestion_Offres_CRUD.repository;

import com.example.Gestion_Offres_CRUD.model.Immobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmobilierRepository extends JpaRepository<Immobilier, Long> {

}
