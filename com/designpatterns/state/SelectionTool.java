package com.designpatterns.state;

public class SelectionTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Select icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a dashed rectangle");
    }
}
