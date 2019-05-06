package upm.softwaredesign.finalproject.actor;

import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.order.OrderManager;
import upm.softwaredesign.finalproject.order.OrderStorage;

public class ActorFacadeTest {

    public static void main(String[] args) {

        // simple example of usage of actor Facade
        OrderStorage blockChainFactory = null;
        ActorFacade actorFacade = new ActorFacade(OrderManager.getInstance(blockChainFactory));
        actorFacade.createNewRequest(new Product());

    }
}
