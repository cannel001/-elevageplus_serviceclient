/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.serviceclient.domaine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cannel
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message = "Veuillez entrer un nom s'il vous plait")
    private String nom;
    
    private String adrPostal;
    
    @NotEmpty(message = "Veuillez entrer un numero de telephone s'il vous plait")
    private String numTel;
    
    @NotEmpty(message = "Veuillez entrer une description s'il vous plait")
    private String descript;
    
    @NotEmpty(message = "Veuillez entrer le lien de votre image s'il vous plait")
    private String lienImage;
    
    @NotEmpty(message = "Veuillez entrer votre pays s'il vous plait")
    private String pays;
    
    @NotEmpty(message = "Veuillez entrer votre ville s'il vous plait")
    private String ville;
    
    @NotEmpty(message = "Veuillez entrer votre latitude s'il vous plait")
    private String latitude;
    
    @NotEmpty(message = "Veuillez entrer votre longitude s'il vous plait")
    private String longitude;

    //constructeur sans id
    public Client(String nom, String adrPostal, String numTel, String descript, String lienImage, String pays, String ville, String latitude, String longitude) {
        this.nom = nom;
        this.adrPostal = adrPostal;
        this.numTel = numTel;
        this.descript = descript;
        this.lienImage = lienImage;
        this.pays = pays;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    
   
}
