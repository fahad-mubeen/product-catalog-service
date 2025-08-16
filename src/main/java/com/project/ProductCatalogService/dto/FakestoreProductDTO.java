package com.project.ProductCatalogService.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakestoreProductDTO{
	private String image;
	private String color;
	private int price;
	private String description;
	private boolean onSale;
	private int discount;
	private String model;
	private int id;
	private String title;
	private String category;
	private String brand;
}