import java.util.Random;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class User implements Cloneable {
    private String userName;
    private String password;
    private int uid;
    private int chatRoomUid;

    public User(String userName, String password, int chatRoomUid) {
        this.userName = userName;
        this.password = password;
        this.uid = new Random().nextInt(1000);
        this.chatRoomUid = chatRoomUid;
    }

    public int getChatRoomUid() {
        return chatRoomUid;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getUid() == ((User) obj).getUid();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return this.getUid();
    }

    @Override

    public String toString() {
        return "User [ " +
                "userName = '" + userName + " " +
                ", uid = " + uid +
                " ]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

}
