package tp3bdap2.tp3bdap2.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String ville;
    private int age;

    public Adherent()
    {

    }

    public Adherent(Long id,String nom, String ville, int age)
    {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.ville = ville;
    }
    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
}
