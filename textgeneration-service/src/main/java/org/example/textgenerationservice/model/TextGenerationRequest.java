package org.example.textgenerationservice.model;

import java.util.List;

public class TextGenerationRequest {

    private List<Content> contents;

    public TextGenerationRequest(List<Content> contents) {
        this.contents = contents;
    }

    public List<Content> getContents() {
        return contents;
    }

    public static class Content {

        private List<Part> parts; // Changed to single Part object

        public Content(List<Part> part) {
            this.parts = part;
        }

        public List<Part> getPart() {
            return parts;
        }
    }

    public static class Part {

        private String text;

        public Part(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}