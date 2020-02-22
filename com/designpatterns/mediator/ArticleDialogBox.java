package com.designpatterns.mediator;

public class ArticleDialogBox extends DialogBox {
    private ListBox articleListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveButton = new Button(this);

    public void simulateUserInteraction() {
        articleListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        System.out.println("TextBox: " + titleTextBox.getContent());
        System.out.println("Button: " + saveButton.getEnabled());
    }

    @Override
    public void changed(UIControl uiControl) {
        if (uiControl == articleListBox) {
            articleSelected();
        } else if (uiControl == titleTextBox) {
            titleChanged();
        }
    }

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
