package com.gmail.soora1012.Novel.Item;

public class NovelItem {
    private int id;
    private String title;
    private String context;
    private String date;
    private String image;
    private int last_continue;
    private int view;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLast_continue() {
        return last_continue;
    }

    public void setLast_continue(int last_continue) {
        this.last_continue = last_continue;
    }


    @Override
    public String toString() {
        return "NovelItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", view=" + view +
                ", last_continue=" + last_continue +
                '}';
    }

}
