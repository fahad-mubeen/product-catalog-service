package com.project.thirdpartyserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private double price;
    private String name;
    private Long categoryId;
}
