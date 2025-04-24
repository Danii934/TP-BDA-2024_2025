package com.tp3bda.tp3bda;

public class Etudiant {
    private int id ;
    private String nom;
    private double moyenne;

    public Etudiant()
    {

    }

    public Etudiant(int id, String nom, double moyenne)
    {
        this.id = id;
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public int getId() {
        return id;
    }
    public double getMoyenne() {
        return moyenne;
    }
    public String getNom() {
        return nom;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String toString()
    {
        return "nom : "+nom+" id : "+id+" moyenne : "+moyenne;
    }
}
