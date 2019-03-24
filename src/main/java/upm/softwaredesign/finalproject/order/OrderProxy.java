package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.enums.TransactionStatus;

import java.util.Set;
import java.util.UUID;

public class OrderProxy {

    /*
    @return set of orders that are in the BlockChain
     */
    public Set<Order> consultChain(){
        //TODO
        return null;
    }

    /* Saves an order in the BlockChain
    @param transactionGroupId: id  that links a maximum of 4 orders
    @param order: Request/Delivery that has to be added to a BlockChain
     */
    public void saveOrder(Order order, UUID transactionGroupId){
        //TODO
    }

    /* checks the status of a transaction:
        - Retailer Request
        - Factory Request/Delivery
        - Producer Delivery
    @param transactionGroupId: id  that links a maximum of 4 orders
    @return the status of the transaction
     */
    public TransactionStatus status(UUID transactionGroupId){
        //TODO
        return TransactionStatus.RETAILER_REQUEST;
    }
}
