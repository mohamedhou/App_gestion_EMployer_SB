package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
// (3.a) Declare cette classe comme une entite JPA
public class Employe {

    @Id // (3.b) Definit l'attribut 'id' comme pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (3.b) Génération automatique de l'ID
    private Integer id;

    // (3.c) Attributs
    private String nom;
    private String prenom;
    private int age;
    private String ville;
    private String email;
    private String service;
    
    public Employe() {
    }
    public Employe(String nom, String prenom, int age, String ville, String email, String service) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ville = ville;
        this.email = email;
        this.service = service;
    }

    // (3.d) Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", ville='" + ville + '\'' +
                ", email='" + email + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}