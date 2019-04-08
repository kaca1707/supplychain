package upm.softwaredesign.finalproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import upm.softwaredesign.finalproject.service.ActorService;
import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinalProjectApplicationTests {

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void actorServicesTest() {
    	assertEquals(new ActorEntity (), new ActorService(null).save(new Retailer()));
    	assertEquals(new ActorEntity (), new ActorService(null).save(new Producer()));
    	assertEquals(new ActorEntity (), new ActorService(null).save(new Factory()));    	
    }

}
