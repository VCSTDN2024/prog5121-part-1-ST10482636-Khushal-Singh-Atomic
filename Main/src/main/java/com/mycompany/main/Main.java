/*
Khushal Singh
ST10482636
Varsity College, Sandton
Programming Assignment A1
PROG5152
*/

package com.mycompany.main;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        // Registration
        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        /*
        Username Criteria
        
        The username has to be 5 characters long and contain an underscore
        If the username is not formatted right, then the code will repete and 
        ask to enter in the correct format
        */
        
        String username;
        while (true) 
        {
            System.out.print("Enter Username (must contain underscore and be exactly 5 characters): ");
            username = input.nextLine();
            Login tempUser = new Login(username, "", ""); // temporary to validate only username

            if (tempUser.checkUserName()) 
            {
                System.out.println("Username successfully captured.");
                break;
            } 
            
            else 
            {
                System.out.println("Username is not correctly formatted, please ensure "
                        + "that your username contains an underscore and is exactly five characters in length.");
            }
        }

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cellphone Number (e.g., +27831112233): ");
        String cellphone = input.nextLine();

        // Create Login object with valid username
        Login user = new Login(username, password, cellphone);
        System.out.println(user.registerUser());

        // Login
        System.out.print("Login - Enter Username: ");
        String loginUser = input.nextLine();

        // If username matches, enter password loop
        if (loginUser.equals(username)) 
        {
            boolean loginSuccess = false;
            while (!loginSuccess) 
            {
                System.out.print("Login - Enter Password: ");
                String loginPass = input.nextLine();

                if (user.loginUser(loginUser, loginPass)) 
                {
                    System.out.println(user.returnLoginStatus(loginUser, loginPass, firstName, lastName));
                    loginSuccess = true;
                } 
                
                else 
                {
                    System.out.println("Password incorrect, please try again.");
                }
            }
        } else {
            System.out.println("Username incorrect, please try again.");
        }

        input.close();
    }
}
