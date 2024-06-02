package org.example.textgenerationservice.model;

import java.util.List;

public class TextGenerationResponse {
    private List<Candidate> candidates;

    public TextGenerationResponse(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public TextGenerationResponse() {
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}

