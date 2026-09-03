package com.contextai.lab.service;

import com.contextai.lab.model.AnalyzeResponse;
import com.contextai.lab.model.TokenInfo;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TextAnalysisService {

    public AnalyzeResponse analyze(String text) {
        String normalized = text.trim().replaceAll("\\s+", " ");
        String[] rawTokens = normalized.split("(?=[,.!?;:])|(?<=[,.!?;:])|\\s+");

        List<TokenInfo> tokens = new ArrayList<>();

        for (int i = 0; i < rawTokens.length; i++) {
            String token = rawTokens[i].trim();
            if (token.isBlank()) {
                continue;
            }

            tokens.add(new TokenInfo(
                    tokens.size(),
                    token,
                    deterministicTokenId(token)
            ));
        }

        return new AnalyzeResponse(
                normalized,
                tokens.size(),
                tokens,
                "Nesta Sprint 1, os token IDs são didáticos e determinísticos. " +
                        "Na próxima etapa eles serão substituídos por tokenização real do modelo de embeddings."
        );
    }

    private int deterministicTokenId(String token) {
        String canonical = Normalizer.normalize(token.toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return Math.floorMod(canonical.hashCode(), 100_000);
    }
}
