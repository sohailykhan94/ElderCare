package ge.eldercare;

/**
 * Created by Tejas on 19-Apr-16.
 */
public class LogEntry {
    String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String content;

    LogEntry(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
