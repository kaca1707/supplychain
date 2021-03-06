package upm.softwaredesign.finalproject.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.blockchain.BlockChain;
import upm.softwaredesign.finalproject.entity.ActorType;
import upm.softwaredesign.finalproject.enums.TransactionStatus;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.order.Order;
import upm.softwaredesign.finalproject.order.OrderManager;
import upm.softwaredesign.finalproject.service.ActorService;
import upm.softwaredesign.finalproject.service.BlockchainService;
import upm.softwaredesign.finalproject.viewmodel.CreateOrderVm;
import upm.softwaredesign.finalproject.viewmodel.CreateRequestViewModel;
import upm.softwaredesign.finalproject.viewmodel.RequestFormRetailerViewModel;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ActorController {

    private ActorService actorService;
    private BlockchainService blockchainService;
    private OrderManager om;

    private List<Order> pendingOrders(Integer actorId) {
        Collection<Order> collReceived = om.getReceivedOrders(actorId);
        Collection<Order> collSent = om.getSentOrders(actorId);
        List<Order> receivedOrders = new ArrayList<Order>(collReceived);
        List<Order> sentOrders = new ArrayList<Order>(collSent);
        List<Order> pendingOrders = new ArrayList<Order>();
        for (Order r: receivedOrders) {
            boolean t = false;
            for (Order s: sentOrders) {
                if (r.getTransactionGroupId().compareTo(s.getTransactionGroupId()) == 0
                    && r.getSender().getType() == s.getReceiver().getType())
                    t = true;
            }
            if (!t)
                pendingOrders.add(r);
        }
        return pendingOrders;
    }

    private Collection<String[]> sentOrders(Integer actorId) {
        Collection<Order> collSent = om.getSentOrders(actorId);
        List<Order> sentOrders = new ArrayList<Order>(collSent);
        Collection<Order> collRec = om.getReceivedOrders(actorId);
        List<Order> recOrders = new ArrayList<Order>(collRec);
       /* Collection<String[]> sent = new Collection<String[]>() {
        }*/
        List a = collSent.stream()
                .map(order -> {
                    String status = "Sent";
                    Actor receiver = order.getReceiver();
                    Collection<Order> reSent = om.getSentOrders(receiver.getId());
                    Collection<Order> reRec = om.getReceivedOrders(receiver.getId());
                    for (Order rs: reSent) {
                        if (rs.getTransactionGroupId().compareTo(order.getTransactionGroupId()) == 0
                            && rs.getSender().getType() != ActorType.PRODUCER) {
                            status = "Sent by next actor";
                        }
                    }
                    for (Order rr: reRec) {
                        if (rr.getTransactionGroupId().compareTo(order.getTransactionGroupId()) == 0
                            && rr.getSender().getType() != order.getSender().getType()) {
                            status = "Received by next actor";
                        }
                    }
                    for (Order r : recOrders) {
                        if (order.getTransactionGroupId().compareTo(r.getTransactionGroupId()) == 0
                            && order.getReceiver().getType() == r.getSender().getType()) {
                            status = "Completed";
                        }
                    }

                    return new String[]{order.getProduct().getName()
                            , status};
                }).collect(Collectors.toList());

                return a;
        /*return collSent.stream()
                .map(order -> new String[]{order.getProduct().getName()
                        , om.status(order.getTransactionGroupId()).toString()}).collect(Collectors.toList());*/
    }

    @Autowired
    public ActorController(ActorService actorService, BlockchainService blockchainService) {
        this.actorService = actorService;
        this.blockchainService = blockchainService;
        this.om = OrderManager.getInstance(new BlockChain(blockchainService));
    }

    @GetMapping("/actor/{id}")
    public ModelAndView getActorDetails(@PathVariable Integer id, ModelAndView mav) {
        Actor actor = actorService.retrieveActorById(id);

        if (actor.getType() == ActorType.RETAILER) {
            List<Actor> factories = actorService.retrieveActorByType(ActorType.FACTORY);

            mav.addObject("factories", factories);
            mav.addObject("selectedFactoryId", 0);
        } else if (actor.getType() == ActorType.FACTORY){
            List<Actor> producers = actorService.retrieveActorByType(ActorType.PRODUCER);
            mav.addObject("producers", producers);
            mav.addObject("selectedProducerId", 0);
            mav.addObject("orders", pendingOrders(id));
        } else {
            mav.addObject("orders", pendingOrders(id));
        }

        mav.setViewName(String.format("/actor/%s", actor.getType().getName()));
        mav.addObject("actor", actor);
        mav.addObject("sentOrders", sentOrders(id));
        return mav;
    }

    @PostMapping("/actor/form")
    public ModelAndView requestForm(ModelAndView mav, RequestFormRetailerViewModel vm) {
        Actor senderActor = actorService.retrieveActorById(vm.getActorId());
        Actor receiverActor = actorService.retrieveActorById(vm.getReceiverId());
        mav.addObject("senderActor", senderActor);
        mav.addObject("receiverActor", receiverActor);
        if (senderActor.getType() == ActorType.RETAILER)
            mav.setViewName("actor/retailerOrder");
        else
            mav.addObject("id", vm.getOrderId());
            mav.setViewName("actor/factoryOrder");
        return mav;
    }

    @PostMapping("/actor/newOrder")
    public ModelAndView createOrder(ModelAndView mav, CreateOrderVm orderVm) {
        String product = orderVm.getProduct();
        int count = orderVm.getCount();
        Product p = new Product(product, count);
        Actor senderActor = actorService.retrieveActorById(orderVm.getSender());
        Actor receiverActor = actorService.retrieveActorById(orderVm.getReceiver());

        if (orderVm.getId()!=null) {
            om.saveRequest(senderActor, receiverActor, p, new Date(), orderVm.getId());
        }
        else
            om.saveRequest(senderActor, receiverActor, p, new Date(), UUID.randomUUID());

        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("/actor/delivery")
    public ModelAndView createDelivery(ModelAndView mav, CreateRequestViewModel requestViewModel) {
        String product = requestViewModel.getName();
        int count = requestViewModel.getCount();
        Product p = new Product(product, count);
        Actor sender = actorService.retrieveActorById(requestViewModel.getSender());
        Actor receiver = actorService.retrieveActorById(requestViewModel.getReceiver());
        UUID transaction = requestViewModel.getId();
        om.saveDelivery(sender, receiver, p, new Date(), transaction);

        mav.setViewName("redirect:/");
        return mav;
    }

    /*@GetMapping("/actor/orders/{id}")
    public ModelAndView getCurrentOrders(@PathVariable Integer id, ModelAndView mav){
        System.out.println(id);

        mav.setViewName("redirect:/");
        return mav;
    }*/
}
