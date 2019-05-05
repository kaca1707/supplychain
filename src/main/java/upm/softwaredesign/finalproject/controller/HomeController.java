package upm.softwaredesign.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.entity.ActorType;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.service.ActorService;
import upm.softwaredesign.finalproject.service.BlockchainService;
import upm.softwaredesign.finalproject.viewmodel.HomeViewModel;
import upm.softwaredesign.finalproject.viewmodel.LoginViewModel;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Controller
public class HomeController {

    private ActorService actorService;
    private BlockchainService blockchainService;

    @Autowired
    public HomeController(ActorService actorService, BlockchainService blockchainService) {
        this.actorService = actorService;
        this.blockchainService = blockchainService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav, HomeViewModel model) {

        ActorType actorType = ofNullable(model.getType())
                .map(String::toUpperCase)
                .map(ActorType::valueOf)
                .orElse(ActorType.RETAILER);

        List<Actor> actors = actorService.retrieveActorByType(actorType);
        mav.addObject("actors", actors);
        mav.addObject("actorType", actorType.getName());
        mav.setViewName("home/index");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView evaluateLogin(ModelAndView modelAndView, LoginViewModel model) {

        if (isNull(model.getId())) {
            modelAndView.setViewName("redirect:/home/index");
            return modelAndView;
        }
        modelAndView.setViewName(String.format("redirect:/actor/%d", model.getId()));
        return modelAndView;
    }

    /*
    @PostMapping("/actor")
    public String createNewActor() {
        ActorEntity a = new ActorEntity();
        Random r = new Random();
        final String name = "TEST-ACTOR" + r.nextInt();
        a.setName(name);
        actorRepository.save(a);

        return "redirect:/";
    }

*/
}
