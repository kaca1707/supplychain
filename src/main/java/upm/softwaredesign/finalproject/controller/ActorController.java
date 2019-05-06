package upm.softwaredesign.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.entity.ActorType;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.service.ActorService;
import upm.softwaredesign.finalproject.service.BlockchainService;

import java.util.List;

@Controller
public class ActorController {

    private ActorService actorService;
    private BlockchainService blockchainService;

    @Autowired
    public ActorController(ActorService actorService, BlockchainService blockchainService) {
        this.actorService = actorService;
        this.blockchainService = blockchainService;
    }

    @GetMapping("/actor/{id}")
    public ModelAndView getActorDetails(@PathVariable Integer id, ModelAndView mav) {
        Actor actor = actorService.retrieveActorById(id);

        List<Actor> factories = actorService.retrieveActorByType(ActorType.FACTORY);

        mav.setViewName(String.format("/actor/%s", actor.getType().getName()));
        mav.addObject("actor", actor);
        mav.addObject("factories", factories);
        mav.addObject("selectedFactoryId", 0);
//        actor.get
//        mav.addObject("")
        return mav;
    }

    @PostMapping("/actor/form")
    public ModelAndView requestForm(ModelAndView mav, Integer selectedFactoryId) {
        //todo: retrieving data from from - to check
        System.out.println("Selected factory:" + selectedFactoryId);
        mav.setViewName("redirect:/");
        return mav;
    }
}
