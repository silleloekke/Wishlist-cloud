package dk.kea.wishcloudone.Controller;

import dk.kea.wishcloudone.Models.Wish;
import dk.kea.wishcloudone.Repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WishController {
    @Autowired
    private WishRepository wishRepository;

    @GetMapping("/")
    public String listWishes(Model model) {
        List<Wish> wishes = wishRepository.findAll();
        model.addAttribute("wishes", wishes);
        return "wish-homepage";
    }

    @GetMapping("/new")
    public String newWish(Model model) {
        model.addAttribute("wish", new Wish());
        return "new";
    }

    @PostMapping("/save")
    public String saveWish(@ModelAttribute("wish") Wish wish) {
        wishRepository.save(wish);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editWish(@PathVariable("id") Long id, Model model) {
        Wish wish = wishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid wish ID"));
        model.addAttribute("wish", wish);
        return "edit-wish";
    }

    @GetMapping("/delete/{id}")
    public String deleteWish(@PathVariable("id") Long id) {
        Wish wish = wishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid wish ID"));
        wishRepository.delete(wish);
        return "redirect:/";
    }

}

