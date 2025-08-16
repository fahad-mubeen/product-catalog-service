package com.project.ProductCatalogService.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DummyJSONProductWrapperDTO {
    private List<DummyJSONProductDTO> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
