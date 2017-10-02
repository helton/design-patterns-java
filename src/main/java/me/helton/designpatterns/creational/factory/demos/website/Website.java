package me.helton.designpatterns.creational.factory.demos.website;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {
    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public List<Page> getPages() {
        return this.pages;
    }

    public abstract void createWebsite();
}
