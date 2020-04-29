package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ProductEntity;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> getAllProducts() {
		logger.info("Get All Products from DB!");
		return productRepository.findAll();
	}

	@Override
	public ProductEntity getProductByCode(UUID productCode) {
		Optional<ProductEntity> productEntity = productRepository.findById(productCode);
		if (productEntity.isPresent()) {
			logger.info("Get Product from DB against product code!");
			return productEntity.get();
		}
		logger.info("Product not found against productCode: " + productCode);
		return null;
	}

	@Override
	public String saveProduct(ProductEntity productEntity) {
		try {
			productRepository.save(productEntity);
			logger.info("Product Saved Successfully!");
			return "Product Saved Successfully!";
		} catch (Exception e) {
			logger.error("Exception occure while saving product: " + e);
			return "Product Save Failed!";
		}
	}

	@Override
	public String updateProduct(ProductEntity productEntity) {
		try {
			productRepository.save(productEntity);
			logger.info("Product Update Successfully!");
			return "Product Update Successfully!";
		} catch (Exception e) {
			logger.error("Exception occure while updating product: " + e);
			return "Product Update Failed!";
		}
	}

	@Override
	public String deleteProduct(UUID productCode) {
		try {
			Optional<ProductEntity> productEntity = productRepository.findById(productCode);
			if (productEntity.isPresent()) {
				productRepository.delete(productEntity.get());
				logger.info("Product Deleted Successfully!");
				return "Product Deleted Successfully!";
			}
			logger.info("Product not found against productCode: " + productCode);
			return "Product not found against productCode: " + productCode;
		} catch (Exception e) {
			logger.error("Exception occure while deleting product: " + e);
			return "Product Deletion Failed!";
		}
	}
}
