package upm.softwaredesign.finalproject.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    private ActorType type; // todo: ActorTypeEnum

    // private Actor nextInChain;

    private String checkOrderStatus() {
        throw new RuntimeException("todo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // TODO: check this
    public ActorType getType() {
        return type;
    }

    public void setType(ActorType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}