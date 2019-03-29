package upm.softwaredesign.finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upm.softwaredesign.finalproject.model.Actor;

@Repository
public interface BlockchainRepository extends JpaRepository<Actor, Integer> {

    Optional<Actor> findByName(String name);

    Optional<Actor> findByType(String type);

}
