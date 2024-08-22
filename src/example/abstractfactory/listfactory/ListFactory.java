package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Factory;
import example.abstractfactory.factory.Link;
import example.abstractfactory.factory.Page;
import example.abstractfactory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
