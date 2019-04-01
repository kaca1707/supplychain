package upm.softwaredesign.finalproject.model;


import upm.softwaredesign.finalproject.enums.TransactionStatus;

public abstract class Actor {

    private Integer id;
    private String name;
    private String type;
    private Actor previousInChain;
    private Actor nextInChain;

    private String checkOrderStatus() {
        throw new RuntimeException("todo");
    }

    public abstract boolean processRequest(Product product, TransactionStatus status);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Actor getPreviousInChain() {
        return previousInChain;
    }

    public void setPreviousInChain(Actor previousInChain) {
        this.previousInChain = previousInChain;
    }

    public Actor getNextInChain() {
        return nextInChain;
    }

    public void setNextInChain(Actor nextInChain) {
        this.nextInChain = nextInChain;
    }


}
