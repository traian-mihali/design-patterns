package com.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    // protected DialogBox owner;
    private List<EventHandler> eventHandlers = new ArrayList<>();

    // public UIControl(DialogBox owner) {
    //    this.owner = owner;
    // }

    public void addEventHandler(EventHandler handler) {
        eventHandlers.add(handler);
    }

    protected void notifyEventHandlers() {
        for (var handler : eventHandlers)
            handler.handle();
    }

}
