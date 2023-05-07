package org.project.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEntity
{
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private String city;
    private String author;
}
