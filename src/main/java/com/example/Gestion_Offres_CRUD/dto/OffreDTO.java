package com.example.Gestion_Offres_CRUD.dto;

import com.example.Gestion_Offres_CRUD.model.Immobilier;
import com.example.Gestion_Offres_CRUD.model.Offre;
import com.example.Gestion_Offres_CRUD.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
public class OffreDTO {
    private long id;
    private LocalDate dateDePublication;
    private ImmobilierDTO immobilier;
    private UserDTO user;

}
