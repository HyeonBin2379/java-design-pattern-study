package example.abstractfactory.divfactory;

import example.abstractfactory.factory.Link;

public class DivLink extends Link {

    public DivLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "            <div class =\"LINK\"><a href=\"" + url + "\">" + caption + "</a></div>\n";
    }
}
