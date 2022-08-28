package spring_boot.Zadanie311.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_boot.Zadanie311.SpringBoot.model.User;
import spring_boot.Zadanie311.SpringBoot.servises.UserServis;


@Controller
@RequestMapping()
public class UsersController {

    private final UserServis userServis;

    @Autowired
    public UsersController(UserServis userServis) {
        this.userServis =  userServis;
    }

    //Метод для получения всех User-ов
    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("users", userServis.allUsers());
        return "printUsers";
    }


    @GetMapping("/{id}")
    public String searchById(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userServis.searchById(id));
        return "searchById";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("users", new User());
        return "newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("users") User user) {
        userServis.save(user);
        return "redirect:/";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userServis.searchById(id));
        return "edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") User user,@PathVariable("id")int id){
        userServis.update(id,user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userServis.delete(id);
        return "redirect:/";
    }
}
