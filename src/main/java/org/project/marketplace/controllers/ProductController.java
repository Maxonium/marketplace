package org.project.marketplace.controllers;

import lombok.RequiredArgsConstructor;
import org.project.marketplace.entities.ProductEntity;
import org.project.marketplace.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;

    @GetMapping("/")
    public String mainPage(@RequestParam(name = "title", required = false) String title, Model model)
    {
        model.addAttribute("productEntities", productService.allProducts(title));
        return "mainPage";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model)
    {
        ProductEntity product = productService.getProductById(id);
        model.addAttribute("productEntity", product);
        model.addAttribute("images", product.getListImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, ProductEntity product) throws IOException
    {
        productService.save(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        productService.delete(id);
        return "redirect:/";
    }
}
