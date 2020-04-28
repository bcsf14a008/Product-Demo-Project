package com.example.demo.Model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "product")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID productCode;

	private String name;
	private BigDecimal price;
	private String description;
}
