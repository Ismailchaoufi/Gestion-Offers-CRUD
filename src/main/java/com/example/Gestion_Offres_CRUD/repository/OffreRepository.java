package com.example.Gestion_Offres_CRUD.repository;

import com.example.Gestion_Offres_CRUD.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre, Long> {

}