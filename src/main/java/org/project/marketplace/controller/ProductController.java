package org.project.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.project.marketplace.entity.ProductEntity;
import org.project.marketplace.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model)
    {
        model.addAttribute("products", productService.allProducts());
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct(ProductEntity product)
    {
        productService.save(product);
        return "redirect:/";
    }
}
