package by.kiselevich.tacocloud.controller;

import by.kiselevich.tacocloud.repository.OrderRepository;
import by.kiselevich.tacocloud.model.Order;
import by.kiselevich.tacocloud.model.User;
import by.kiselevich.tacocloud.config.OrderProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderProps orderProps;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderProps orderProps) {
        this.orderRepository = orderRepository;
        this.orderProps = orderProps;
        log.debug("ORDER PAGE SIZE = {}", orderProps.getPageSize());
    }

    @GetMapping("/current")
    public String orderForm(@ModelAttribute Order order, @AuthenticationPrincipal User user) {
        if (order.getUser() == null) {
            order.setUser(user);
        }
        setOrderFieldsFromUser(order, user);
        return "orderForm";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders", orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        setOrderFieldsFromUser(order, user);
        order = orderRepository.save(order);
        log.info("Order submitted: " + order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    private void setOrderFieldsFromUser(Order order, User user) {
        order.setName(user.getFullname());
        order.setStreet(user.getStreet());
        order.setCity(user.getCity());
        order.setState(user.getState());
        order.setZip(user.getZip());
    }
}
