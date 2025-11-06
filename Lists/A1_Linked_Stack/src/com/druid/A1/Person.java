package com.druid.A1;

public class Person {
    int num_of_logins;
    String username;
    String email;

    public Person(String username, String email) {
        this.num_of_logins = 0;
        this.username = username;
        this.email = email;
    }

    public void login() {
        this.num_of_logins += 1;
    }

    public void displayPerson() {
        System.out.print("Logins: " + this.num_of_logins + ", ");
        System.out.print("Username: " + this.username + ", ");
        System.out.print("Email: " + this.email + " \n");
    }
    
}
