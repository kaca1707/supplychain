package upm.softwaredesign.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import upm.softwaredesign.finalproject.model.Actor;

import java.util.Optional;

@Repository
public interface BlockchainEntity extends JpaRepository<Actor, Integer> {
    Optional<Actor> findByName(String name);

    Optional<Actor> findByType(String type);

}



