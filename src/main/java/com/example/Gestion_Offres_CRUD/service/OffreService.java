package com.example.Gestion_Offres_CRUD.service;

import com.example.Gestion_Offres_CRUD.dto.ImmobilierDTO;
import com.example.Gestion_Offres_CRUD.dto.OffreDTO;
import com.example.Gestion_Offres_CRUD.model.Immobilier;
import com.example.Gestion_Offres_CRUD.model.Offre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OffreService {
    OffreDTO createOfferWithImmobilier(OffreDTO offreDTO, Long userId);
    OffreDTO updateOfferWithImmobilier(Long offerId, OffreDTO updatedOffer, Long userId);
    void deleteOfferWithImmobilier(Long offerId);
    OffreDTO getOfferWithImmobilier(Long offerId);
    List<OffreDTO> getAllOffers();
}
