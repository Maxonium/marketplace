package org.project.marketplace.service;

import org.project.marketplace.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    private List<ProductEntity> productEntities = new ArrayList<>();
    private long ID = 0;

    {
        productEntities.add(new ProductEntity(++ID,"PS5", "Game box", 10000, "Moscow", "Max"));
        productEntities.add(new ProductEntity(++ID,"iPad", "cool thing", 2000, "Sochi", "Nick"));
    }

    public List<ProductEntity> allProducts()
    {
        return productEntities;
    }

    public ProductEntity getById(Long id)
    {
        for (ProductEntity product : productEntities)
        {
            if (product.getId().equals(id));
            return product;
        }
        return null;
    }

    public void save(ProductEntity product)
    {
        product.setId(++ID);
        productEntities.add(product);
    }

    public void delete(Long id)
    {
        productEntities.removeIf(product -> product.getId().equals(id));
    }
}
