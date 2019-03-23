package upm.softwaredesign.finalproject.model;

import java.util.Set;
import java.util.UUID;

public class OrderProxy {

    /*
    @return set of orders that are in a blockchain
     */
    public Set<Order> consultChain(){
        //TODO
        return null;
    }

    /*
    @param order: Request/Delivery that has to be added to a blockchain
     */
    public void saveOrder(Order order, UUID blockChainId){
        //TODO
    }

    /*
    @return the status of an order
     */
    public String status(){
        //TODO
        return "";
    }
}
