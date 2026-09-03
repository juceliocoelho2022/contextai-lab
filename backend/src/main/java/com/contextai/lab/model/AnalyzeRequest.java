package com.contextai.lab.model;

import jakarta.validation.constraints.NotBlank;

public record AnalyzeRequest(
        @NotBlank(message = "O texto é obrigatório.")
        String text
) {
}
