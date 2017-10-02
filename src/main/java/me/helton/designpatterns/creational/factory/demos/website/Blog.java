package me.helton.designpatterns.creational.factory.demos.website;

public class Blog extends Website {
    @Override
    public void createWebsite() {
       pages.add(new PostPage());
       pages.add(new AboutPage());
       pages.add(new CommentPage());
       pages.add(new ContactPage());
    }
}
