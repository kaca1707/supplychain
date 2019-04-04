package upm.softwaredesign.finalproject.actor;

import upm.softwaredesign.finalproject.enums.TransactionStatus;
import upm.softwaredesign.finalproject.model.*;
import upm.softwaredesign.finalproject.order.OrderProxy;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class ActorFacade {

    // retailer -> factory -> producer -> factory -> retailer
    private Actor factory = new Factory();
    private Actor producer = new Producer();
    private Actor retailer = new Retailer();

    private OrderProxy orderProxy;

    public ActorFacade(OrderProxy orderProxy) {
        this.orderProxy = requireNonNull(orderProxy);
        retailer.setNextInChain(factory);
        factory.setPreviousInChain(retailer);
        factory.setNextInChain(producer);
        producer.setNextInChain(factory);
    }


    public void createNewRequest(Product product) {
        UUID uuid = UUID.randomUUID();
//        orderProxy.saveOrder(retailer, product, new Date(), uuid);

        this.retailer.processRequest(product, TransactionStatus.RETAILER_REQUEST);
    }


}
