package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ProductEntity;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllEmployees() {

		List<ProductEntity> list = productService.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{code}")
	public ResponseEntity<ProductEntity> getProductByCode(@PathVariable("code") UUID code) {

		ProductEntity entity = productService.getProductByCode(code);
		return new ResponseEntity<ProductEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody ProductEntity productEntity) {
		System.out.println("-------productEntity.getName()---------" + productEntity.getName());
		String updated = productService.saveProduct(productEntity);
		return new ResponseEntity<String>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody ProductEntity productEntity) {
		String updated = productService.updateProduct(productEntity);
		return new ResponseEntity<String>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public String deleteEmployeeById(@PathVariable("code") UUID code) {
		return productService.deleteProduct(code);
	}
}
