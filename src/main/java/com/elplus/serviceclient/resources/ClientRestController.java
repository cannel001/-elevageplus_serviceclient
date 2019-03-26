/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.serviceclient.resources;

import com.elplus.serviceclient.domaine.Client;
import com.elplus.serviceclient.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cannel
 */
@RestController
@RequestMapping(value = "/api/clients")
public class ClientRestController {
    
    //les proprietes
    @Autowired
    private ClientRepository clientRepository;
    
    @GetMapping(value = "")
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity getOne(@PathVariable long id){
        if(id>0){
            Optional<Client> client=clientRepository.findById(id);
            if(client.orElse(null)!=null){
                return ok(client.get());
            }else{
                ok("Ce client n'existe pas");
            }
        }else{
            ok("Veuillez entrer un id superieur à zero");
        }
        return ok("Erreur survenue pendant le traitement");
    }
    
}
