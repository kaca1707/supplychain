package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.blockchain.Block;
import upm.softwaredesign.finalproject.blockchain.BlockChain;
import upm.softwaredesign.finalproject.blockchain.ProductionChain;
import upm.softwaredesign.finalproject.enums.TransactionStatus;

import java.util.*;

public class OrderProxy {

    private final static OrderProxy instance = new OrderProxy();

    public static OrderProxy getInstance(){
        return instance;
    }

    /*
    @return arraylist of orders that are in the BlockChain
     */
    public ArrayList<Order> consultChain(){

        ArrayList<Order> orderArrayList = new ArrayList<>();

        for (Block block : ProductionChain.getInstance().getBlocks()) {
            orderArrayList.add(block.getOrder());
        }

        return orderArrayList;
    }

    /* Saves an order in the BlockChain
    @param transactionGroupId: id  that links a maximum of 4 orders
    @param order: Request/Delivery that has to be added to a BlockChain
     */
    public void saveOrder(Order order, UUID transactionGroupId){
        Block block = new Block();
        block.setBlockId(transactionGroupId);
        block.setOrder(order);
        ProductionChain.getInstance().getBlocks().add(block);
    }

    /* checks the status of a transaction:
        - Retailer Request
        - Factory Request/Delivery
        - Producer Delivery
    @param transactionGroupId: id  that links a maximum of 4 orders
    @return the status of the transaction
     */
    public TransactionStatus status(UUID transactionGroupId){
        return ProductionChain.getInstance().getTransactionGroupStatus(transactionGroupId);
    }
}
