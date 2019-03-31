package upm.softwaredesign.finalproject.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import upm.softwaredesign.finalproject.entity.ActorEntity;
import upm.softwaredesign.finalproject.model.FactoryEntity;
import upm.softwaredesign.finalproject.model.ProducerEntity;
import upm.softwaredesign.finalproject.model.RetailerEntity;
import upm.softwaredesign.finalproject.repository.ActorRepository;
import upm.softwaredesign.finalproject.service.BlockchainService;

@Controller
public class HomeController {

    private ActorRepository actorRepository;
    private BlockchainService blockchainService;

    @Autowired
    public HomeController(ActorRepository actorRepository, BlockchainService blockchainService) {
        this.actorRepository = actorRepository;
        this.blockchainService = blockchainService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        List<ActorEntity> allActors = actorRepository.findAll();
        mav.addObject("actors", allActors);
        mav.setViewName("home/index");

        return mav;
    }

    @PostMapping("/actor")
    public String createNewActor() {
        ActorEntity a = new ActorEntity();
        Random r = new Random();
        final String name = "TEST-ACTOR" + r.nextInt();
        a.setName(name);
        actorRepository.save(a);

        return "redirect:/";
    }

    @PostMapping("/retailer")
    public String createNewRetailer() {
        ActorEntity a = new RetailerEntity();
        Random r = new Random();
        final String name = "TEST-Retailer" + r.nextInt();
        a.setName(name);
        actorRepository.save(a);

        return "redirect:/";
    }

    @PostMapping("/factory")
    public String createNewFactory() {
        ActorEntity a = new FactoryEntity();
        Random r = new Random();
        final String name = "TEST-Factory" + r.nextInt();
        a.setName(name);
        actorRepository.save(a);

        return "redirect:/";
    }

    @PostMapping("/producer")
    public String createNewProducer() {
        ActorEntity a = new ProducerEntity();
        Random r = new Random();
        final String name = "TEST-Producer" + r.nextInt();
        a.setName(name);
        actorRepository.save(a);

        return "redirect:/";
    }

}
