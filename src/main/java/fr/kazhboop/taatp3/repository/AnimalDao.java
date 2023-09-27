package fr.kazhboop.taatp3.repository;

import fr.kazhboop.taatp3.domain.animals.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long> {

    Animal findByName(String name);

}
