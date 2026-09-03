package com.contextai.lab.api;

import com.contextai.lab.model.AnalyzeRequest;
import com.contextai.lab.model.AnalyzeResponse;
import com.contextai.lab.service.TextAnalysisService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analyze")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class TextAnalysisController {

    private final TextAnalysisService textAnalysisService;

    public TextAnalysisController(TextAnalysisService textAnalysisService) {
        this.textAnalysisService = textAnalysisService;
    }

    @PostMapping
    public ResponseEntity<AnalyzeResponse> analyze(@Valid @RequestBody AnalyzeRequest request) {
        return ResponseEntity.ok(textAnalysisService.analyze(request.text()));
    }
}
