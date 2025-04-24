package tp3bdap2.tp3bdap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp3bdap2.tp3bdap2.entities.Adherent;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {
    
}
