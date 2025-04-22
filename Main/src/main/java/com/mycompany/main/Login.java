package com.mycompany.main;

public class Login 
{
    private final String username;
    private final String password;
    private final String cellphone;

    public Login(String username, String password, String cellphone) 
    {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }

    public boolean checkUserName() 
    {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() 
    {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public boolean checkCellPhoneNumber() 
    {
        return cellphone.matches("\\+27\\d{9}");
    }

    public String registerUser() 
    {
        if (!checkUserName()) 
        {
            return "Username is not correctly formatted, please ensure that"
                    + " your username contains an underscore and is no more "
                    + "than five characters in length.";
        }
        
        if (!checkPasswordComplexity()) 
        {
            return "Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, a "
                    + "capital letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber()) 
        {
            return "Cellphone number incorrectly formatted or does not contain"
                    + " international code.";
        }
        
        return "User successfully registered.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) 
    {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword, String firstName, String lastName) 
    {
        if (loginUser(enteredUsername, enteredPassword)) 
        {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } 
        
        else 
        {
            return "Username or password incorrect, please try again.";
        }
    }
}
