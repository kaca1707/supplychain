package upm.softwaredesign.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.blockchain.BlockChain;
import upm.softwaredesign.finalproject.entity.ActorType;
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

@Controller
public class ActorController {

    private ActorService actorService;
    private BlockchainService blockchainService;
    private OrderManager om;

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
            Collection<Order> coll = om.getReceivedOrders(id);
            List<Order> pendingOrders = new ArrayList<Order>(coll);
            List<Actor> producers = actorService.retrieveActorByType(ActorType.PRODUCER);
            mav.addObject("producers", producers);
            mav.addObject("selectedProducerId", 0);
            mav.addObject("orders", pendingOrders);
        } else {
            Collection<Order> coll = om.getReceivedOrders(id);
            List<Order> pendingOrders = new ArrayList<Order>(coll);
            //mav.addObject("factories", factories);
            //mav.addObject("selectedFactoryId", 0);
            mav.addObject("orders", pendingOrders);
        }

        mav.setViewName(String.format("/actor/%s", actor.getType().getName()));
        mav.addObject("actor", actor);

//        actor.get
//        mav.addObject("")
        return mav;
    }

    @PostMapping("/actor/form")
    public ModelAndView requestForm(ModelAndView mav, RequestFormRetailerViewModel vm) {

        Actor senderActor = actorService.retrieveActorById(vm.getActorId());
        Actor receiverActor = actorService.retrieveActorById(vm.getReceiverId());
        mav.addObject("senderActor", senderActor);
        mav.addObject("receiverActor", receiverActor);
        mav.setViewName("actor/retailerOrder");
        return mav;
    }

    @PostMapping("/actor/newOrder")
    public ModelAndView createOrder(ModelAndView mav, CreateOrderVm orderVm) {
        String product = orderVm.getProduct();
        int count = orderVm.getCount();
        Product p = new Product(product, count);
        Actor senderActor = actorService.retrieveActorById(orderVm.getSender());
        Actor receiverActor = actorService.retrieveActorById(orderVm.getReceiver());

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
}
