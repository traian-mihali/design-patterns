package com.designpatterns.command.editor;

public interface UndoableCommand extends Command {
    void unexecute();
}
