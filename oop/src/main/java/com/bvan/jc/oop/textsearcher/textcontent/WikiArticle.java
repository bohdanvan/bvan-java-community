package com.bvan.jc.oop.textsearcher.textcontent;

import java.net.URL;

/**
 * @author bvanchuhov
 */
public class WikiArticle implements TextContent {

    private final URL link;
    private final String title;
    private final String text;

    private WikiArticle(Builder builder) {
        this.link = builder.link;
        this.title = builder.title;
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

        private URL link;
        private String title;
        private String text;

        public WikiArticle build() {
            return new WikiArticle(this);
        }

        public Builder setLink(URL link) {
            this.link = link;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }
    }
}
