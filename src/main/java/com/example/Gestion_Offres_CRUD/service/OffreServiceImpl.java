package com.example.Gestion_Offres_CRUD.service;

import com.example.Gestion_Offres_CRUD.dto.DTOConverter;
import com.example.Gestion_Offres_CRUD.dto.ImmobilierDTO;
import com.example.Gestion_Offres_CRUD.dto.OffreDTO;
import com.example.Gestion_Offres_CRUD.model.Immobilier;
import com.example.Gestion_Offres_CRUD.model.Offre;
import com.example.Gestion_Offres_CRUD.model.User;
import com.example.Gestion_Offres_CRUD.repository.ImmobilierRepository;
import com.example.Gestion_Offres_CRUD.repository.OffreRepository;
import com.example.Gestion_Offres_CRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OffreServiceImpl implements OffreService{
    private final OffreRepository offreRepository;
    private final ImmobilierRepository immobilierRepository;
    private final UserRepository userRepository;


    @Override
    public OffreDTO createOfferWithImmobilier(OffreDTO offreDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        // Créer et sauvegarder l'immobilier

        Offre offre = DTOConverter.toOffreEntity(offreDTO);
        offre.setUser(user);
        Immobilier immobilier = DTOConverter.toImmobilierEntity(offreDTO.getImmobilier());
        Immobilier savedImmobilier = immobilierRepository.save(immobilier);
        // Associer l'immobilier créé à l'offre
        offre.setImmobilier(savedImmobilier);
        Offre savedOffre = offreRepository.save(offre);


        // Sauvegarder l'offre avec l'immobilier et l'utilisateur associés
        return DTOConverter.toOffreDTO(savedOffre);
    }

    @Override
    public OffreDTO updateOfferWithImmobilier(Long offreId, OffreDTO updatedOffre, Long userId) {
        // Récupérer l'offre existante
        Offre existingOffre = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + offreId));
        // Vérifier si l'utilisateur est le propriétaire de l'offre
        if (!existingOffre.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to update this offer.");
        }
        // Mise à jour des informations de l'offre
        existingOffre.setDateDePublication(updatedOffre.getDateDePublication());

        // Remplacer l'objet immobilier de l'offre existante par le nouvel immobilier
        Immobilier updatedImmobilier = DTOConverter.toImmobilierEntity(updatedOffre.getImmobilier());
        if (updatedImmobilier != null) {
            updatedImmobilier.setId(existingOffre.getImmobilier().getId()); // Conserver l'ID d'origine
            immobilierRepository.save(updatedImmobilier); // Sauvegarder l'immobilier mis à jour
            existingOffre.setImmobilier(updatedImmobilier); // Associer l'immobilier mis à jour
        }

        // Sauvegarder l'offre mise à jour
        Offre savedOffre = offreRepository.save(existingOffre);
        return DTOConverter.toOffreDTO(savedOffre);
    }

    @Override
    public void deleteOfferWithImmobilier(Long offreId) {
        Offre offer = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + offreId));

        Immobilier immobilier = offer.getImmobilier();
        offreRepository.delete(offer);

        if (immobilier != null) {
            immobilierRepository.delete(immobilier);
        }


    }

    @Override
    public OffreDTO getOfferWithImmobilier(Long offerId) {
        Offre offre = offreRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + offerId));

        return DTOConverter.toOffreDTO(offre);
    }

    @Override
    public List<OffreDTO> getAllOffers() {
        List<Offre> offreList = offreRepository.findAll();

        return offreList.stream().map(DTOConverter::toOffreDTO)
                .collect(Collectors.toList());
    }

}
