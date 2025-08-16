package com.project.ProductCatalogService.dto;

// Main Product POJO
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DummyJSONProductDTO {
    // Getters and Setters
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private Integer weight;
    private Dimensions dimensions;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private List<Review> reviews;
    private String returnPolicy;
    private Integer minimumOrderQuantity;
    private Meta meta;
    private List<String> images;
    private String thumbnail;

    // Default constructor
    public DummyJSONProductDTO() {}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", rating=" + rating +
                ", stock=" + stock +
                ", tags=" + tags +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                ", weight=" + weight +
                ", dimensions=" + dimensions +
                ", warrantyInformation='" + warrantyInformation + '\'' +
                ", shippingInformation='" + shippingInformation + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", reviews=" + reviews +
                ", returnPolicy='" + returnPolicy + '\'' +
                ", minimumOrderQuantity=" + minimumOrderQuantity +
                ", meta=" + meta +
                ", images=" + images +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}

// Dimensions POJO
@Setter
@Getter
class Dimensions {
    // Getters and Setters
    private Double width;
    private Double height;
    private Double depth;

    // Default constructor
    public Dimensions() {}

    @Override
    public String toString() {
        return "Dimensions{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}

// Review POJO
@Setter
@Getter
class Review {
    // Getters and Setters
    private Integer rating;
    private String comment;
    private String date;
    private String reviewerName;
    private String reviewerEmail;

    // Default constructor
    public Review() {}

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", reviewerEmail='" + reviewerEmail + '\'' +
                '}';
    }
}

// Meta POJO
@Setter
@Getter
class Meta {
    // Getters and Setters
    private String createdAt;
    private String updatedAt;
    private String barcode;
    private String qrCode;

    // Default constructor
    public Meta() {}

    @Override
    public String toString() {
        return "Meta{" +
                "createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", barcode='" + barcode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
