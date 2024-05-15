package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CardServiceImpl implements CardService{


    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(long id) {
       return cardRepository.findById(id).orElseThrow(()->{
           throw new ApiException("Card by given id cannot be found: "+id, HttpStatus.NOT_FOUND);
       });
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card delete(long id) {
        Card card=findById(id);
        cardRepository.delete(card);
        return card;
    }
}
