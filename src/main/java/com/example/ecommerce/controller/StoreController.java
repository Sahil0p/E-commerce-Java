package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartSize", getCart(session).size());
        return "index";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
        productService.getProductById(productId).ifPresent(product -> {
            List<Product> cart = getCart(session);
            cart.add(product);
            session.setAttribute("cart", cart);
        });
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        List<Product> cart = getCart(session);
        model.addAttribute("cart", cart);
        double total = cart.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/cart/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        session.removeAttribute("cart");
        model.addAttribute("message", "Thank you for your purchase!");
        return "cart";
    }

    @SuppressWarnings("unchecked")
    private List<Product> getCart(HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        return cart;
    }
}
