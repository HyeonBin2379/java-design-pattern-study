package example.abstractfactory.divfactory;

import example.abstractfactory.factory.Factory;
import example.abstractfactory.factory.Link;
import example.abstractfactory.factory.Page;
import example.abstractfactory.factory.Tray;

public class DivFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new DivLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new DivTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new DivPage(title, author);
    }
}
