package ge.eldercare;

/**
 * Created by sohailyarkhan on 19/04/16.
 */
public class Chat {
    public String name;
    public String message;
    public int photoId;
    public boolean isSender;

    Chat(String name, String age, int photoId, boolean isSender) {
        this.name = name;
        this.message = age;
        this.photoId = photoId;
        this.isSender = isSender;
    }


}
