package com.project.thirdpartyserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 500, message = "Name must be between 1 and 500 characters")
    private String name;
}
