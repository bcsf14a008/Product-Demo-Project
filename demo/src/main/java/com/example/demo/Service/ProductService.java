package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import com.example.demo.Model.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts();

	public ProductEntity getProductByCode(UUID productCode);

	public String updateProduct(ProductEntity productEntity);

	public String saveProduct(ProductEntity productEntity);

	public String deleteProduct(UUID productCode);
}
