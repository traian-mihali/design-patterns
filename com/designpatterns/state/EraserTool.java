package com.designpatterns.state;

public class EraserTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Erase icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Erase content");
    }
}
