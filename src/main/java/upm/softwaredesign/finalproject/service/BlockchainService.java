package upm.softwaredesign.finalproject.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.softwaredesign.finalproject.model.BlockchainEntity;
import upm.softwaredesign.finalproject.repository.BlockchainRepository;

@Service
public class BlockchainService {

    private final BlockchainRepository repository;

    @Autowired
    public BlockchainService(BlockchainRepository repository) {
        this.repository = repository;
    }

    public void saveBlockhain(BlockchainEntity entity) throws IOException {
        BlockchainEntity blockchain = this.retrieveBlockchain();
        List<BlockchainEntity> blockchains = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (!blockchain.getContent().isEmpty()) {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType valueType = typeFactory.constructCollectionType(List.class, BlockchainEntity.class);
            blockchains = objectMapper.readValue(blockchain.getContent(), valueType);
        }
        blockchains.add(entity);
        String blockchainContent = objectMapper.writeValueAsString(blockchains);
        blockchain.setContent(blockchainContent);
        this.repository.save(blockchain);
    }

    public BlockchainEntity retrieveBlockchain() {
        List<BlockchainEntity> blockchains = this.repository.findAll();
        if (blockchains.isEmpty()) {
            return new BlockchainEntity();
        }
        return blockchains.get(0);
    }

}