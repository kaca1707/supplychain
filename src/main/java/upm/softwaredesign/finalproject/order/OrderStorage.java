package upm.softwaredesign.finalproject.order;

import java.util.Collection;

public interface OrderStorage {

  public Collection<Order> listOrders();

  public void addOrder(Order newOrder);

}
