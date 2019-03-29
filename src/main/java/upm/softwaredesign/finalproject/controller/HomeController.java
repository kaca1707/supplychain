package upm.softwaredesign.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Factory;
import upm.softwaredesign.finalproject.model.Producer;
import upm.softwaredesign.finalproject.model.Retailer;
import upm.softwaredesign.finalproject.repository.ActorEntity;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {


    private ActorEntity actorEntity;

    @Autowired
    public HomeController(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        List<Actor> allActors = actorEntity.findAll();
        mav.addObject("actors", allActors);
        mav.setViewName("home/index");

        return mav;
    }

    @PostMapping("/actor")
    public String createNewActor() {
        Actor a = new Actor();
        Random r = new Random();
        final String name = "TEST-ACTOR" + r.nextInt();
        a.setName(name);
        actorEntity.save(a);

        return "redirect:/";
    }
    
    @PostMapping("/retailer")
    public String createNewRetailer() {
        Actor a = new Retailer();
        Random r = new Random();
        final String name = "TEST-Retailer" + r.nextInt();
        a.setName(name);
        actorEntity.save(a);

        return "redirect:/";
    }

    @PostMapping("/factory")
    public String createNewFactory() {
        Actor a = new Factory();
        Random r = new Random();
        final String name = "TEST-Factory" + r.nextInt();
        a.setName(name);
        actorEntity.save(a);

        return "redirect:/";
    }
    
    @PostMapping("/producer")
    public String createNewProducer() {
        Actor a = new Producer();
        Random r = new Random();
        final String name = "TEST-Producer" + r.nextInt();
        a.setName(name);
        actorEntity.save(a);

        return "redirect:/";
    }
    
    
}
