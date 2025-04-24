package com.tp3bda.tp3bda;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
public class MyApi {
    public static ArrayList<Etudiant> listeEtu = new ArrayList<>();

    static{
        listeEtu.add(new Etudiant(1,"Test1",12));
        listeEtu.add(new Etudiant(2,"Test2",12));
        listeEtu.add(new Etudiant(3,"Test3",12));
        listeEtu.add(new Etudiant(4,"Test4",12));

    }
    @GetMapping("/bonjour")
    public String bonjour()
    {
        return "Bonjour";
    }

    @GetMapping("/bonsoir")
    public String bonsoir()
    {
        return "Bonsoir";
    }

    @GetMapping("/etudiant")
    public Etudiant getEtudiant() {
        return new Etudiant(1,"Test",15.0);
    }
    
    @GetMapping("/somme")
    public double somme(double a,double b)
    {
        return a+b;
    }

    @GetMapping("/etudiants")
    public Collection<Etudiant> getAllEtudiants() {
        return listeEtu;
    }
    @GetMapping("/getEtudiant")
    public Etudiant getEtudiant(int id) {
        for(Etudiant e :  listeEtu)
        {
            if(e.getId() == id)
            {
                return e;
            }
        }
        return null;
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(Etudiant etu) {
        listeEtu.add(etu);
        return etu;
    }

    @DeleteMapping("/suppEtudiant")
    public void suppEtudiant(int id) {
        Iterator<Etudiant> i = listeEtu.iterator();

        while(i.hasNext()) {
            Etudiant e = i.next();
            if (e.getId() == id) {
                i.remove();
            }
        }
    }
    
    @PutMapping("/modifEtudiant")
    public void modifEtudiant(int id,String nom)
    {
        Etudiant e = this.getEtudiant(id);
        if (e != null)
            this.getEtudiant(id).setNom(nom);

    }

    
}

