package upm.softwaredesign.finalproject.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import upm.softwaredesign.finalproject.blockchain.BlockChain;
import upm.softwaredesign.finalproject.entity.BlockchainEntity;
import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.model.Retailer;
import upm.softwaredesign.finalproject.order.Order;
import upm.softwaredesign.finalproject.repository.BlockchainRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockchainServiceTests {

    @Autowired
    private BlockchainRepository repository;

    @Test
    public void testSaveBlockchain() {
        try {
            BlockchainService service = new BlockchainService(this.repository);
            BlockChain blockchain = new BlockChain(service);
            Retailer retailer = new Retailer();
            retailer.setName("foo");
            retailer.setType("retailer");
            Product product = new Product();
            Date time = new Date();
            Order order = new Order(retailer, product, time);
            blockchain.addOrder(order);
            BlockchainEntity entity = service.saveBlockchain(blockchain);
            String blockchainJson = blockchain.toJSON();
            String entityJson = entity.getContent();
            assertTrue(blockchainJson.equals(entityJson));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRetrieveBlockchain() {
        try {
            BlockchainService service = new BlockchainService(this.repository);
            BlockChain blockchain = new BlockChain(service);
            Retailer retailer = new Retailer();
            retailer.setName("foo");
            retailer.setType("retailer");
            Product product = new Product();
            Date time = new Date();
            Order order = new Order(retailer, product, time);
            blockchain.addOrder(order);
            service.saveBlockchain(blockchain);
            BlockChain blockchain2 = service.retrieveBlockchain();
            String blockchainJson = blockchain.toJSON();
            String blockchain2Json = blockchain2.toJSON();
            assertTrue(blockchainJson.equals(blockchain2Json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}