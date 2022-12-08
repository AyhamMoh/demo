package edu.fbanspet.demo.controller;

import edu.fbanspet.demo.dao.UtilisateurDao;
import edu.fbanspet.demo.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable int id){

        return utilisateurDao.findById(id).orElse(null);
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs(){

        Date date = new Date();

        return utilisateurDao.findAll();
    }

    @PostMapping("/utilisateur")
    public boolean ajoutUtilisateur(@RequestBody Utilisateur utilisateur){
       utilisateurDao.save(utilisateur);

        return true;

     }

    @DeleteMapping("/utilisateur/{id}")
    public boolean supprimeUtilisateur(@PathVariable int id){
        utilisateurDao.deleteById(id);

        return true;
    }
}
