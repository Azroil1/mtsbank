package ru.mtsbank.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.service.CreatureServiceImpl;

@Controller
@RequestMapping("/creature/ui")
public class UICreateController {
    CreatureServiceImpl creatureService;

    public UICreateController(CreatureServiceImpl creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/index")
    public String allCreature(Model model) {
        model.addAttribute("creatures", creatureService.getCreatures());
        return "index";
    }

    @PostMapping("/index/{id}")
    public String deleteCreature(@PathVariable long id) {
        creatureService.deleteCreature(id);
        return "redirect:/creature/ui/index";
    }

    @GetMapping("/create")
    public String creaturePage(Model model) {
        model.addAttribute("creature", new Creature());
        return "create";
    }
    @PostMapping("/create")
    public String createCreature(@ModelAttribute Creature creature) {
        creatureService.createCreature(creature);
        return "redirect:/creature/ui/index";
    }
    @GetMapping("/cancel-create")
    public String cancelCreate() {
        return "redirect:/creature/ui/index";
    }

}
