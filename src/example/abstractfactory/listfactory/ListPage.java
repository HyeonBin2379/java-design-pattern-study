package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Item;
import example.abstractfactory.factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>\n");
        sb.append("    <head>\n");
        sb.append("        <meta charset=\"UTF-8\">\n");
        sb.append("        <title>").append(title).append("</title>\n");
        sb.append("    </head>\n");
        sb.append("    <body>\n");
        sb.append("        <h1>").append(title).append("</h1>\n");
        sb.append("        <ul>\n");
        for (Item item : content) {
            sb.append(item.makeHTML());
        }
        sb.append("        </ul>\n");
        sb.append("        <hr><address>");
        sb.append(author);
        sb.append("</address>\n");
        sb.append("    </body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }
}
