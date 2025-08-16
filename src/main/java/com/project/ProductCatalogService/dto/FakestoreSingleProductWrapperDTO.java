package com.project.ProductCatalogService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreSingleProductWrapperDTO {
    private String status;
    private String message;
    private FakestoreProductDTO product;
}
