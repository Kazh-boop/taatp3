package fr.kazhboop.taatp3.repository.persons;

import fr.kazhboop.taatp3.domain.persons.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Long> {
        Owner findByName(String name);
}
