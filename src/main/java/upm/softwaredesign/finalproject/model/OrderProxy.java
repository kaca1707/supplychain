package upm.softwaredesign.finalproject.model;

import java.util.Set;
import java.util.UUID;

public class OrderProxy {

    /*
    @param blockChinId
    @return set of orders that are in a blockchain
     */
    public Set<Order> consultChain(UUID blockChinId){
        //TODO
        return null;
    }

    /* Saves an order in a blockchain
    @param blockChainId
    @param order: Request/Delivery that has to be added to a blockchain
     */
    public void saveOrder(Order order, UUID blockChainId){
        //TODO
    }

    /* checks the status of a blockchain:
        - Factory Request/Delivery
        - Producer Request/Delivery
    @return the status of a blockchain
     */
    public String status(){
        //TODO
        return "";
    }
}
