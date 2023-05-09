package org.project.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.marketplace.entity.ProductEntity;
import org.project.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService
{
    public final ProductRepository productRepository;

    public List<ProductEntity> allProducts(String title)
    {
        List<ProductEntity> productEntities = productRepository.findAll();
        if (title != null)
            {
                // Добавить поиск по неполным title
                return productRepository.findByTitle(title);
            }
        return productRepository.findAll();
    }

    public ProductEntity getProductById(Long id)
    {
        // Поменять на orElseThrow с моделью er.404
        return productRepository.findById(id).orElse(null);
    }

    public void save(ProductEntity product)
    {
        log.info("saving new product {}", product );
        productRepository.save(product);
    }

    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }
}
