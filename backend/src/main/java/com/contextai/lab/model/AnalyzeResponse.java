package com.contextai.lab.model;

import java.util.List;

public record AnalyzeResponse(
        String originalText,
        int tokenCount,
        List<TokenInfo> tokens,
        String explanation
) {
}
