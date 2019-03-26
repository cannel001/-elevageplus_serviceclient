/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.serviceclient.repositories;

import com.elplus.serviceclient.domaine.Client;
import com.elplus.serviceclient.domaine.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cannel
 */
public interface NoteRepository extends JpaRepository<Note, Long>{
    
    public List<Note> findByClient(Client client);
    
}
