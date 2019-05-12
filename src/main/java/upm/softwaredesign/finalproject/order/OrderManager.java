package upm.softwaredesign.finalproject.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import upm.softwaredesign.finalproject.enums.TransactionStatus;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Factory;
import upm.softwaredesign.finalproject.model.Producer;
import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.model.Retailer;

public class OrderManager {

  private OrderStorage orderStorage;
  private static OrderManager instance;

  private OrderManager() {}

  public static OrderManager getInstance(OrderStorage orderStorage) {
    if (instance == null) {
      instance = new OrderManager();
      instance.orderStorage = orderStorage;
    }

    return instance;
  }

  /*
  @return collection of orders that are in the BlockChain
   */
  public Collection<Order> consultChain() {
    return orderStorage.listOrders();
  }

  /*
  @param actorId
  @return collection of orders that an actor has sent
   */
  public Collection<Order> getSentOrders(Integer actorId) {
    return orderStorage.listOrders().stream()
        .filter(order -> order.getSender().getId().equals(actorId))
        .collect(Collectors.toList());
  }

  /*
  @param actorId
  @return collection of orders that an actor has receive
 */
  public Collection<Order> getReceivedOrders(Integer actorId) {
    return orderStorage.listOrders().stream()
        .filter(order -> order.getReceiver().getId().equals(actorId))
        .collect(Collectors.toList());
  }

  /*
  @param actorId
  @return collection of pending orders of an actor
 */
  public Collection<Order> getPendingOrders(Integer actorId) {
    Collection<Order> receivedOrderCollection= getReceivedOrders(actorId);
    Collection<Order> sentOrderCollection = getSentOrders(actorId);
    if (sentOrderCollection.size() == 0 && receivedOrderCollection.size() == 0){
      return null;
    }else if(receivedOrderCollection.size() == 0){
      return receivedOrderCollection;
    }else if(sentOrderCollection.size() == 0){
      return receivedOrderCollection;
    }else {
      Stream<Order> orderCollection = Stream.concat(receivedOrderCollection.stream(),
          sentOrderCollection.stream());

      List<UUID> idList = orderCollection.map(order -> order.getTransactionGroupId()).collect(
          Collectors.toList());
      return orderCollection.
          filter(order -> Collections.frequency(idList, order.getTransactionGroupId()) < 2)
          .collect(Collectors.toList());
    }
  }

  /* Saves a request order in the BlockChain
  @param sender
  @param product
  @param time
  @param transactionGroupId: id  that links a maximum of 4 orders
   */
  public void saveRequest(Actor sender, Actor receiver, Product product, Date time, UUID transactionGroupId) {
    Request request = new Request(sender, receiver, product, time);
    request.setTransactionGroupId(transactionGroupId);
    orderStorage.addOrder(request);
  }

  /* Saves a delivery order in the BlockChain
   @param sender
   @param product
   @param time
   @param transactionGroupId: id  that links a maximum of 4 orders
    */
  public void saveDelivery(Actor sender, Actor receiver, Product product, Date time, UUID transactionGroupId) {
    Delivery delivery = new Delivery(sender, receiver, product, time);
    delivery.setTransactionGroupId(transactionGroupId);
    orderStorage.addOrder(delivery);
  }

  /* checks the status of a transaction:
      - Retailer Request
      - Factory Request/Delivery
      - Producer Delivery
  @param transactionGroupId: id  that links a maximum of 4 orders
  @return the status of the transaction
   */
  public TransactionStatus status(UUID transactionGroupId) {
    ArrayList<Order> linkedOrder = new ArrayList<Order>();
    TransactionStatus status = null;
    for (Order order : orderStorage.listOrders()) {
      if (order.getTransactionGroupId().equals(transactionGroupId)) {
        linkedOrder.add(order);
      }
    }

    if (!linkedOrder.isEmpty()) {
      // Initial status if there are linked orders
      status = TransactionStatus.RETAILER_REQUEST;
      for (Order order : linkedOrder) {
        // This sequence of if statements are important
        // Because we check from the reverse order so that we get the latest status
        // FACTORY_DELIVERY <- PRODUCER_DELIVERY <- FACTORY_REQUEST <- RETAILER_REQUEST

        if (order instanceof Delivery
            && order.getSender() instanceof Factory  // Hence Factory Delivery
            && status.getSequenceIndex() < TransactionStatus.FACTORY_DELIVERY.getSequenceIndex()) {

          status = TransactionStatus.FACTORY_DELIVERY;

        } else if (order instanceof Delivery
            && order.getSender() instanceof Producer
            && status.getSequenceIndex() < TransactionStatus.PRODUCER_DELIVERY.getSequenceIndex()) {

          status = TransactionStatus.PRODUCER_DELIVERY;
          break;

        } else if (order instanceof Request
            && order.getSender() instanceof Factory
            && status.getSequenceIndex() < TransactionStatus.FACTORY_REQUEST.getSequenceIndex()) {

          status = TransactionStatus.FACTORY_REQUEST;


        } else if (order instanceof Request
            && order.getSender() instanceof Retailer
            && status.getSequenceIndex() < TransactionStatus.RETAILER_REQUEST.getSequenceIndex()) {

          status = TransactionStatus.RETAILER_REQUEST;

        }
      }
    }
    return status;
  }
}
