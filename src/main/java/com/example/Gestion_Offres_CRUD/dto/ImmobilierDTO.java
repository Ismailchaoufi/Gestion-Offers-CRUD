package com.example.Gestion_Offres_CRUD.dto;

import com.example.Gestion_Offres_CRUD.model.Immobilier;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ImmobilierDTO {
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
