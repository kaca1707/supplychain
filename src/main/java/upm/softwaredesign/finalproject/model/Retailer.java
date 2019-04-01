package upm.softwaredesign.finalproject.model;

import upm.softwaredesign.finalproject.enums.TransactionStatus;

public class Retailer extends Actor {


    @Override
    public boolean processRequest(Product product, TransactionStatus status) {
        if (status == TransactionStatus.RETAILER_REQUEST) {
            System.out.println("RETAILER #1 - Received request - passing to factory");
            return this.getNextInChain().processRequest(product, TransactionStatus.RETAILER_REQUEST);
        } else if (status == TransactionStatus.FACTORY_DELIVERY) {
            System.out.println("RETAILER #5 - Finished processing request");
            return true;
        }
        System.out.println("Cannot recognize status - processing error");
        return false;

    }

}
