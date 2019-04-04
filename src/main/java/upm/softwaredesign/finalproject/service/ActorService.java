package upm.softwaredesign.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Retailer;
import upm.softwaredesign.finalproject.repository.ActorRepository;

import java.util.List;

@Service
public class ActorService{

	private final ActorRepository repository;
	
	@Autowired
	public ActorService(ActorRepository repository) {
		this.repository = repository;
	}

	public Actor cast(ActorEntity actorEntity)
	{
		// TODO: We are loosing information about actor type here; Actor should be abstract.
		//  TODO: We need to have a logic to distinguish type of actor and create aprioprate type
		Actor actor = new Retailer();
		actor.setName(actorEntity.getName());
		actor.setType(actorEntity.getType());
		return actor;
	}
	public Actor findByType(String type ) {
		List<ActorEntity> actors = this.repository.findAll();
		for (int i = 0; i < actors.size(); i++) {
			if(actors.get(i).getType().equals(type))
			{
				return this.cast(actors.get(i));
				
			}
		}
		return null;
	}

    public ActorEntity save(Actor actor) {
    	ActorEntity actorEntity = new ActorEntity();
    	actorEntity.setName(actor.getName());
    	actorEntity.setType(actor.getType());
    	return this.repository.save(actorEntity);
    }
    /*
    public void delete(Actor actor) {
    	
    	List<ActorEntity> actors = this.repository.findAll();
		for (int i = 0; i < actors.size(); i++) {
			if(actors.get(i).getType().equals(actor.getType()))
			{
				this.repository.deleteById(actors.get(i).getId());				
				
			}
		}
    }
    
    public void update(Actor ac) {
    		Optional<ActorEntity> acOpt = this.repository.findById(ac.getId());
    		if(acOpt.isPresent())
    		{
    			ActorEntity acNew = acOpt.get();
    			acNew.setName(ac.getName());
        		acNew.setType(ac.getType());
        		this.repository.save(acNew);
    		}    		
    }
    
    
    public List<Actor> getAll(){
    	//List<ActorEntity> actorsEntity = new List<ActorEntity>();
    	//List<Actor> actors = new List<ActorEntity>();
    	this.repository.findAll();
    	for (int i = 0; i < array.length; i++) {
			
		}
    	return ;
    }
	*/
}
