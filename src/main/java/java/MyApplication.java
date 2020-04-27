package java;

import java.Friend;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class    MyApplication {
    private static ArrayList<User> users;
    private Scanner sc = new Scanner(System.in);
    private User signedUser=null;
    public MyApplication() throws FileNotFoundException {
        users=new ArrayList<>();
    }
    private void addUsers() throws FileNotFoundException {
        File file =new File("C:\\Users\\super\\Downloads\\db.txt");
        Scanner fsc = new Scanner(file);
        while (fsc.hasNextInt()){
            int id = fsc.nextInt();
            String name = fsc.next();
            String surname = fsc.next();
            String username = fsc.next();
            Password password =new Password(fsc.next());
            User user = new User(id, name, surname, username, password);
            users.add(user);
        }
    }



    private void menu() {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else break;
            }
            else {
                userProfile(signedUser);
            }
        }
    }
    public String sendMesssage(String username) {
        for (User user : users) {
            if(user.getUsername().equals(username)){
                System.out.println("Enter your message");
                Scanner scM = new Scanner(System.in);
                String message = scM.next();
                return message;
            }
        }
        return "kek";
    }
    private void userProfile(User user) {
        while(true) {
            System.out.println(user.toString());
            int choice = sc.nextInt();
            System.out.println("1. send message to");
            System.out.println("2.add friend");
            System.out.println("3.show friends");
            System.out.println("4. log out");
            if (choice == 1){
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Enter username");
                String username= sc3.next();
                sendMesssage(username);
            }if (choice == 2){
                Friend friend = new Friend(user.getName(),user.getSurname(),user.getUsername(),user.getPassword());
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Enter username");
                String user2= sc3.next();
                for (User user1:users) {
                    if (user.getUsername().equals(user2)){
                        friend.addFriend(user,user1);
                    }
                }
            }if (choice==3){
                Friend friend = new Friend(user.getName(),user.getSurname(),user.getUsername(),user.getPassword());
                friend.showFriends(user);
            }
            if (choice == 4) {logOff();}
            else break;
        }

    }

    private void logOff() {
        signedUser = null;
        menu();
    }

    private void authentication() {
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Registration");
            System.out.println("3. Back");
            int choice = sc.nextInt();
            if (choice == 1) logIn();
            else if(choice == 2) registrate();
            else break;
        }
        menu();
    }


    private void logIn() {
        Scanner sc2=new Scanner(System.in);
        System.out.println("Enter username");
        String username = sc2.next();
        System.out.println("Enter password");
        Password password = new Password(sc2.next());
        for (User user : users){
            if(user.getUsername().equals(username)){
                if (checkPassword(password,user)){
                    this.signedUser = user;
                    menu();
                }
                else{
                    System.out.println("Error: incorrect username or password");
                }
                return;
            }
        }
        System.out.println("There is no such user with this username");
    }

    private void registrate() {
        Scanner sc1=new Scanner(System.in);
        System.out.println("New user creation");
        System.out.println("Enter name:");
        String name =sc1.next();
        System.out.println("Enter surname");
        String surname = sc1.next();
        System.out.println("Enter username");
        String username = sc1.next();
        System.out.println("Enter password");
        Password password = new Password(sc1.next());
        while (checkUsername(username)){
            System.out.println("This username is already in use, please enter another user name");
            username=sc1.next();
        }
        User newUser = new User(name,surname,username,password);
        System.out.println("do you want to login immediately?");
        System.out.println("1-Yes 2-NO");
        int choice = sc.nextInt();
        if (choice == 1) logIn();
        else if(choice == 2) {
            logOff();
        }
    }

    public static boolean checkUsername(String username) {
        for (User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkPassword(Password password, User user) {
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    public void start() throws IOException {
        // fill userlist from db.txt
        addUsers();
        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }
        // save the userlist to db.txt
        saveUserList();
    }

    private void saveUserList() throws IOException {
        String dblist="";
        for (User user : users){
            dblist+=user.getId()+" "+user.getName()+" "+user.getSurname()+
                    " "+user.getUsername()+" "+user.getPassword()+"\n";
        }
        Files.write(Paths.get("C:\\Users\\super\\Downloads\\db.txt"), dblist.getBytes());
    }
}
