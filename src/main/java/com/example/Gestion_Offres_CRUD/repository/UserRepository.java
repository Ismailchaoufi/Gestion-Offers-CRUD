package com.example.Gestion_Offres_CRUD.repository;

import com.example.Gestion_Offres_CRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
