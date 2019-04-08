package upm.softwaredesign.finalproject.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.entity.BlockchainEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockchainRepositoryTests {

    @Autowired
    private BlockchainRepository repository;

    @Test
    public void testSave() {
        BlockchainEntity entity = new BlockchainEntity();
        entity.setContent("foo");
        entity = this.repository.save(entity);
        assertEquals(entity.getContent(), "foo");
    }

    @Test
    public void testFindAll() {
        BlockchainEntity entity = new BlockchainEntity();
        entity.setContent("foo");
        entity = this.repository.save(entity);
        List<BlockchainEntity> entities = this.repository.findAll();
        assertTrue(!entities.isEmpty());
    }

}