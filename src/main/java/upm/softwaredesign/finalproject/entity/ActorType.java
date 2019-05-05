package upm.softwaredesign.finalproject.entity;


public enum ActorType {
    RETAILER("retailer"), FACTORY("factory"), PRODUCER("producer");

    ActorType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
