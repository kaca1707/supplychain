package upm.softwaredesign.finalproject.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Retailer;
import upm.softwaredesign.finalproject.repository.ActorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorServiceTests {

    @Autowired
    private ActorRepository repository;

    @Test
    public void testCast() {
        ActorService service = new ActorService(this.repository);
        ActorEntity entity = new ActorEntity();
        entity.setId(1001);
        entity.setName("foo");
        Actor actor = service.cast(entity);
        assertEquals(actor.getId(), entity.getId());
        assertEquals(actor.getName(), entity.getName());
    }

    @Test
    public void testSave() {
        ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        ActorEntity entity = service.save(retailer);
        assertEquals(retailer.getName(), entity.getName());
        assertEquals(retailer.getType(), entity.getType());
    }

    @Test
    public void testDelete() {
        ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        ActorEntity entity = service.save(retailer);
        int entityId = entity.getId();
        retailer.setId(entityId);
        service.delete(retailer);
        List<Actor> actors = service.retrieveActors();
        for (Actor actor : actors) {
            if (actor.getId() == entityId) {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }

    @Test
    public void testUpdate() {
        ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        ActorEntity entity = service.save(retailer);
        int entityId = entity.getId();
        retailer.setId(entityId);
        retailer.setName("bar");
        service.update(retailer);
        List<Actor> actors = service.retrieveActors();
        for (Actor actor : actors) {
            if (actor.getId() == entityId) {
                assertEquals(actor.getName(), "bar");
                return;
            }
        }
        assertTrue(false);
    }

    @Test
    public void testRetrieveActors() {
        ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        ActorEntity entity = service.save(retailer);
        int entityId = entity.getId();
        retailer.setId(entityId);
        List<Actor> actors = service.retrieveActors();
        for (Actor actor : actors) {
            if (actor.getId() == entityId) {
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    @Test
    public void testRetrieveActorByType() {
        ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        service.save(retailer);
        List<Actor> actors = service.retrieveActorByType("retailer");
        assertTrue(!actors.isEmpty());
    }
    
    @Test
    public void testRetrieveActorById() {
    	ActorService service = new ActorService(this.repository);
        Retailer retailer = new Retailer();
        retailer.setName("foo");
        retailer.setType("retailer");
        ActorEntity entity = service.save(retailer);
        Actor actor = service.retrieveActorById(entity.getId());
        assertNotNull(actor);
    }

    
}