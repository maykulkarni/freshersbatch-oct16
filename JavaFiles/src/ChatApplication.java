import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class ChatApplication {
    static Map<Integer, Set> chatRoomUserMap = new HashMap<>();

    static Set<ChatRoom> chatRoomSet = new HashSet<>();
    static Set<User> userSet = new HashSet<>();

    public static int getChatRoomUIDByName(String name) {
        for (ChatRoom rooms : chatRoomSet) {
            if (rooms.getChatRoomName().equals(name)) {
                return rooms.getChatRoomId();
            }
        }
        System.out.println("Something went wrong");
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int option;
        Scanner in = new Scanner(System.in);
        printMenu();
        User superUser = null;

        while ((option = in.nextInt()) != 10) {
            in.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter chatroom name");
                    String newRoomName = in.nextLine();
                    ChatRoom newRoom = new ChatRoom(newRoomName);
                    chatRoomSet.add(newRoom);
                    System.out.println("Chat room " + newRoomName + " created");
                    break;

                case 2:
                    System.out.println("Enter UserName");
                    String name = in.next();
                    System.out.println("Enter password");
                    String pass = in.next();
                    in.nextLine();
                    System.out.println("Enter chat room name");
                    String chatRoomName = in.nextLine();
                    int chatRoomId = getChatRoomUIDByName(chatRoomName);
                    User currentUser = new User(name, pass, chatRoomId);
                    userSet.add(currentUser);

                    if (chatRoomUserMap.containsKey(chatRoomId)) {
                        Set<User> userSet1 = chatRoomUserMap.get(chatRoomId);
                        userSet1.add(currentUser);
                        chatRoomUserMap.put(chatRoomId, userSet1);
                    } else {
                        Set<User> userSet1 = new TreeSet<>();
                        userSet1.add(currentUser);
                        chatRoomUserMap.put(chatRoomId, userSet1);
                    }
                    System.out.println("User created : " + currentUser);

                    break;
                case 3:
                    System.out.println("Enter user name");
                    String username = in.next();
                    System.out.println("Enter password");
                    String password = in.next();
                    for (User user : userSet) {
                        if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                            System.out.println("Logged in system successfully");
                            superUser = user;
                        }
                    }
                    if (superUser == null) {
                        System.out.println("Invalid credentials, try again");
                    }
                    break;
                case 4:
                    if (superUser == null) {
                        System.out.println("You're not logged in. Login to continue");
                        break;
                    }
                    System.out.println("Enter chat room to insert message into");
                    String chatRoomNameToInsStr = in.nextLine();
                    int cuid = getChatRoomUIDByName(chatRoomNameToInsStr);
                    ChatRoom chatRoomToWriteTo = null;
                    System.out.println("Enter message");
                    java.util.Date date = new java.util.Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String message = in.nextLine();
                    for (ChatRoom rooms : chatRoomSet) {
                        if (rooms.getChatRoomId() == cuid) {
                            chatRoomToWriteTo = rooms;
                        }
                    }
                    chatRoomToWriteTo.setMessages("[" + dateFormat.format(date) + " " + superUser.getUserName() + "] ");
                    chatRoomToWriteTo.setMessages(message + "\n");
                    break;
                case 5:
                    if (superUser == null) {
                        System.out.println("Login to continue");
                        break;
                    }
                    System.out.println("Enter chat room name");
                    cuid = getChatRoomUIDByName(in.nextLine());
                    ChatRoom currentChatRoomToInsert = null;
                    for (ChatRoom rooms : chatRoomSet) {
                        if (rooms.getChatRoomId() == cuid) {
                            currentChatRoomToInsert = rooms;
                        }
                    }
                    System.out.println("*********Messages from " + currentChatRoomToInsert.getChatRoomName() + "**************");
                    System.out.println(currentChatRoomToInsert.getMessages());
                    break;
                case 6:
                    System.out.println("Enter chat room name");
                    String currChatRoomName = in.nextLine();
                    Set<User> userSets = chatRoomUserMap.get(getChatRoomUIDByName(currChatRoomName));
                    for (User user : userSets) {
                        System.out.println(user);
                    }
                    break;
                case 7:
                    System.out.println("Succesfully logged out");
                    superUser = null;
                    break;
                case 8:
                    System.out.println("Enter username");
                    username = in.next();
                    System.out.println("Enter password");
                    password = in.next();
                    for (User user : userSet) {
                        if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                            User toRemove = (User) user.clone();
                            System.out.println("Are you sure you want to delete?");
                            String choice = in.next();
                            if (choice.equals("Y")) {
                                userSet.remove(toRemove);
                                Set deleteUserSet = chatRoomUserMap.get(toRemove.getChatRoomUid());
                                deleteUserSet.remove(toRemove);
                                chatRoomUserMap.put(toRemove.getChatRoomUid(), deleteUserSet);
                                System.out.println("User " + toRemove.getUserName() + " removed sucessfully");
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("Enter chat room name");
                    String chatRoomNameToDelete = in.nextLine();
                    for (ChatRoom rooms : chatRoomSet) {
                        if (rooms.getChatRoomName().equals(chatRoomNameToDelete)) {
                            ChatRoom rooms2 = (ChatRoom) rooms.clone();
                            System.out.println("Sure to delete?");
                            String resp = in.next();
                            if (resp.equals("Y")) {
                                chatRoomSet.remove(rooms2);
                            }
                            chatRoomUserMap.remove(rooms2.getChatRoomId());
                        }
                    }

            }
            line();
            printMenu();
        }
        System.out.println(chatRoomUserMap);
    }

    private static void line() {
        System.out.println("*******************************");
    }

    private static void printMenu() {
        System.out.println("Enter options:");
        System.out.println("1. Create Chat room");
        System.out.println("2. Add User");
        System.out.println("3. User Login");
        System.out.println("4. Send Message");
        System.out.println("5. Display message from specific chatroom");
        System.out.println("6. List users belonging to specific chatroom");
        System.out.println("7. Logout");
        System.out.println("8. Delete user");
        System.out.println("9. Delete chatroom");
        System.out.println("10. Exit");
    }
}
