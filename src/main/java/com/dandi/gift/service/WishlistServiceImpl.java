package com.dandi.gift.service;

import com.dandi.gift.model.Wishlist;
import com.dandi.gift.repository.WishlistRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public List<Wishlist> getAllWishes() {
        return wishlistRepository.findAll();
    }

    @Override
    public void saveWish(Wishlist wishlist) {
        this.wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist getWishById(long id) {
        Optional<Wishlist> optional = wishlistRepository.findById(id);
        Wishlist wishlist = null;
        if(optional.isPresent()) {
            wishlist = optional.get();
        } else {
            throw new RuntimeException("Wish not found for id :: " + id);
        }
        return wishlist;
    }

}
