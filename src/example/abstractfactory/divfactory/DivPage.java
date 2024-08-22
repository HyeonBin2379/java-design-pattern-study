package example.abstractfactory.divfactory;

import example.abstractfactory.factory.Item;
import example.abstractfactory.factory.Page;

public class DivPage extends Page {

    public DivPage(String title, String author) {
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
        sb.append("        <style>\n");
        sb.append("            div.TRAY { padding:0.5em; margin-left:0.5em; border:1px solid black; }\n");
        sb.append("            div.LINK { padding:0.5em; background-color:lightgray; }\n");
        sb.append("        </style>\n    </head>\n");
        sb.append("    <body>\n");
        sb.append("        <h1>").append(title).append("</h1>\n");
        for (Item item : content) {
            sb.append(item.makeHTML());
        }
        sb.append("        <hr><address>");
        sb.append(author);
        sb.append("</address>\n");
        sb.append("    </body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }
}
