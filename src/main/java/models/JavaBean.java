package models;

import java.util.ArrayList;
import java.util.List;

public class JavaBean {
    private List<Entry> entryList = new ArrayList<>();

    public Entry getLastEntry() {
        return entryList.isEmpty() ? null : entryList.get(entryList.size() - 1);
    }

    public void addEntry(int x, double y, int r, boolean result) {
        this.entryList.add(entryList.size(), new Entry(x, y, r, result));
    }

    public String makeTable(){
        StringBuilder sb = new StringBuilder("<table class=\"table table-hover table-dark\"><thead><tr><th>X</th><th>Y</th><th>R</th><th>Результат</th></tr></thead>");
        for (Entry entry: entryList) {
            sb.append("<tbody><tr>");
            sb.append("<th>").append(entry.getX()).append("</th>");
            sb.append("<th>").append(entry.getY()).append("</th>");
            sb.append("<th>").append(entry.getR()).append("</th>");
            sb.append("<th>").append(entry.isResult()).append("</th>");
            sb.append("</tr></tbody>");
        }
        sb.append("</table>");

        return sb.toString();
    }
}
