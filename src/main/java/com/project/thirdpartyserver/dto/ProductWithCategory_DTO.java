package com.project.thirdpartyserver.dto;

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
