package com.dandi.gift.controller;

import com.dandi.gift.model.Wishlist;
import com.dandi.gift.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishlistController {


    @Autowired
    private WishlistService wishlistService;

    // display list of wishes
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listWishes", wishlistService.getAllWishes());
        return "index";
    }

    @GetMapping("/newWishForm")
    public String showNewWishForm(Model model) {
        //create model attribute to bind form data
        Wishlist wishlist = new Wishlist();
        model.addAttribute("wish", wishlist);
        return "new_wish";
    }
    @PostMapping("/saveWish")
    public String saveWish(@ModelAttribute("wishlist") Wishlist wishlist) {
        //save wish to db
        wishlistService.saveWish(wishlist);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showForForUpdate(@PathVariable (value = "id") long id, Model model){
        //get wish from the service
        Wishlist wishlist = wishlistService.getWishById(id);

        //set wish as a model attribute to pre-populate form
        model.addAttribute("wish", wishlist);
        return "update_wish";
    }
}
