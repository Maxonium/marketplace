package org.project.marketplace.exeptions;

public class ProductNotFound extends RuntimeException
{
    public ProductNotFound(String message) {
        super(message);
    }
}
