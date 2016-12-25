package com.bvan.jc.oop.textsearcher.textcontent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class BookDescription implements TextContent {

    private final String title;
    private final List<String> authors;
    private final String publisher;
    private final String annotation;
    private final String text;

    private BookDescription(Builder builder) {
        this.title = builder.title;
        this.authors = builder.authors;
        this.publisher = builder.publisher;
        this.annotation = builder.annotation;
        this.text = builder.text;
    }

    @Override
    public boolean containsInTitle(String key) {
        return title.contains(key);
    }

    @Override
    public boolean containsInText(String key) {
        return text.contains(key);
    }

    public static class Builder {

        private String title;
        private List<String> authors = new ArrayList<>();
        private String publisher;
        private String annotation;
        private String text;

        public BookDescription build() {
            return new BookDescription(this);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder addAuthor(String author) {
            this.authors.add(author);
            return this;
        }

        public Builder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder setAnnotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }
    }
}
