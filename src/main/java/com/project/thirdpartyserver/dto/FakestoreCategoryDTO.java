package com.project.thirdpartyserver.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakestoreCategoryDTO {
    private String status;
    private String message;
    private List<String> categories;
}
