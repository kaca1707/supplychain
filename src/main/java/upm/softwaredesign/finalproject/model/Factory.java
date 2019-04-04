package upm.softwaredesign.finalproject.model;


import upm.softwaredesign.finalproject.enums.TransactionStatus;

public class Factory extends Actor {

    @Override
    public boolean processRequest(Product product, TransactionStatus status) {
        // if received from RETAILER pass to Producer
        if (status == TransactionStatus.RETAILER_REQUEST) {
            System.out.println("FACTORY #2 - RECEIVED FROM RETAILER PASSING TO PRODUCER");
            return this.getNextInChain().processRequest(product, TransactionStatus.FACTORY_REQUEST);
        } else {
            System.out.println("FACTORY #4 - RECEIVED FROM PRODUCER PASSING TO RETAILER ");
            return this.getPreviousInChain().processRequest(product, TransactionStatus.FACTORY_DELIVERY);
        }
    }
}
