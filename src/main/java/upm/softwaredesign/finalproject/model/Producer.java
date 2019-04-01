package upm.softwaredesign.finalproject.model;


import upm.softwaredesign.finalproject.enums.TransactionStatus;

public class Producer extends Actor {

    @Override
    public boolean processRequest(Product product, TransactionStatus status) {
        System.out.println();
        System.out.println("Producer #3 - RECEIVED FROM FACTORY PASSING TO FACTORY");
        return this.getNextInChain().processRequest(product, TransactionStatus.PRODUCER_DELIVERY);
    }


}
