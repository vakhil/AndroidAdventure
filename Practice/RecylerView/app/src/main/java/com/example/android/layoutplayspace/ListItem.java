package com.example.android.layoutplayspace;

public class ListItem {
    private String head;
    private String Description;
    public ListItem(String head, String Desciption)
    {   this.head = head;
        this.Description = Desciption;
    }

    public String getHead() {
        return head;
    }

    public String getDescription() {
        return Description;
    }
}
