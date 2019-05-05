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
import upm.softwaredesign.finalproject.entity.ActorType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorRepositoryTests {

    @Autowired
    private ActorRepository repository;

    @Test
    public void testSave() {
        ActorEntity entity = new ActorEntity();
        entity.setName("foo");
        entity.setType(ActorType.RETAILER);
        entity = this.repository.save(entity);
        assertTrue(entity.getId() > 0);
        assertEquals(entity.getName(), "foo");
    }

    @Test
    public void testFindAll() {
        ActorEntity entity = new ActorEntity();
        entity.setName("foo");
        entity.setType(ActorType.RETAILER);
        entity = this.repository.save(entity);
        List<ActorEntity> entities = this.repository.findAll();
        assertTrue(!entities.isEmpty());
    }

}