package upm.softwaredesign.finalproject.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upm.softwaredesign.finalproject.model.ActorEntity;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
 

}
