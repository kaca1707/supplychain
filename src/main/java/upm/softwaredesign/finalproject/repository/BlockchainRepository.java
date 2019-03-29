package upm.softwaredesign.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upm.softwaredesign.finalproject.model.BlockchainEntity;

@Repository
public interface BlockchainRepository extends JpaRepository<BlockchainEntity, Integer> {
}
