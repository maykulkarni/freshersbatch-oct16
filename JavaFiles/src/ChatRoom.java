import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kulkarni_my on 10/26/2016.
 */

public class ChatRoom implements Cloneable {
    private int chatRoomId = 0;
    private List<String> messages;
    private String chatRoomName;

    public ChatRoom(String chatRoomName) {
        this.chatRoomName = chatRoomName;
        this.chatRoomId = new Random().nextInt(1000);
        messages = new ArrayList<String>();
    }

    @Override
    public int hashCode() {
        return this.chatRoomId;
    }

    @Override
    public boolean equals(Object obj) {
        return this.chatRoomId == ((ChatRoom) obj).chatRoomId;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "messages='" + messages + '\'' +
                ", chatRoomName='" + chatRoomName + '\'' +
                ", chatRoomId=" + chatRoomId +
                '}';
    }

    public String getMessages() {
        return messages.toString();
    }

    public void setMessages(String messages) {
        this.messages.add(messages);
    }

    public int getChatRoomId() {
        return chatRoomId;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
