package upm.softwaredesign.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.entity.ActorType;
import upm.softwaredesign.finalproject.model.Actor;
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

	public Actor cast(ActorEntity entity) {
		// TODO: We are loosing information about actor type here; Actor should be
		// abstract.
		// TODO: We need to have a logic to distinguish type of actor and create
		// Appropriate type
		Actor actor = new Retailer();
		actor.setId(entity.getId());
		actor.setName(entity.getName());
		actor.setType(entity.getType());
		return actor;
	}

	public ActorEntity save(Actor actor) {
		ActorEntity entity = new ActorEntity();
		entity.setName(actor.getName());
		entity.setType(actor.getType());
		return this.repository.save(entity);
	}

	public void delete(Actor actor) {
		List<ActorEntity> entities = this.repository.findAll();
		for (ActorEntity entity : entities) {
            if (entity.getId().equals(actor.getId())) {
				this.repository.deleteById(entity.getId());
				break;
			}
		}
	}

	public void update(Actor actor) {
		List<ActorEntity> entities = this.repository.findAll();
		for (ActorEntity entity : entities) {
            if (entity.getId().equals(actor.getId())) {
				entity.setName(actor.getName());
				entity.setType(actor.getType());
				this.repository.save(entity);
				break;
			}
		}
	}

	public List<Actor> retrieveActors() {
		List<Actor> actors = new ArrayList<Actor>();
		List<ActorEntity> entities = this.repository.findAll();
		for (ActorEntity entity : entities) {
			actors.add(this.cast(entity));
		}
		return actors;
	}

    public List<Actor> retrieveActorByType(ActorType actorType) {
		List<Actor> actors = new ArrayList<Actor>();
		List<ActorEntity> entities = this.repository.findAll();
		for (ActorEntity entity : entities) {
            if (entity.getType() == actorType) {
				actors.add(this.cast(entity));
			}
		}
		return actors;
	}

	public Actor retrieveActorById(int actorId) {
		Actor actor = null;
		List<ActorEntity> entities = this.repository.findAll();
		for (ActorEntity entity : entities) {
			if (entity.getId().equals(actorId)) {
				actor = this.cast(entity);
			}
		}
		return actor;
	}

}
