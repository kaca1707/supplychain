package upm.softwaredesign.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.softwaredesign.finalproject.blockchain.BlockChain;
import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.enums.TransactionStatus;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.model.Retailer;
import upm.softwaredesign.finalproject.repository.ActorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

	private final ActorRepository repository;

	@Autowired
	public ActorService(ActorRepository repository) {
		this.repository = repository;
	}

	public Actor cast(ActorEntity actorEntity) {
		// TODO: We are loosing information about actor type here; Actor should be
		// abstract.
		// TODO: We need to have a logic to distinguish type of actor and create
		// Appropriate type
		Actor actor = new Retailer();
		actor.setName(actorEntity.getName());
		actor.setType(actorEntity.getType());
		return actor;
	}

	public Actor findByType(String type) {
		List<ActorEntity> actors = this.repository.findAll();
		for (int i = 0; i < actors.size(); i++) {
			if (actors.get(i).getType().equals(type)) {
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

	public void delete(Actor actor) {

		List<ActorEntity> actors = this.repository.findAll();
		for (ActorEntity actorEntity : actors) {
			if (actorEntity.getId() == actor.getId()) {
				this.repository.deleteById(actorEntity.getId());
			}
		}
	}

	public void update(Actor ac) {
		List<ActorEntity> actors = this.repository.findAll();
		for (ActorEntity actorEntity : actors) {
			if (actorEntity.getId() == ac.getId()) {
				actorEntity.setName(ac.getName());
				actorEntity.setType(ac.getType());
				this.repository.save(actorEntity);
			}
		}
	}

	public List<Actor> retrieveActors() {
		List<Actor> actors = new ArrayList<Actor>();
		List<ActorEntity> actorsEntityList = this.repository.findAll();		
		for(ActorEntity actorEntity : actorsEntityList) {
			actors.add(cast(actorEntity));
		}
		return actors;
	}

	public List<Actor> retrieveActorBytype(String actorType) {
		List<Actor> actors = new ArrayList<Actor>();
		List<ActorEntity> actorsEntityList = this.repository.findAll();
		for (ActorEntity actorEntity : actorsEntityList) {
			if (actorEntity.getType() == actorType) {
				actors.add(cast(actorEntity));
			}
		}
		return actors;
	}

}
