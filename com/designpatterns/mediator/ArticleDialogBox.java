package com.designpatterns.mediator;

// public class ArticleDialogBox extends DialogBox
public class ArticleDialogBox{
    private ListBox articleListBox = new ListBox();
    private TextBox titleTextBox = new TextBox();
    private Button saveButton = new Button();

    public ArticleDialogBox (){
        // Anonymous inner class
        // articleListBox.addEventHandler(new Observer() {
        //    @Override
        //    public void update() {
        //        articleSelected();
        //    }
        // });

        // lambda expression
        // articleListBox.addEventHandler(() -> articleSelected());

        // method reference
        articleListBox.addEventHandler(this::articleSelected);
        titleTextBox.addEventHandler(this::titleChanged);
    }

    public void simulateUserInteraction() {
        articleListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        titleTextBox.setContent("Article 2");
        System.out.println("TextBox: " + titleTextBox.getContent());
        System.out.println("Button: " + saveButton.getEnabled());
    }

    // @Override
    // public void changed(UIControl uiControl) {
    //    if (uiControl == articleListBox) {
    //        articleSelected();
    //    } else if (uiControl == titleTextBox) {
    //        titleChanged();
    //    }
    // }

    private void titleChanged() {
        var content = titleTextBox.getContent();
        var isEmpty = content == null || content.isEmpty();
        saveButton.setEnabled(!isEmpty);
    }

    private void articleSelected() {
        titleTextBox.setContent(articleListBox.getSelection());
        saveButton.setEnabled(true);
    }
}
