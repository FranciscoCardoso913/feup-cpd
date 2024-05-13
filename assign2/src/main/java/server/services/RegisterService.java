package server.services;

import server.database.Database;
import server.database.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterService {
    private Database db;
    public RegisterService(Database db){
        this.db = db;
    }
    public String registerUser (PrintWriter out, BufferedReader in) throws IOException {
        String username = "";
        while (true) {
            out.println("Insert your username:");
            username = in.readLine();
            if(db.findUserByName(username) != null) out.println("Username already taken");
            else break;
        }
        out.println("Insert your password:");
        String pass = in.readLine();
        db.register(new User(username, pass,0));
        return "Register done with success";
    }
}
