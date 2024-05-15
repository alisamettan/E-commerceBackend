package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> findAllCards();
    Card findById(long id);
    Card save(Card card);
    Card delete(long id);
}
