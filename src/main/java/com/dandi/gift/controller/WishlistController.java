package com.dandi.gift.controller;

import com.dandi.gift.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
