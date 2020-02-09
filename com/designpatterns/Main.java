package com.designpatterns;

import com.designpatterns.memento.Editor;
import com.designpatterns.memento.History;

public class Main {

    public static void main(String[] args) {
        // Memento PATTERN
        var editor = new Editor();
        var history = new History();

        editor.setContent("first state");
        history.push(editor.createState());

        editor.setContent("second state");
        history.push(editor.createState());

        editor.setContent("third state");

        editor.restoreState(history.pop());
        editor.restoreState(history.pop());

        System.out.println(editor.getContent()); // output: first state
    }
}

