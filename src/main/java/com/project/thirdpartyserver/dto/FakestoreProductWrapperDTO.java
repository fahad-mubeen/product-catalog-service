package com.project.thirdpartyserver.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakestoreProductWrapperDTO {
    private String status;
    private String message;
    private List<FakestoreProductDTO> products;
}
