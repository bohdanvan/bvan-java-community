package com.bvan.jc.oop.textsearcher.textcontent;

import com.bvan.jc.oop.textsearcher.spec.AndSpec;
import com.bvan.jc.oop.textsearcher.spec.Spec;
import com.bvan.jc.oop.textsearcher.spec.Storage;

/**
 * @author bvanchuhov
 */
public class BookDescriptionRunner {

    public static void main(String[] args) {
        Storage<BookDescription> storage = new Storage();
        storage.add(new BookDescription.Builder()
                .setTitle("word")
                .setText("Hello")
                .build()
        );

        Spec<BookDescription> spec = new AndSpec(
                new ContainsKeyInTextSpec("Hello"),
                new ContainsKeyInTitleSpec("word")
        );
        int count = storage.count(spec);

        System.out.println(count);
    }
}
