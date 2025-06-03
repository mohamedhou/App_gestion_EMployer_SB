package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployeRepository;

import java.util.List;


@Controller // (5.a) Indique que c'est un contrôleur Spring MVC


@RequestMapping("/employes") // (5.b) URL de base pour toutes les routes de ce contrôleur


public class EmployeController {

 @Autowired // (5.c) Injection de dépendance du repository
 private EmployeRepository repo;

 
 // (5.d) Lister tous les employes
 // (5.d.i) Utilise findAll() pour récupérer tous les employés
 // (5.d.ii) Ajoute la liste au modèle sous le nom "employes"
 // (5.d.iii) Retourne la vue "liste"
 @GetMapping
 public String lister(Model model) {
     model.addAttribute("employes", repo.findAll());
     return "liste"; 
 }

 // (5.e) Afficher le formulaire d'ajout d'un nouvel employé
 // (5.e.i) Crée un nouvel objet Employe vide
 // (5.e.ii) Ajoute cet objet au modèle sous le nom "employe"
 // (5.e.iii) Retourne la vue "ajouterEmploye" (ajouterEmploye.html)
 @GetMapping("/ajouter")
 public String formulaireAjout(Model model) {
     model.addAttribute("employe", new Employe());
     return "ajouterEmploye"; 
 }

 // (5.f) Sauvegarder un employé (nouveau ou modifié)
 // (5.f.i) Utilise @ModelAttribute pour lier les données du formulaire à l'objet Employe
 // (5.f.ii) Sauvegarde l'objet Employe en utilisant save()
 // (5.f.iii) Redirige vers la liste des employés
 @PostMapping("/sauver")
 public String sauvegarderEmploye(@ModelAttribute("employe") Employe employe) {
     repo.save(employe);
     return "redirect:/employes";
 }

 // (5.g) Afficher le formulaire de modification d'un employe existant
 // (5.g.i) Utilise @PathVariable pour recuperer l'ID de l'URL
 // (5.g.ii) Récupere l'employé par son ID (orElse(null) si non trouvé)
 // (5.g.iii) Ajoute l'employé au modèle
 // (5.g.iv) Retourne la vue "modifierEmploye" 
 @GetMapping("/editer/{id}")
 public String formulaireEdit(@PathVariable int id, Model 
		 model) {
		  model.addAttribute("employe", 
		 repo.findById(id).orElse(null));
		  return"modifierEmploye";
		  }

 // (5.h) Supprimer un employe
 // (5.h.i) Utilise @PathVariable pour recuperer l'ID de l'URL
 // (5.h.ii) Supprime l'employe par son ID
 // (5.h.iii) Redirige vers la liste des employes
 @GetMapping("/supprimer/{id}")
 public String supprimerEmploye(@PathVariable Integer id) {
     repo.deleteById(id);
     return "redirect:/employes";
 }
}