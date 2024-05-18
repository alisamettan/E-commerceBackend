package com.workintech.ecommerce.controller;


import com.workintech.ecommerce.dto.CardRequest;
import com.workintech.ecommerce.dto.Converter;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.service.CardService;
import com.workintech.ecommerce.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin("http://localhost:5175")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> findAll(){
        return cardService.findAllCards();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable long id){
        Validation.checkId(id);
        return cardService.findById(id);
    }

    @PostMapping
    public Card save(@Validated @RequestBody Card card){
        return cardService.save(card);
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable Long id,@Validated @RequestBody CardRequest cardRequest){
        Validation.checkId(id);
        Card existingCard=cardService.findById(id);
        existingCard= Converter.mapToCard(cardRequest,existingCard);
        Card updated=cardService.save(existingCard);
        return updated;
    }

    @DeleteMapping("/{id}")
    public Card delete(@PathVariable Long id){
        Validation.checkId(id);
        return cardService.delete(id);
    }
}















