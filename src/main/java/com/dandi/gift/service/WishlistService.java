package com.dandi.gift.service;

import com.dandi.gift.model.Wishlist;

import java.util.List;

public interface WishlistService {
    List<Wishlist> getAllWishes();

    void saveWish(Wishlist wishlist);

    Wishlist getWishById(long id);
}
