package com.example.Gestion_Offres_CRUD.dto;

import com.example.Gestion_Offres_CRUD.model.Immobilier;
import com.example.Gestion_Offres_CRUD.model.Offre;
import com.example.Gestion_Offres_CRUD.model.User;

public class DTOConverter {
    public static OffreDTO toOffreDTO(Offre offre) {
        OffreDTO dto = new OffreDTO();
        dto.setId(offre.getId());
        dto.setDateDePublication(offre.getDateDePublication());
        dto.setImmobilier(toImmobilierDTO(offre.getImmobilier()));
        dto.setUser(toUserDTO(offre.getUser()));
        return dto;
    }
    public static Offre toOffreEntity(OffreDTO dto) {
        Offre offre = new Offre();
        offre.setDateDePublication(dto.getDateDePublication());
        offre.setImmobilier(toImmobilierEntity(dto.getImmobilier()));
        return offre;
    }
    public static ImmobilierDTO toImmobilierDTO(Immobilier immobilier) {
        ImmobilierDTO dto = new ImmobilierDTO();
        dto.setId(immobilier.getId());
        dto.setTitle(immobilier.getTitle());
        dto.setImg(immobilier.getImg());
        dto.setBedroom(immobilier.getBedroom());
        dto.setBathroom(immobilier.getBathroom());
        dto.setPrice(immobilier.getPrice());
        dto.setAddress(immobilier.getAddress());
        dto.setLatitude(immobilier.getLatitude());
        dto.setLongitude(immobilier.getLongitude());
        return dto;
    }
    public static Immobilier toImmobilierEntity(ImmobilierDTO dto) {
        Immobilier immobilier = new Immobilier();
        immobilier.setTitle(dto.getTitle());
        immobilier.setImg(dto.getImg());
        immobilier.setBedroom(dto.getBedroom());
        immobilier.setBathroom(dto.getBathroom());
        immobilier.setPrice(dto.getPrice());
        immobilier.setAddress(dto.getAddress());
        immobilier.setLatitude(dto.getLatitude());
        immobilier.setLongitude(dto.getLongitude());
        return immobilier;
    }
    public static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }
    public static User toUserEntity(UserDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }



}
