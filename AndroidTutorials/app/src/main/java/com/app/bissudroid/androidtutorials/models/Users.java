package com.app.bissudroid.androidtutorials.models;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private String name;
    private String email;
    private String phoneno;

    public Users(String name, String email, String phoneno) {
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public static List<Users> getUsers(){
        List<Users> users=new ArrayList<>();
        for(int i=0;i<100;i++){
            String name="User"+(i+1);
            String email="user@xyz.com"+(i+1);
            String phone="123456789";
            Users user=new Users(name,email,phone);
            users.add(user);

        }
        return users;
    }
}
