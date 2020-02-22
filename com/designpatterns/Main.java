package com.designpatterns;

import com.designpatterns.command.AddCustomerCommand;
import com.designpatterns.command.CustomerService;
import com.designpatterns.command.composite.BlackAndWhiteCommand;
import com.designpatterns.command.composite.CompositeCommand;
import com.designpatterns.command.composite.ResizeCommand;
import com.designpatterns.command.editor.BoldCommand;
import com.designpatterns.command.editor.HtmlDocument;
import com.designpatterns.command.fx.Button;
import com.designpatterns.iterator.BrowseHistory;
import com.designpatterns.mediator.ArticleDialogBox;
import com.designpatterns.memento.Editor;
import com.designpatterns.memento.History;
import com.designpatterns.observer.Chart;
import com.designpatterns.observer.DataSource;
import com.designpatterns.observer.SpreadSheet;
import com.designpatterns.state.BrushTool;
import com.designpatterns.state.Canvas;
import com.designpatterns.state.EraserTool;
import com.designpatterns.state.SelectionTool;
import com.designpatterns.strategy.*;
import com.designpatterns.template.GenerateReportTask;
import com.designpatterns.template.TransferMoneyTask;

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

        // System.out.println(editor.getContent()); // output: first state

        // State PATTERN
        var canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown(); // output: Brush icon
        canvas.mouseUp(); // output: Draw a line

        canvas.setCurrentTool(new EraserTool());
        canvas.mouseDown(); // output: Erase icon
        canvas.mouseUp(); // output: Erase content

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown(); // output: Select icon
        canvas.mouseUp(); // Draw a dashed rectangle

        // Iterator PATTERN
        var browseHistory = new BrowseHistory();
        browseHistory.push("https://google.com");
        browseHistory.push("https://gmail.com");
        browseHistory.push("https://youtube.com");

        var iterator = browseHistory.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.current());
            iterator.next();
        }

        // Strategy PATTERN
        var imageStorage = new ImageStorage();
        imageStorage.store("portrait", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStorage.store("portrait", new PngCompressor(), new BlackAndWhiteFilter());

        // Template PATTERN
        var transferMoney = new TransferMoneyTask();
        transferMoney.execute();

        var generateReport = new GenerateReportTask();
        generateReport.execute();

        // Command pattern
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();

        var composite = new CompositeCommand();
        composite.add(new BlackAndWhiteCommand());
        composite.add(new ResizeCommand());

        composite.execute();

        var document = new HtmlDocument();
        var historyCommands = new com.designpatterns.command.editor.History();
        document.setContent("TEST");

        var boldCommand = new BoldCommand(document, historyCommands);
        boldCommand.execute();
        System.out.println(document.getContent());

        boldCommand.unexecute();
        System.out.println(document.getContent());

        // Observer pattern
        var dataSource = new DataSource();
        var spread1 = new SpreadSheet(dataSource);
        var spread2 = new SpreadSheet(dataSource);
        var chart = new Chart(dataSource);

        dataSource.addObserver(spread1);
        dataSource.addObserver(spread2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);

        // Mediator pattern
        var dialog = new ArticleDialogBox();
        dialog.simulateUserInteraction();

        // using an observer

    }
}

