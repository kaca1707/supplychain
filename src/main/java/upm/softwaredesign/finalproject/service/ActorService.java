package upm.softwaredesign.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.softwaredesign.finalproject.model.ActorEntity;
import upm.softwaredesign.finalproject.repository.ActorRepository;

@Service
public class ActorService{

	private final ActorRepository repository;
	
	@Autowired
	public ActorService(ActorRepository repository) {
		this.repository = repository;
	}


	public Optional<ActorEntity> findById(Integer id ) {
		return this.repository.findById(id);
	}

    public void save(ActorEntity actor) {
    		this.repository.save(actor);
    }
    
    public void delete(Integer id) {
    		this.repository.deleteById(id);
    }
    
    public void update(ActorEntity ac) {
    		Optional<ActorEntity> acOpt = this.repository.findById(ac.getId());
    		if(acOpt.isPresent())
    		{
    			ActorEntity acNew = acOpt.get();
    			acNew.setName(ac.getName());
        		acNew.setType(ac.getType());
        		this.repository.save(acNew);
    		}    		
    }
    
    public List<ActorEntity> getAll(){
    		return this.repository.findAll();
    }
	
	

}
