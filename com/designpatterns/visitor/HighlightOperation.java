package com.designpatterns.visitor;

public class HighlightOperation implements Operation {
    @Override
    public void apply(HeadingNode headingNode) {
        System.out.println("highligh-heading");
    }

    @Override
    public void apply(AnchorNode anchorNode) {
        System.out.println("highlight-anchor");
    }
}
