package upm.softwaredesign.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.repository.ActorRepository;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {


    private ActorRepository actorRepository;

    @Autowired
    public HomeController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        List<Actor> allActors = actorRepository.findAll();
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
        actorRepository.save(a);

        return "redirect:/";
    }
}
