package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.OrderRequest;

import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.entity.Order;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.repository.AddressRepository;
import com.workintech.ecommerce.repository.CardRepository;
import com.workintech.ecommerce.repository.OrderRepository;
import com.workintech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private AddressRepository addressRepository;
    private CardRepository cardRepository;
    private ProductRepository productRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, AddressRepository addressRepository, CardRepository cardRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.cardRepository = cardRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Order order=new Order();
        order.setOrderDate(LocalDate.now());

        //Address
        Optional<Address> addressOptional=addressRepository.findById(orderRequest.getAddressId());

        if(addressOptional.isEmpty()){
            throw new ApiException("Address not found", HttpStatus.NOT_FOUND);
        }
        order.setAddress(addressOptional.get());

        //Card

        Card card=new Card();
        card.setCardNo(orderRequest.getCardNo());
        card.setExpireMonth(orderRequest.getExpireMonth());
        card.setExpireYear(orderRequest.getExpireYear());
        card.setNameOnCard(orderRequest.getNameOnCard());
        cardRepository.save(card);
        order.setCard(card);

        //Products
        List<Product> products=orderRequest.getProducts();
        double totalPrice=products.stream().mapToDouble(Product::getPrice).sum();

        order.setPrice(totalPrice);
        order.setProductList(products);

        //save order
        orderRepository.save(order);

        return new OrderResponse(order.getOrderDate(),order.getPrice(),order.getProductList());

    }

    @Override
    public List<OrderResponse> findAllOrders() {
        List<Order> orders=orderRepository.findAll();
        return orders.stream()
                .map(order->new OrderResponse(order.getOrderDate(),order.getPrice(),order.getProductList())).collect(Collectors.toList());
    }
}