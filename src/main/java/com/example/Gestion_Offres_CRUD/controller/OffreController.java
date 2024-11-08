package com.example.Gestion_Offres_CRUD.controller;

import com.example.Gestion_Offres_CRUD.dto.OffreDTO;
import com.example.Gestion_Offres_CRUD.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OffreController {
    private final OffreService offreService;

    // Créer une offre avec un immobilier
    @PostMapping("/user/{userId}")
    public ResponseEntity<OffreDTO> createOfferWithImmobilier(@RequestBody OffreDTO offreDTO,
                                                              @PathVariable Long userId) {
        if (offreDTO == null || offreDTO.getImmobilier() == null) {
            throw new RuntimeException("Offre or Immobilier data is missing in the request body");
        }

        OffreDTO createdOffer = offreService.createOfferWithImmobilier(offreDTO, userId);
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }
    @PutMapping("/{offreId}/user/{userId}")
    public ResponseEntity<OffreDTO> updateOfferWithImmobilier(@PathVariable Long offreId,
                                                           @RequestBody OffreDTO updatedOffre,
                                                           @PathVariable Long userId) {
        try {
            OffreDTO updatedOffer = offreService.updateOfferWithImmobilier(offreId, updatedOffre, userId);
            return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);  // 403 Unauthorized
        }
    }
    @DeleteMapping("/{offreId}")
    public ResponseEntity<String> deleteOfferWithImmobilier(@PathVariable Long offreId) {
        try {
            offreService.deleteOfferWithImmobilier(offreId);
            return new ResponseEntity<>("Offer and its associated immobilier deleted successfully", HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);  // 404 Offer not found
        }
    }
    // Récupérer une offre avec son immobilier
    @GetMapping("/{offerId}")
    public ResponseEntity<OffreDTO> getOfferWithImmobilier(@PathVariable Long offerId) {
        try {
            OffreDTO offer = offreService.getOfferWithImmobilier(offerId);
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // 404 Not Found
        }
    }
    // Récupérer toutes les offres
    @GetMapping
    public ResponseEntity<List<OffreDTO>> getAllOffers() {
        List<OffreDTO> offers = offreService.getAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}
