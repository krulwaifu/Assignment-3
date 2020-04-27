package java;

import java.util.ArrayList;

public class Friend extends User {
    private static ArrayList<ArrayList> fList = new ArrayList();
    private static ArrayList<User> connectList = new ArrayList();

    public Friend(String name, String surname, String username, Password password) {
        super(name, surname, username, password);
    }
    public void addFriend(User u1, User u2){
        connectList.add(u1);
        connectList.add(u2);
        fList.add(connectList);
    }
    public void showFriends(User user){
        for(int i=0;i<fList.size();i++){
            if (fList.get(i).get(0).equals(user)){
                System.out.println(fList.get(i).get(1));
            }
        }
    }

}
