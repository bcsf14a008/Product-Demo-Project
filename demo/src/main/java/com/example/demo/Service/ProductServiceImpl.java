package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ProductEntity;
import com.example.demo.Repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity getProductByCode(UUID productCode) {
		Optional<ProductEntity> productEntity = productRepository.findById(productCode);
		if (productEntity.isPresent()) {
			return productEntity.get();
		}
		return null;
	}

	@Override
	public String saveProduct(ProductEntity productEntity) {
		try {
			productRepository.save(productEntity);
			return "Product Saved Successfully!";
		} catch (Exception e) {
			log.error("Exception occure while saving product: " + e);
			return "Product Save Failed!";
		}
	}

	@Override
	public String updateProduct(ProductEntity productEntity) {
		try {
			productRepository.save(productEntity);
			return "Product Update Successfully!";
		} catch (Exception e) {
			log.error("Exception occure while updating product: " + e);
			return "Product Update Failed!";
		}
	}

	@Override
	public String deleteProduct(UUID productCode) {
		try {
			Optional<ProductEntity> productEntity = productRepository.findById(productCode);
			if (productEntity.isPresent()) {
				productRepository.delete(productEntity.get());
				return "Product Deleted Successfully!";
			}
			return "Product not found against productCode: " + productCode;
		} catch (Exception e) {
			log.error("Exception occure while deleting product: " + e);
			return "Product Deletion Failed!";
		}
	}
}
