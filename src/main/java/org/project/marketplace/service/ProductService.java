package org.project.marketplace.service;

import org.project.marketplace.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    private List<ProductEntity> productEntities = new ArrayList<>();

    public List<ProductEntity> allProducts()
    {
        return productEntities;
    }

    public ProductEntity getProductById(Long id)
    {
        for (ProductEntity productEntity : productEntities)
        {
            if (productEntity.getId().equals(id)) return productEntity;
        }
        return null;
    }

    public void save(ProductEntity product)
    {
        productEntities.add(product);
    }

    public void delete(Long id)
    {
        productEntities.removeIf(product -> product.getId().equals(id));
    }
}
