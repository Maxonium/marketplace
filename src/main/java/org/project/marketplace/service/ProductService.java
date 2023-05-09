package org.project.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.marketplace.entity.Image;
import org.project.marketplace.entity.ProductEntity;
import org.project.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public void save(ProductEntity product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() != 0)
        {
            image1 = toImageEntity(file1);
            image1.setPreviewImages(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0)
        {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0)
        {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        ProductEntity productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getListImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException
    {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }
}
