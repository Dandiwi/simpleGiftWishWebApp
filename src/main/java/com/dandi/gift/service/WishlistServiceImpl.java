package com.dandi.gift.service;

import com.dandi.gift.model.Wishlist;
import com.dandi.gift.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
