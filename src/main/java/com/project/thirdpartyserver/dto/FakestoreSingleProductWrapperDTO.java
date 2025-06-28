package com.project.thirdpartyserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreSingleProductWrapperDTO {
    private String status;
    private String message;
    private FakestoreProductDTO product;
}
