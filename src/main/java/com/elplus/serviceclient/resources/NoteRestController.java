/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.serviceclient.resources;

import com.elplus.serviceclient.domaine.Client;
import com.elplus.serviceclient.domaine.Note;
import com.elplus.serviceclient.repositories.ClientRepository;
import com.elplus.serviceclient.repositories.NoteRepository;
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
@RequestMapping(value = "/api/notes")
public class NoteRestController {

    //les proprietes
    @Autowired
    private NoteRepository noteRepository;

    private double note;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "")
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOne(@PathVariable long id) {
        if (id > 0) {
            Optional<Note> note = noteRepository.findById(id);
            if (note.orElse(null) != null) {
                return ok(note.get());
            } else {
                ok("Cette note n'existe pas");
            }
        } else {
            ok("Veuillez entrer un id superieur à zero s'il vous plait");
        }
        return ok("Erreur survenue pendant le traitement");
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity getOneByIdClient(@PathVariable long id) {

        List<Note> notes = null;
        note=0;
        if (id > 0) {
            Optional<Client> client = clientRepository.findById(id);
            if (client.orElse(null) != null) {
                notes = noteRepository.findByClient(client.get());
                if (notes != null) {
                    notes.forEach(v -> note += v.getMyNote());
                    note=note/notes.size();
                    Note n = new Note(note, client.get());
                    return ok(n);
                }
            } else {
                ok("Ce client n'existe pas");
            }
        }
        return ok("Erreur survenue pendant le traitement");
    }

}
