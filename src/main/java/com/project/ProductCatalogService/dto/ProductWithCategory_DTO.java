package com.project.ProductCatalogService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategory_DTO {
    private Long id;
    String name;
    CategoryDTO categoryDTO;
}
