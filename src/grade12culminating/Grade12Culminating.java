/** 
* Project: Grade12Culminating
* Programmer: Taha Hashim 
* Date: January 21, 2022
* Program: Grade12Culminating.java 
* Description: Taha Hashim's final culminating project
*/ 
package grade12culminating;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Grade12Culminating 
{

    public static void main(String[] args) 
    {
        //decimal format for 2 decimal places
        DecimalFormat twoDigit = new DecimalFormat("0.00");
              
        //object for Transactions class and User class
        Transactions myTransactions = new Transactions();
        User myUser = new User();
        
        //uses graphics to ask the user to enter their ID and PIN
        JFrame frame1 = new JFrame("login");
        JLabel mainLabel = new JLabel("Please enter your Personal ID Number.");
        JLabel mainLabel1 = new JLabel("Please enter your PIN.");
        JTextField txtField = new JTextField("Type here");
        JTextField txtField1 = new JTextField("Type here");
        JButton button = new JButton("LOGIN");
        JLabel Label = new JLabel();
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setSize(600,450);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainLabel.setBounds(125, 50, 400, 50);
        mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
        mainLabel.setForeground(Color.GREEN);
        frame1.add(mainLabel);
        txtField.setBounds(185, 100, 200, 25);
        frame1.add(txtField);
        mainLabel1.setBounds(185, 140, 400, 50);
        mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
        mainLabel1.setForeground(Color.GREEN);
        frame1.add(mainLabel1);
        txtField1.setBounds(185, 180, 200, 25);
        frame1.add(txtField1);
        button.setBounds(185, 230, 200, 25);
        frame1.add(button);
        
        //creates file object to read the id and pin files, declares scanner object, and initializes string variable
        File nf = new File("ID.txt");
        Scanner scanS;
        File nf1 = new File("PIN.txt");
        Scanner scanS1;
        String line1 = "";
        
        //creates an ArrayList that stores String objects
        ArrayList <String> idList = new ArrayList <>();
        try
        {
            //connects scanner to its file
            scanS = new Scanner(nf);
            
            //obtains last line of input from ID file and prints users ID'S
            while(scanS.hasNext())
            {
                idList.add(scanS.nextLine());
            }
            System.out.println("ID's: " + idList);
            
            //connects scanner to its file
            scanS1 = new Scanner(nf1);
            
            //obtains last line of input from PIN file and prints users pin
            while(scanS1.hasNext())
            {
                line1 = scanS1.nextLine();
            }
            System.out.println("Password: " + line1);
            
            //closes scanners
            scanS.close();
            scanS1.close();
        }
        catch(IOException e)
        {
            //prints an error message
            System.out.println("File error: " + e.getMessage());
        }
        
        //if user clicks LOGIN
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //store the ID the user enters into a string variable, then converts it to an integer
                String userIDD =(txtField.getText());
                int userID = Integer.parseInt((userIDD));
                
                //store the PIN the user enters into a string variable, then converts it to an integer
                String userPINN = (txtField1.getText());
                int userPIN = Integer.parseInt((userPINN));
                
                //creates File object, declare scanner object and String variable
                File nf = new File("PIN.txt");
                Scanner scanSF;
                String line;
                
                File nf1 = new File("ID.txt");
                Scanner scanSF1;
                ArrayList <Integer> idList = new ArrayList <>();
                
                //exception handler
                try
                {
                    //connects Scanner to File and obtains first line of input
                    scanSF = new Scanner(nf);
                    line = scanSF.nextLine();
                    
                    //obtains last line of input and convets it to an integer
                    while(scanSF.hasNext())
                    {
                        line = scanSF.nextLine();
                    }
                    int line1 = Integer.parseInt((line));
                    
                    scanSF1 = new Scanner(nf1);
                    while(scanSF1.hasNext())
                    {
                        idList.add(scanSF1.nextInt());
                    }
                  
                    //if user enters correct ID and PIN
                    if(idList.contains(userID) && userPIN == line1)
                    {
                        myUser.setPin(userPIN);
                        
                        //uses graphics to display menu options
                        JFrame frame2 = new JFrame("textfield");
                        JLabel mainLabel2 = new JLabel("Please select a transaction.");
                        JButton button1 = new JButton("Account Info");
                        JButton button2 = new JButton("ATM Locations & Transfers");
                        JButton button3 = new JButton("Change PIN");
                        JButton button4 = new JButton("Cash Withdrawal");
                        JButton button5 = new JButton("Deposit");
                        JButton button6 = new JButton("Exit");
                        frame2.setLayout(null);
                        frame2.setVisible(true);
                        frame2.setSize(600,450);
                        frame2.setResizable(false);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        mainLabel2.setBounds(185, 35, 400, 50);
                        mainLabel2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                        mainLabel2.setForeground(Color.GREEN);
                        frame2.add(mainLabel2);
                        button1.setBounds(0, 100, 250, 50);
                        frame2.add(button1);
                        button2.setBounds(0, 200, 250, 50);
                        frame2.add(button2);
                        button3.setBounds(0, 300, 250, 50);
                        frame2.add(button3);
                        button4.setBounds(350, 100, 250, 50);
                        frame2.add(button4);
                        button5.setBounds(350, 200, 250, 50);
                        frame2.add(button5);
                        button6.setBounds(350, 300, 250, 50);
                        frame2.add(button6);
                        
                        //if user clicks "Account Info"
                        button1.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //uses graphics to display menu options
                                JFrame frame3 = new JFrame("accountinfo");
                                JLabel mainLabel2 = new JLabel("Please select a transaction");
                                JButton button7 = new JButton("Total Balances");
                                JButton button8 = new JButton("Credit Card Balance");
                                JButton button9 = new JButton("Cancel");
                                JButton button10 = new JButton("Chequing Balance");
                                JButton button11 = new JButton("Savings Balance");
                                frame3.setLayout(null);
                                frame3.setVisible(true);
                                frame3.setSize(600,450);
                                frame3.setResizable(false);
                                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainLabel2.setBounds(185, 35, 400, 50);
                                mainLabel2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                mainLabel2.setForeground(Color.GREEN);
                                frame3.add(mainLabel2);
                                button7.setBounds(0, 100, 250, 50);
                                frame3.add(button7);
                                button8.setBounds(0, 200, 250, 50);
                                frame3.add(button8);
                                button9.setBounds(0, 300, 250, 50);
                                frame3.add(button9);
                                button10.setBounds(350, 100, 250, 50);
                                frame3.add(button10);
                                button11.setBounds(350, 200, 250, 50);
                                frame3.add(button11);

                                //if user clicks "Total Balances"
                                button7.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {   
                                        //creates file object to read total balance, declares scanner object, and initializes string variable
                                        File nf = new File("totalBalance.txt");
                                        Scanner scanS;
                                        String line = "";
                                        //exception handler
                                        try
                                        {
                                            //connects scanners to their files
                                            scanS = new Scanner(nf);
                                            
                                            //obtains last line of input from all balance files
                                            while(scanS.hasNext())
                                            {
                                                line = scanS.nextLine();
                                            }
                                            //closes scanner
                                            scanS.close();
                                        }
                                        catch(IOException k)
                                        {
                                            //prints an error message
                                            System.out.println("File error" + k.getMessage());
                                        }
                                        
                                        //uses graphics to display total balances
                                        JFrame frame = new JFrame("totalbalances");
                                        JLabel Label = new JLabel("Total Balance: " + Double.toString(Double.parseDouble(line) + myTransactions.getChequingBalance() + myTransactions.getSavingsBalance() + myTransactions.getCreditCardBalance()));
                                        JButton button = new JButton("Back");
                                        frame.setLayout(null);
                                        frame.setVisible(true);
                                        frame.setSize(600,450);
                                        frame.setResizable(false);
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        Label.setBounds(185, 35, 400, 50);
                                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label.setForeground(Color.GREEN);
                                        frame.add(Label);
                                        button.setBounds(150, 250, 250, 50);
                                        frame.add(button);

                                        //if user clicks "Back"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes totalbalances window
                                                frame.dispose();
                                            }
                                         });
                                    }
                                });
                                //if user clicks "Credit Card Balance"
                                button8.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                        File nf = new File("CreditCardBalance.txt");
                                        Scanner scanS;
                                        String line = "";

                                        //exception handler
                                        try
                                        {
                                            //connects scanner to the file and obtains last line of input from file
                                            scanS = new Scanner(nf);
                                            while(scanS.hasNext())
                                            {
                                                line = scanS.nextLine();
                                            }
                                            //closes scanner
                                            scanS.close();
                                        }
                                        catch(IOException k)
                                        {
                                            //prints an error message
                                            System.out.println("File error" + k.getMessage());
                                        }
                                        //uses graphics to display total credit card balance
                                        JFrame frame = new JFrame("creditcardbalance");
                                        JLabel Label = new JLabel("Total Balance: " + Double.toString(Double.parseDouble(line) + myTransactions.getCreditCardBalance()));
                                        JButton button = new JButton("Back");
                                        frame.setLayout(null);
                                        frame.setVisible(true);
                                        frame.setSize(600,450);
                                        frame.setResizable(false);
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        Label.setBounds(185, 35, 400, 50);
                                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label.setForeground(Color.GREEN);
                                        frame.add(Label);
                                        button.setBounds(150, 250, 250, 50);
                                        frame.add(button);

                                        //if user clicks "Back"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes creditcardbalance window
                                                frame.dispose();
                                            }
                                         });
                                    }
                                });
                                
                                //if user clicks cancel
                                button9.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //closes accountinfo window
                                        frame3.dispose();
                                    }
                                });
                                
                                //if user clicks "Chequing Balance"
                                button10.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //creates file object to read chequing balance, declaring scanner object, and initializes string variable
                                        File nf = new File("ChequingBalance.txt");
                                        Scanner scanS;
                                        String line = "";

                                        //exceptiom handler
                                        try
                                        {
                                            //connects scanner to the file and obtains last line of input from file
                                            scanS = new Scanner(nf);
                                            while(scanS.hasNext())
                                            {
                                                line = scanS.nextLine();
                                            }
                                            //closes scanner
                                            scanS.close();
                                        }
                                        catch(IOException k)
                                        {
                                            //prints an error message
                                            System.out.println("File error" + k.getMessage());
                                        }

                                        //uses graphics to display total chequing balance
                                        JFrame frame = new JFrame("chequingbalance");
                                        JLabel Label = new JLabel("Total Balance: " + Double.toString(Double.parseDouble(line) + myTransactions.getChequingBalance()));
                                        JButton button = new JButton("Back");
                                        frame.setLayout(null);
                                        frame.setVisible(true);
                                        frame.setSize(600,450);
                                        frame.setResizable(false);
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        Label.setBounds(185, 35, 400, 50);
                                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label.setForeground(Color.GREEN);
                                        frame.add(Label);
                                        button.setBounds(150, 250, 250, 50);
                                        frame.add(button);

                                        //if user clicks "Back"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes chequingbalance window
                                                frame.dispose();
                                            }
                                         });
                                    }
                                });
                                
                                //if user clicks "Savings Balance"
                                button11.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //creates file object to read savings balance, declaring scanner object, and initializes string variable
                                        File nf = new File("SavingsBalance.txt");
                                        Scanner scanS;
                                        String line = "";

                                        //exception handler
                                        try
                                        {
                                            //connects scanner to the file and obtains last line of input from file
                                            scanS = new Scanner(nf);
                                            while(scanS.hasNext())
                                            {
                                                line = scanS.nextLine();
                                            }
                                            //closes scanner
                                            scanS.close();
                                        }
                                        catch(IOException k)
                                        {
                                            //prints an error message
                                            System.out.println("File error" + k.getMessage());
                                        }

                                        //uses graphics to displace total savings balance
                                        JFrame frame = new JFrame("savingsbalance");
                                        JLabel Label = new JLabel("Total Balance: " + Double.toString(Double.parseDouble(line) + myTransactions.getSavingsBalance()));
                                        JButton button = new JButton("Back");                                               
                                        frame.setLayout(null);
                                        frame.setVisible(true);
                                        frame.setSize(600,450);
                                        frame.setResizable(false);
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        Label.setBounds(185, 35, 400, 50);
                                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label.setForeground(Color.GREEN);
                                        frame.add(Label);                                              
                                        button.setBounds(150, 250, 250, 50);
                                        frame.add(button);

                                        //if user clicks "Back"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes savingsbalance window
                                                frame.dispose();
                                            }
                                         });
                                    }
                                });
                            } 
                        });
                        
                        //if user clicks "ATM Locations & Transfers"
                        button2.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //uses graphics to display menu options
                                JFrame frame8 = new JFrame("atmlocations&transfer");
                                JLabel mainLabel7 = new JLabel("Please select a transaction.");
                                JButton button27 = new JButton("ATM Locations");
                                JButton button28 = new JButton("Transfer");
                                JButton button29 = new JButton("Cancel");
                                frame8.setLayout(null);
                                frame8.setVisible(true);
                                frame8.setSize(600,450);
                                frame8.setResizable(false);
                                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainLabel7.setBounds(185, 35, 400, 50);
                                mainLabel7.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                mainLabel7.setForeground(Color.GREEN);
                                frame8.add(mainLabel7);
                                button27.setBounds(0, 100, 250, 50);
                                frame8.add(button27);
                                button28.setBounds(0, 200, 250, 50);
                                frame8.add(button28);
                                button29.setBounds(0, 300, 250, 50);
                                frame8.add(button29);

                                //if user clicks "ATM Locations"
                                button27.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //inititalizes String array with nearby atm locations
                                        String[] locations = {"Bronte ST S", "Kennedy Circle", "Derry RD", "Main ST E", "Dundas ST W", "Westoak Trails BLVD", "Upper Middle RD W"};
                                        
                                        String result;
                                        result = atm(locations);
                                        
                                        //calls the sort string exhcance method
                                        sortStringExchange(locations);
                                       
                                        //declares blank string variable
                                        String print = " ";
                                        
                                        //concantenates each value to print the variable each time
                                        for(int k = 0; k < locations.length; k++)
                                        {
                                            print = print + locations[k] + " ";
                                        }
                                        
                                        //uses graphics to display atm locations info
                                        JFrame frame = new JFrame("atmlocations");
                                        JLabel Label = new JLabel("You are currently at the " + locations[0] + " location.");
                                        JLabel Label1 = new JLabel("There are 7 locations within 10 km of you: ");
                                        JLabel Label2 = new JLabel(print);
                                        JLabel Label3 = new JLabel(result);
                                        JButton button = new JButton("Cancel");
                                        frame.setLayout(null);
                                        frame.setVisible(true);
                                        frame.setSize(1000,450);
                                        frame.setResizable(false);
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        Label.setBounds(270, 35, 1000, 50);
                                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label.setForeground(Color.GREEN);
                                        frame.add(Label);
                                        Label1.setBounds(300, 85, 1000, 50);
                                        Label1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label1.setForeground(Color.GREEN);
                                        frame.add(Label1);
                                        Label2.setBounds(10, 115, 1000, 50);
                                        Label2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label2.setForeground(Color.GREEN);
                                        frame.add(Label2);
                                        Label3.setBounds(10, 145, 1000, 50);
                                        Label3.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        Label3.setForeground(Color.GREEN);
                                        frame.add(Label3);
                                        button.setBounds(320, 300, 250, 50);
                                        frame.add(button);
                                        
                                        //if user clicks "Cancel"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes atmlocations window
                                                frame.dispose();
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Transfer"
                                button28.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display menu options
                                        JFrame frame9 = new JFrame("transfer");
                                        JLabel mainLabel = new JLabel("Please select an account.");
                                        JButton button = new JButton("Cancel");
                                        JButton button1 = new JButton("From Chequing");
                                        JButton button2 = new JButton("From Savings");
                                        JButton button3 = new JButton("From Credit Card");
                                        frame9.setLayout(null);
                                        frame9.setVisible(true);
                                        frame9.setSize(600,450);
                                        frame9.setResizable(false);
                                        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel.setBounds(185, 35, 400, 50);
                                        mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel.setForeground(Color.GREEN);
                                        frame9.add(mainLabel);
                                        button.setBounds(0, 300, 250, 50);
                                        frame9.add(button);
                                        button1.setBounds(350, 100, 250, 50);
                                        frame9.add(button1);
                                        button2.setBounds(350, 200, 250, 50);
                                        frame9.add(button2);
                                        button3.setBounds(350, 300, 250, 50);
                                        frame9.add(button3);

                                        //if user clicks "Cancel"
                                        button.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes transfer window
                                                frame9.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "From Chequing"
                                        button1.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to display menu options
                                                JFrame frame = new JFrame("fromchequing");
                                                JLabel mainLabel = new JLabel("Please select an account.");
                                                JButton button = new JButton("Cancel");
                                                JButton button1 = new JButton("To Savings");
                                                frame.setLayout(null);
                                                frame.setVisible(true);
                                                frame.setSize(600,450);
                                                frame.setResizable(false);
                                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel.setBounds(185, 35, 400, 50);
                                                mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel.setForeground(Color.GREEN);
                                                frame.add(mainLabel);
                                                button.setBounds(0, 300, 250, 50);
                                                frame.add(button);
                                                button1.setBounds(350, 200, 250, 50);
                                                frame.add(button1);
                                               
                                                //if user clicks "Cancel"
                                                button.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes fromchequing window
                                                        frame.dispose();
                                                    }
                                                });
                                                
                                                //if user clicks "To Savings"
                                                button1.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //uses graphics to let user enter amount
                                                        JFrame frame1 = new JFrame("chequingamount");
                                                        JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                        JTextField txtField = new JTextField();
                                                        JButton button = new JButton("Ok");
                                                        JButton button1 = new JButton("Cancel");
                                                        JLabel Label = new JLabel();
                                                        frame1.setLayout(null);
                                                        frame1.setVisible(true);
                                                        frame1.setSize(600,450);
                                                        frame1.setResizable(false);
                                                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        mainLabel18.setBounds(120, 35, 400, 50);
                                                        mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel18.setForeground(Color.GREEN);
                                                        frame1.add(mainLabel18);
                                                        txtField.setBounds(185, 150, 200, 25);
                                                        frame1.add(txtField);
                                                        button.setBounds(185, 200, 200, 25);
                                                        frame1.add(button);
                                                        button1.setBounds(185, 250, 200, 25);
                                                        frame1.add(button1);
                                                        
                                                        //if user clicks "Ok"
                                                        button.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                                File nf = new File("ChequingBalance.txt");
                                                                Scanner scanS;
                                                                String line = "";
                                                                
                                                                //exception handler
                                                                try
                                                                {
                                                                    //connects scanner to the file and obtains last line of input from file
                                                                    scanS = new Scanner(nf);
                                                                    while(scanS.hasNext())
                                                                    {
                                                                        line = scanS.nextLine();
                                                                    }
                                                                    //closes scanner
                                                                    scanS.close();
                                                                }
                                                                catch(IOException k)
                                                                {
                                                                    //prints an error message
                                                                    System.out.println("File error" + k.getMessage());
                                                                }
                                                                //initialize double variables for the last line in the file, total chequing balance, and transfer amount
                                                                double linee = Double.parseDouble(line);
                                                                double chequingTotal = linee + myTransactions.getChequingBalance();
                                                                double transferAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                                //if total chequing balance is greater than or equal to transfer amount, and transfer amount is not 0
                                                                if(chequingTotal >= transferAmount && transferAmount > 0)
                                                                {
                                                                    //calculates the new chequing and savings balance running in the program
                                                                    myTransactions.chequingWithdraw(transferAmount);
                                                                    myTransactions.savingsDeposit(transferAmount);
                                                                    
                                                                    //uses graphics to display restart option
                                                                    JFrame frame2 = new JFrame("restart");
                                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                                    JButton button = new JButton("Yes");
                                                                    JButton button1 = new JButton("No");
                                                                    frame2.setLayout(null);
                                                                    frame2.setVisible(true);
                                                                    frame2.setSize(600,450);
                                                                    frame2.setResizable(false);
                                                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel);
                                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel1.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel1);
                                                                    button.setBounds(185, 230, 200, 25);
                                                                    frame2.add(button);
                                                                    button1.setBounds(185, 310, 200, 25);
                                                                    frame2.add(button1);

                                                                    //if user clicks "Yes"
                                                                    button.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes restart, chequingamount, fromchequing, transfer, and atmlocations&transfer window
                                                                            frame2.dispose();
                                                                            frame1.dispose();
                                                                            frame.dispose();
                                                                            frame9.dispose();
                                                                            frame8.dispose();
                                                                        }
                                                                    });
                                                                    
                                                                    //if user clicks "No"
                                                                    button1.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes program
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                                                }
                                                                //otherwise if total chequing balance is not greater than or equal to transfer amount, and transfer amount is 0
                                                                else
                                                                {
                                                                    //using graphics to display error message
                                                                    Label.setText("Insufficient Funds.");
                                                                    Label.setBounds(215, 300, 400, 50);
                                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    Label.setForeground(Color.RED);
                                                                    frame1.add(Label);
                                                                }
                                                            }
                                                        });
                                                        
                                                        //if user clicks "Cancel"
                                                        button1.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes chequingamount window
                                                                frame1.dispose();
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                        
                                        //if user clicks "From Savings"
                                        button2.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to display menu options
                                                JFrame frame = new JFrame("fromsavings");
                                                JLabel mainLabel = new JLabel("Please select an account.");
                                                JButton button = new JButton("Cancel");
                                                JButton button1 = new JButton("To Chequing");
                                                frame.setLayout(null);
                                                frame.setVisible(true);
                                                frame.setSize(600,450);
                                                frame.setResizable(false);
                                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel.setBounds(185, 35, 400, 50);
                                                mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel.setForeground(Color.GREEN);
                                                frame.add(mainLabel);
                                                button.setBounds(0, 300, 250, 50);
                                                frame.add(button);
                                                button1.setBounds(350, 200, 250, 50);
                                                frame.add(button1);
                                                  
                                                //if user clicks "Cancel"
                                                button.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes fromsavings window
                                                        frame.dispose();
                                                    }
                                                });
                                                
                                                //if user clicks "To Chequing"
                                                button1.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //uses graphics to let user enter amount
                                                        JFrame frame1 = new JFrame("tochequing");
                                                        JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                        JTextField txtField = new JTextField();
                                                        JButton button = new JButton("Ok");
                                                        JButton button1 = new JButton("Cancel");
                                                        JLabel Label = new JLabel();
                                                        frame1.setLayout(null);
                                                        frame1.setVisible(true);
                                                        frame1.setSize(600,450);
                                                        frame1.setResizable(false);
                                                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        mainLabel18.setBounds(120, 35, 400, 50);
                                                        mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel18.setForeground(Color.GREEN);
                                                        frame1.add(mainLabel18);
                                                        txtField.setBounds(185, 150, 200, 25);
                                                        frame1.add(txtField);
                                                        button.setBounds(185, 200, 200, 25);
                                                        frame1.add(button);
                                                        button1.setBounds(185, 250, 200, 25);
                                                        frame1.add(button1);
                                                        
                                                        //if user clicks "Ok"
                                                        button.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                                File nf = new File("SavingsBalance.txt");
                                                                Scanner scanS;
                                                                String line = "";
                                                                
                                                                //exception handler
                                                                try
                                                                {
                                                                    //connects scanner to the file and obtains last line of input from file
                                                                    scanS = new Scanner(nf);
                                                                    while(scanS.hasNext())
                                                                    {
                                                                        line = scanS.nextLine();
                                                                    }
                                                                    //closes scanner
                                                                    scanS.close();
                                                                }
                                                                catch(IOException k)
                                                                {
                                                                    //prints an error 
                                                                    System.out.println("File error" + k.getMessage());
                                                                }
                                                                //initialize double variables for the last line in the file, total savings balance, and transfer amount
                                                                double linee = Double.parseDouble(line);
                                                                double savingsTotal = linee + myTransactions.getSavingsBalance();
                                                                double transferAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                                //if the total savings balance is greater than or equal the transfer amount and transfer amount is greater than 0
                                                                if(savingsTotal >= transferAmount && transferAmount > 0)
                                                                {
                                                                    //calculates the new savings and chequing balance running in the program
                                                                    myTransactions.savingsWithdraw(transferAmount);
                                                                    myTransactions.chequingDeposit(transferAmount);
                                                                    
                                                                    //uses graphics to display restart option
                                                                    JFrame frame2 = new JFrame("restart");
                                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                                    JButton button = new JButton("Yes");
                                                                    JButton button1 = new JButton("No");
                                                                    frame2.setLayout(null);
                                                                    frame2.setVisible(true);
                                                                    frame2.setSize(600,450);
                                                                    frame2.setResizable(false);
                                                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel);
                                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel1.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel1);
                                                                    button.setBounds(185, 230, 200, 25);
                                                                    frame2.add(button);
                                                                    button1.setBounds(185, 310, 200, 25);
                                                                    frame2.add(button1);

                                                                    //if user clicks "Yes"
                                                                    button.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes restart, tochequing, fromsavings, transfer, atmlocations&transfer window
                                                                            frame2.dispose();
                                                                            frame1.dispose();
                                                                            frame.dispose();
                                                                            frame9.dispose();
                                                                            frame8.dispose();
                                                                        }
                                                                    });
                                                                    
                                                                    //if user clicks "No" 
                                                                    button1.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes program
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                                                }
                                                                else
                                                                {
                                                                    //prints an error message
                                                                    Label.setText("Insufficient Funds.");
                                                                    Label.setBounds(215, 300, 400, 50);
                                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    Label.setForeground(Color.RED);
                                                                    frame.add(Label);
                                                                }
                                                            }
                                                        });
                                                        
                                                        //if user clicks "Cancel"
                                                        button1.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes tochquing window
                                                                frame1.dispose();
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                        
                                        //if user cliks "From Credit Card"
                                        button3.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to display menu options
                                                JFrame frame = new JFrame("fromcreditcard");
                                                JLabel mainLabel = new JLabel("Please select an account.");
                                                JButton button = new JButton("Cancel");
                                                JButton button1 = new JButton("To Chequing");
                                                JButton button2 = new JButton("To Savings");
                                                frame.setLayout(null);
                                                frame.setVisible(true);
                                                frame.setSize(600,450);
                                                frame.setResizable(false);
                                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel.setBounds(185, 35, 400, 50);
                                                mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel.setForeground(Color.GREEN);
                                                frame.add(mainLabel);
                                                button.setBounds(0, 300, 250, 50);
                                                frame.add(button);
                                                button1.setBounds(350, 200, 250, 50);
                                                frame.add(button1);
                                                button2.setBounds(350, 300, 250, 50);
                                                frame.add(button2);
                                                
                                                //if user clicks "Cancel"
                                                button.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes fromcreditcard window
                                                        frame.dispose();
                                                    }
                                                });
                                                
                                                //if user clicks "To Chequing"
                                                button1.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //uses graphics to let user enter amount
                                                        JFrame frame1 = new JFrame("tochequing");
                                                        JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                        JTextField txtField = new JTextField();
                                                        JButton button = new JButton("Ok");
                                                        JButton button1 = new JButton("Cancel");
                                                        JLabel Label = new JLabel();
                                                        frame1.setLayout(null);
                                                        frame1.setVisible(true);
                                                        frame1.setSize(600,450);
                                                        frame1.setResizable(false);
                                                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        mainLabel18.setBounds(120, 35, 400, 50);
                                                        mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel18.setForeground(Color.GREEN);
                                                        frame1.add(mainLabel18);
                                                        txtField.setBounds(185, 150, 200, 25);
                                                        frame1.add(txtField);
                                                        button.setBounds(185, 200, 200, 25);
                                                        frame1.add(button);
                                                        button1.setBounds(185, 250, 200, 25);
                                                        frame1.add(button1);
                                                        
                                                        //if user clicks "Ok"
                                                        button.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                                File nf = new File("CreditCardBalance.txt");
                                                                Scanner scanS;
                                                                String line = "";
                                                                
                                                                //exception handler
                                                                try
                                                                {
                                                                    //connects scanner to the file and obtains last line of input from file
                                                                    scanS = new Scanner(nf);
                                                                    while(scanS.hasNext())
                                                                    {
                                                                        line = scanS.nextLine();
                                                                    }
                                                                    //closes scanner
                                                                    scanS.close();
                                                                }
                                                                catch(IOException k)
                                                                {
                                                                    //prints an error message
                                                                    System.out.println("File error" + k.getMessage());
                                                                }
                                                                //initialize double variables for the last line in the file, total credit card balance, and transfer amount
                                                                double linee = Double.parseDouble(line);
                                                                double creditCardTotal = linee + myTransactions.getCreditCardBalance();
                                                                double transferAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                                //if total credit card balance is greater than or equal to transfer amount and transfer amount is greater than 0
                                                                if(creditCardTotal >= transferAmount && transferAmount > 0)
                                                                {
                                                                    //calculates the new credit card and chequing balance running in the program
                                                                    myTransactions.creditCardWithdraw(transferAmount);
                                                                    myTransactions.chequingDeposit(transferAmount);
                                                                    
                                                                    //uses graphics to display restart option
                                                                    JFrame frame2 = new JFrame("restart");
                                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                                    JButton button = new JButton("Yes");
                                                                    JButton button1 = new JButton("No");
                                                                    frame2.setLayout(null);
                                                                    frame2.setVisible(true);
                                                                    frame2.setSize(600,450);
                                                                    frame2.setResizable(false);
                                                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel);
                                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel1.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel1);
                                                                    button.setBounds(185, 230, 200, 25);
                                                                    frame2.add(button);
                                                                    button1.setBounds(185, 310, 200, 25);
                                                                    frame2.add(button1);

                                                                    //if user clicks "Yes"
                                                                    button.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes restart, tochequing, fromcreditcard, transfer, and atmlocations&transfer window
                                                                            frame2.dispose();
                                                                            frame1.dispose();
                                                                            frame.dispose();
                                                                            frame9.dispose();
                                                                            frame8.dispose();
                                                                        }
                                                                    });
                                                                    
                                                                    //if user clicks "No"
                                                                    button1.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes program
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                                                }
                                                                else
                                                                {
                                                                    //prints an error message
                                                                    Label.setText("Insufficient Funds.");
                                                                    Label.setBounds(215, 300, 400, 50);
                                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    Label.setForeground(Color.RED);
                                                                    frame.add(Label);
                                                                }
                                                            }
                                                        });
                                                        
                                                        //if user clicks "Cancel"
                                                        button1.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes tochequing window
                                                                frame1.dispose();
                                                            }
                                                        });
                                                    }
                                                });
                                                
                                                //if user clicks "To Savings"
                                                button2.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //uses graphics to let user enter amount
                                                        JFrame frame1 = new JFrame("tosavings");
                                                        JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                        JTextField txtField = new JTextField();
                                                        JButton button = new JButton("Ok");
                                                        JButton button1 = new JButton("Cancel");
                                                        JLabel Label = new JLabel();
                                                        frame1.setLayout(null);
                                                        frame1.setVisible(true);
                                                        frame1.setSize(600,450);
                                                        frame1.setResizable(false);
                                                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        mainLabel18.setBounds(120, 35, 400, 50);
                                                        mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel18.setForeground(Color.GREEN);
                                                        frame1.add(mainLabel18);
                                                        txtField.setBounds(185, 150, 200, 25);
                                                        frame1.add(txtField);
                                                        button.setBounds(185, 200, 200, 25);
                                                        frame1.add(button);
                                                        button1.setBounds(185, 250, 200, 25);
                                                        frame1.add(button1);
                                                        
                                                        //if user clicks "Ok"
                                                        button.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                                File nf = new File("CreditCardBalance.txt");
                                                                Scanner scanS;
                                                                String line = "";
                                                                
                                                                //exception handler
                                                                try
                                                                {
                                                                    //connects scanner to the file and obtains last line of input from file
                                                                    scanS = new Scanner(nf);
                                                                    while(scanS.hasNext())
                                                                    {
                                                                        line = scanS.nextLine();
                                                                    }
                                                                    //closes scanner
                                                                    scanS.close();
                                                                }
                                                                catch(IOException k)
                                                                {
                                                                    //prints an error message
                                                                    System.out.println("File error" + k.getMessage());
                                                                }
                                                                //initialize double variables for the last line in the file, total credit card balance, and transfer amount
                                                                double linee = Double.parseDouble(line);
                                                                double creditCardTotal = linee + myTransactions.getCreditCardBalance();
                                                                double transferAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                                //if total credit card balance is greater than or equal to transfer amount, and transfer amount is greater than 0
                                                                if(creditCardTotal >= transferAmount && transferAmount > 0)
                                                                {
                                                                    //calculates the new credit card and savings balance running in the program
                                                                    myTransactions.creditCardWithdraw(transferAmount);
                                                                    myTransactions.savingsDeposit(transferAmount);
                                                                    
                                                                    //uses graphics to display restart option
                                                                    JFrame frame2 = new JFrame("restart");
                                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                                    JButton button = new JButton("Yes");
                                                                    JButton button1 = new JButton("No");
                                                                    frame2.setLayout(null);
                                                                    frame2.setVisible(true);
                                                                    frame2.setSize(600,450);
                                                                    frame2.setResizable(false);
                                                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel.setForeground(Color.GREEN);
                                                                    frame1.add(mainLabel);
                                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    mainLabel1.setForeground(Color.GREEN);
                                                                    frame2.add(mainLabel1);
                                                                    button.setBounds(185, 230, 200, 25);
                                                                    frame2.add(button);
                                                                    button1.setBounds(185, 310, 200, 25);
                                                                    frame2.add(button1);

                                                                    //if user clicks "Yes"
                                                                    button.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes restart, tosavings, fromcreditcard, transfer, atmlocations&transfer window
                                                                            frame2.dispose();
                                                                            frame1.dispose();
                                                                            frame.dispose();
                                                                            frame9.dispose();
                                                                            frame8.dispose();
                                                                        }
                                                                    });
                                                                    
                                                                    //if user clicks "No"
                                                                    button1.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            //closes program
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                                                }
                                                                else
                                                                {
                                                                    //prints an error message
                                                                    Label.setText("Insufficient Funds.");
                                                                    Label.setBounds(215, 300, 400, 50);
                                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                                    Label.setForeground(Color.RED);
                                                                    frame.add(Label);
                                                                }
                                                            }
                                                        });
                                                        
                                                        //if user clicks "Cancel"
                                                        button1.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes tosavings window
                                                                frame1.dispose();
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Cancel"
                                button29.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //closes atmlocations&transfer window
                                        frame8.dispose();
                                    }
                                });
                            }
                        });    
                        
                        //if user clicks "Change PIN"
                        button3.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //uses graphics to let user enter new pin
                                JFrame frame12 = new JFrame("newpin");
                                JLabel mainLabel12 = new JLabel("Please enter your NEW PIN and press OK.");
                                JTextField txtField = new JTextField("Type here");
                                JButton button54 = new JButton("OK");
                                JButton button55 = new JButton("Cancel");
                                frame12.setLayout(null);
                                frame12.setVisible(true);
                                frame12.setSize(600,450);
                                frame12.setResizable(false);
                                frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainLabel12.setBounds(100, 35, 400, 50);
                                mainLabel12.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                mainLabel12.setForeground(Color.GREEN);
                                frame12.add(mainLabel12);
                                txtField.setBounds(185, 150, 200, 25);
                                frame12.add(txtField);
                                button54.setBounds(185, 230, 200, 25);
                                frame12.add(button54);
                                button55.setBounds(185, 310, 200, 25);
                                frame12.add(button55);
                                
                                //if user clicks "Ok"
                                button54.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    { 
                                        //store the new PIN the user enters into a string variable, then converts it to an integer
                                        String newPIN1 = (txtField.getText());
                                        int newPIN = Integer.parseInt((newPIN1));
                                        
                                        //uses graphics to let user confirm new PIN
                                        JFrame frame13 = new JFrame("confirm");
                                        JLabel mainLabel13 = new JLabel("Please confirm your new PIN by entering it again and press OK.");
                                        JTextField txtField1 = new JTextField("Type here");
                                        JButton button56 = new JButton("OK");
                                        JButton button57 = new JButton("Cancel");
                                        JLabel Label1 = new JLabel();
                                        frame13.setLayout(null);
                                        frame13.setVisible(true);
                                        frame13.setSize(600,450);
                                        frame13.setResizable(false);
                                        frame13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel13.setBounds(25, 35, 600, 50);
                                        mainLabel13.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel13.setForeground(Color.GREEN);
                                        frame13.add(mainLabel13);
                                        txtField1.setBounds(185, 150, 200, 25);
                                        frame13.add(txtField1);
                                        button56.setBounds(185, 230, 200, 25);
                                        frame13.add(button56);
                                        button57.setBounds(185, 310, 200, 25);
                                        frame13.add(button57);
                                        
                                        //if user clicks "Ok"
                                        button56.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //store the new confirmed PIN the user enters into a string variable, then converts it to an integer
                                                String newPIN3 = (txtField1.getText());
                                                int newPIN2 = Integer.parseInt((newPIN3));
                                                
                                                //establishes stream the filewriter and printwriter will use
                                                FileWriter fw;
                                                PrintWriter pw;
                                                
                                                try
                                                {
                                                    //specifies file to be appended and connects printwriter to it
                                                    fw = new FileWriter("PIN.txt", true);
                                                    pw = new PrintWriter(fw);
                                                    
                                                    //if users new pin is equal to new confirmed pin
                                                    if(newPIN == newPIN2)
                                                    {
                                                        //sets pin to new confirmed pin, declares new pin int variable, and prints new pin to the file
                                                        myUser.setPin(newPIN2);
                                                        int newPin = myUser.getPin();
                                                        pw.println(newPin);
                                                        
                                                        //uses graphics to display succesful pin change
                                                        JFrame frame14 = new JFrame("pinchanged");
                                                        JLabel mainLabel14 = new JLabel("Your PIN has been changed.");
                                                        JLabel mainLabel15 = new JLabel("Would you like to perform another transaction?");
                                                        JButton button58 = new JButton("Yes");
                                                        JButton button59 = new JButton("No");
                                                        frame14.setLayout(null);
                                                        frame14.setVisible(true);
                                                        frame14.setSize(600,450);
                                                        frame14.setResizable(false);
                                                        frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        mainLabel14.setBounds(165, 35, 400, 50);
                                                        mainLabel14.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel14.setForeground(Color.GREEN);
                                                        frame14.add(mainLabel14);
                                                        mainLabel15.setBounds(90, 100, 400, 50);
                                                        mainLabel15.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        mainLabel15.setForeground(Color.GREEN);
                                                        frame14.add(mainLabel15);
                                                        button58.setBounds(185, 230, 200, 25);
                                                        frame14.add(button58);
                                                        button59.setBounds(185, 310, 200, 25);
                                                        frame14.add(button59);
                                                        
                                                        //if user clicks "Yes"
                                                        button58.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes pinchanged, confirm, and newpin window
                                                                frame14.dispose();
                                                                frame13.dispose();
                                                                frame12.dispose();
                                                            }
                                                        });
                                                        
                                                        //if user clicks "No"
                                                        button59.addActionListener(new ActionListener()
                                                        {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                //closes program
                                                                System.exit(0);
                                                            }
                                                        });
                                                        //closes the file stream
                                                        pw.close();
                                                    }
                                                    else
                                                    {
                                                        //prints an error message
                                                        Label1.setText("Incorrect PIN.");
                                                        Label1.setBounds(215, 370, 400, 50);
                                                        Label1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                        Label1.setForeground(Color.RED);
                                                        frame13.add(Label1);
                                                    } 
                                                    //closes the file stream
                                                    pw.close();
                                                }
                                                catch(IOException t)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error: " + t.getMessage());
                                                }  
                                            }
                                        });
                                        
                                        //if user clicks "Cancel"
                                        button57.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes confirm window
                                                frame13.dispose();
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Cancel"
                                button55.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //closes newpin window
                                        frame12.dispose();
                                    }
                                });
                            }
                        });
                        
                        //if user clicks "Cash Withdrawal"
                        button4.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //uses graphics to display menu options
                                JFrame frame5 = new JFrame("withdraw");
                                JLabel mainLabel4 = new JLabel("Please make a selection.");
                                JButton button17 = new JButton("Chequing");
                                JButton button18 = new JButton("Savings");
                                JButton button19 = new JButton("Credit Card");
                                JButton button20 = new JButton("Back");
                                frame5.setLayout(null);
                                frame5.setVisible(true);
                                frame5.setSize(600,450);
                                frame5.setResizable(false);
                                frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainLabel4.setBounds(185, 35, 400, 50);
                                mainLabel4.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                mainLabel4.setForeground(Color.GREEN);
                                frame5.add(mainLabel4);
                                button17.setBounds(0, 100, 250, 50);
                                frame5.add(button17);
                                button18.setBounds(0, 200, 250, 50);
                                frame5.add(button18);
                                button19.setBounds(0, 300, 250, 50);
                                frame5.add(button19);
                                button20.setBounds(350, 100, 250, 50);
                                frame5.add(button20);

                                //if user clicks "Chequing"
                                button17.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display transaction options
                                        JFrame frame9 = new JFrame("chequingwithdraw");
                                        JLabel mainLabel8 = new JLabel("Please select a transaction.");
                                        JButton button30 = new JButton("$100");
                                        JButton button31 = new JButton("$200");
                                        JButton button32 = new JButton("$300");
                                        JButton button33 = new JButton("Back");
                                        JButton button34 = new JButton("$20");
                                        JButton button35 = new JButton("$40");
                                        JButton button36 = new JButton("$80");
                                        JButton button37 = new JButton("Another Amount");
                                        frame9.setLayout(null);
                                        frame9.setVisible(true);
                                        frame9.setSize(600,450);
                                        frame9.setResizable(false);
                                        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel8.setBounds(185, 35, 400, 50);
                                        mainLabel8.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel8.setForeground(Color.GREEN);
                                        frame9.add(mainLabel8);
                                        button30.setBounds(0, 100, 125, 50);
                                        frame9.add(button30);
                                        button31.setBounds(0, 180, 125, 50);
                                        frame9.add(button31);
                                        button32.setBounds(0, 260, 125, 50);
                                        frame9.add(button32);
                                        button33.setBounds(0, 340, 250, 50);
                                        frame9.add(button33);
                                        button34.setBounds(475, 100, 125, 50);
                                        frame9.add(button34);
                                        button35.setBounds(475, 180, 125, 50);
                                        frame9.add(button35);
                                        button36.setBounds(475, 260, 125, 50);
                                        frame9.add(button36);
                                        button37.setBounds(350, 340, 250, 50);
                                        frame9.add(button37);

                                        //if user clicks "$100"
                                        button30.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and transfer amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 100.00;

                                                //if total chequing balance is greater than or equal to the withdraw amount, and if withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);

                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });

                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$200"
                                        button31.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and withdraw amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 200.00;

                                                //if total chequing balance is greater than or eqaul to withdraw amount, and withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$300"
                                        button32.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and withdraw amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 300.00;

                                                //if total chequing balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "Yes"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Back"
                                        button33.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes "chequingwithdraw" window
                                                frame9.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "$20"
                                        button34.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and withdraw amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 20.00;

                                                //if total chequing balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$40"
                                        button35.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and withdraw amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 40.00;

                                                //if total chequing balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$80"
                                        button36.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("ChequingBalance.txt");
                                                Scanner scanN;
                                                double chequing = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        chequing = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total chequing balance, and withdraw amount
                                                double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                double wit = 80.00;

                                                //if total chequing balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(chequingTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequingwithdraw, and withdraw window
                                                            frame.dispose();
                                                            frame9.dispose();
                                                            frame5.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame9.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Another Amount"
                                        button37.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to let user enter amount
                                                JFrame frame15 = new JFrame("anotheramount");
                                                JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                JTextField txtField1 = new JTextField();
                                                JButton button76 = new JButton("Ok");
                                                JButton button77 = new JButton("Cancel");
                                                JLabel Label = new JLabel();
                                                frame15.setLayout(null);
                                                frame15.setVisible(true);
                                                frame15.setSize(600,450);
                                                frame15.setResizable(false);
                                                frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel18.setBounds(120, 35, 400, 50);
                                                mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel18.setForeground(Color.GREEN);
                                                frame15.add(mainLabel18);
                                                txtField1.setBounds(185, 150, 200, 25);
                                                frame15.add(txtField1);
                                                button76.setBounds(185, 200, 200, 25);
                                                frame15.add(button76);
                                                button77.setBounds(185, 250, 200, 25);
                                                frame15.add(button77);
                                                
                                                //if user clicks "Ok"
                                                button76.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                                        File nf = new File("ChequingBalance.txt");
                                                        Scanner scanN;
                                                        double chequing = 0;
                                                        
                                                        //exception handler
                                                        try
                                                        {
                                                            //connects Scanner to File and obtains last line of input
                                                            scanN = new Scanner(nf);
                                                            while(scanN.hasNext())
                                                            {
                                                                chequing = scanN.nextDouble();
                                                            }
                                                            //closes scanner
                                                            scanN.close();
                                                        }
                                                        catch(IOException k)
                                                        {
                                                            //prints an error message
                                                            System.out.println("File error" + k.getMessage());
                                                        }
                                                        //initialize double variables for the total chequing balance, and withdraw amount
                                                        double chequingTotal = chequing + myTransactions.getChequingBalance();
                                                        double withdrawAmount = Double.parseDouble((txtField1.getText()));
                                                        
                                                        //if total chequing balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                        if(chequingTotal >= withdrawAmount && withdrawAmount > 0)
                                                        {
                                                            //calculates the new chequing balance running in the program
                                                            myTransactions.chequingWithdraw(withdrawAmount);
                                                            
                                                            //uses graphics to display restart option
                                                            JFrame frame16 = new JFrame("restart");
                                                            JLabel mainLabel19 = new JLabel("Transaction completed.");
                                                            JLabel mainLabel20 = new JLabel("Would you like to perform another transaction?");
                                                            JButton button78 = new JButton("Yes");
                                                            JButton button79 = new JButton("No");
                                                            frame16.setLayout(null);
                                                            frame16.setVisible(true);
                                                            frame16.setSize(600,450);
                                                            frame16.setResizable(false);
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            mainLabel19.setBounds(170, 35, 400, 50);
                                                            mainLabel19.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel19.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel19);
                                                            mainLabel20.setBounds(90, 100, 400, 50);
                                                            mainLabel20.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel20.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel20);
                                                            button78.setBounds(185, 230, 200, 25);
                                                            frame16.add(button78);
                                                            button79.setBounds(185, 310, 200, 25);
                                                            frame16.add(button79);

                                                            //if user clicks "Yes"
                                                            button78.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes restart and anotheramount window
                                                                    frame16.dispose();
                                                                    frame15.dispose();
                                                                }
                                                            });
                                                            
                                                            //if user clicks "No"
                                                            button79.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes program
                                                                    System.exit(0);
                                                                }
                                                            });
                                                        }
                                                        else
                                                        {
                                                            //prints an error message
                                                            Label.setText("Insufficient Funds.");
                                                            Label.setBounds(215, 300, 400, 50);
                                                            Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            Label.setForeground(Color.RED);
                                                            frame15.add(Label);
                                                        }
                                                    }   
                                                });
                                                
                                                //if user clicks "Cancel"
                                                button77.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes anotheramount window
                                                        frame15.dispose();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                //if user clicks "Savings"
                                button18.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display transaction options
                                        JFrame frame10 = new JFrame("savingswithdraw");
                                        JLabel mainLabel10 = new JLabel("Please select a transaction.");
                                        JButton button38 = new JButton("$100");
                                        JButton button39 = new JButton("$200");
                                        JButton button40 = new JButton("$300");
                                        JButton button41 = new JButton("Back");
                                        JButton button42 = new JButton("$20");
                                        JButton button43 = new JButton("$40");
                                        JButton button44 = new JButton("$80");
                                        JButton button45 = new JButton("Another Amount");
                                        frame10.setLayout(null);
                                        frame10.setVisible(true);
                                        frame10.setSize(600,450);
                                        frame10.setResizable(false);
                                        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel10.setBounds(185, 35, 400, 50);
                                        mainLabel10.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel10.setForeground(Color.GREEN);
                                        frame10.add(mainLabel10);
                                        button38.setBounds(0, 100, 125, 50);
                                        frame10.add(button38);
                                        button39.setBounds(0, 180, 125, 50);
                                        frame10.add(button39);
                                        button40.setBounds(0, 260, 125, 50);
                                        frame10.add(button40);
                                        button41.setBounds(0, 340, 250, 50);
                                        frame10.add(button41);
                                        button42.setBounds(475, 100, 125, 50);
                                        frame10.add(button42);
                                        button43.setBounds(475, 180, 125, 50);
                                        frame10.add(button43);
                                        button44.setBounds(475, 260, 125, 50);
                                        frame10.add(button44);
                                        button45.setBounds(350, 340, 250, 50);
                                        frame10.add(button45);

                                        //if user clicks "$100"
                                        button38.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 100;

                                                //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and savingswithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks $200
                                        button39.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 200;

                                                //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses grapics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and savingswithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$300"
                                        button40.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //close scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 300;

                                                //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and savingswithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Back"
                                        button41.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes savingswithdraw window
                                                frame10.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "$20"
                                        button42.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 20;

                                                //if total savings balance is greater than or equal to withraw amount, and withdraw amount is greater than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and savingswithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$40"
                                        button43.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 40;

                                                //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greate than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and chequingwithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$80"
                                        button44.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                File nf = new File("SavingsBalance.txt");
                                                Scanner scanN;
                                                double savings = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects Scanner to File and obtains last line of input
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        savings = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total savings balance, and withdraw amount
                                                double savingsTotal = savings + myTransactions.getChequingBalance();
                                                double wit = 80;

                                                //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(savingsTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and savingswithdraw window
                                                            frame.dispose();
                                                            frame10.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame10.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Another Amount"
                                        button45.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to let user enter amount
                                                JFrame frame15 = new JFrame("anotheramount");
                                                JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                JTextField txtField1 = new JTextField();
                                                JButton button76 = new JButton("Ok");
                                                JButton button77 = new JButton("Cancel");
                                                JLabel Label = new JLabel();
                                                frame15.setLayout(null);
                                                frame15.setVisible(true);
                                                frame15.setSize(600,450);
                                                frame15.setResizable(false);
                                                frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel18.setBounds(120, 35, 400, 50);
                                                mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel18.setForeground(Color.GREEN);
                                                frame15.add(mainLabel18);
                                                txtField1.setBounds(185, 150, 200, 25);
                                                frame15.add(txtField1);
                                                button76.setBounds(185, 200, 200, 25);
                                                frame15.add(button76);
                                                button77.setBounds(185, 250, 200, 25);
                                                frame15.add(button77);
                                                
                                                //if user clicks "Ok"
                                                button76.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //creates file object to read savings balance, declaring scanner object, and initalizes double variable
                                                        File nf = new File("SavingsBalance.txt");
                                                        Scanner scanN;
                                                        double savings = 0;
                                                        
                                                        //exception handler
                                                        try
                                                        {
                                                            //connects Scanner to File and obtains last line of input
                                                            scanN = new Scanner(nf);
                                                            while(scanN.hasNext())
                                                            {
                                                                savings = scanN.nextDouble();
                                                            }
                                                            //closes scanner
                                                            scanN.close();
                                                        }
                                                        catch(IOException k)
                                                        {
                                                            //prints an error message
                                                            System.out.println("File error" + k.getMessage());
                                                        }
                                                        //initialize double variables for the total savings balance, and withdraw amount
                                                        double savingsTotal = savings + myTransactions.getChequingBalance();
                                                        double withdrawAmount = Double.parseDouble((txtField1.getText()));
                                                        
                                                        //if total savings balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                        if(savingsTotal >= withdrawAmount && withdrawAmount > 0)
                                                        {
                                                            //calculates the new savings balance running in the program
                                                            myTransactions.savingsWithdraw(withdrawAmount);
                                                            
                                                            //uses graphics to display restart option
                                                            JFrame frame16 = new JFrame("restart");
                                                            JLabel mainLabel19 = new JLabel("Transaction completed.");
                                                            JLabel mainLabel20 = new JLabel("Would you like to perform another transaction?");
                                                            JButton button78 = new JButton("Yes");
                                                            JButton button79 = new JButton("No");
                                                            frame16.setLayout(null);
                                                            frame16.setVisible(true);
                                                            frame16.setSize(600,450);
                                                            frame16.setResizable(false);
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            mainLabel19.setBounds(170, 35, 400, 50);
                                                            mainLabel19.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel19.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel19);
                                                            mainLabel20.setBounds(90, 100, 400, 50);
                                                            mainLabel20.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel20.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel20);
                                                            button78.setBounds(185, 230, 200, 25);
                                                            frame16.add(button78);
                                                            button79.setBounds(185, 310, 200, 25);
                                                            frame16.add(button79);

                                                            //if user clicks "Yes"
                                                            button78.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes restart, anotheramount, chequingwithdraw, and withdraw window
                                                                    frame16.dispose();
                                                                    frame15.dispose();
                                                                    frame10.dispose();
                                                                    frame5.dispose();
                                                                }
                                                            });
                                                            
                                                            //if user clicks "No"
                                                            button79.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes program
                                                                    System.exit(0);
                                                                }
                                                            });
                                                        }
                                                        else
                                                        {
                                                            //prints an error message
                                                            Label.setText("Insufficient Funds.");
                                                            Label.setBounds(215, 300, 400, 50);
                                                            Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            Label.setForeground(Color.RED);
                                                            frame15.add(Label);
                                                        }
                                                    }   
                                                });
                                                
                                                //if user clicks "Cancel"
                                                button77.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes anotheramount window
                                                        frame15.dispose();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Credit Card"
                                button19.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display transaction options
                                        JFrame frame11 = new JFrame("creditcardwithrdraw");
                                        JLabel mainLabel11 = new JLabel("Please select a transaction.");
                                        JButton button46 = new JButton("$100");
                                        JButton button47 = new JButton("$200");
                                        JButton button48 = new JButton("$300");
                                        JButton button49 = new JButton("Back");
                                        JButton button50 = new JButton("$20");
                                        JButton button51 = new JButton("$40");
                                        JButton button52 = new JButton("$80");
                                        JButton button53 = new JButton("Another Amount");
                                        frame11.setLayout(null);
                                        frame11.setVisible(true);
                                        frame11.setSize(600,450);
                                        frame11.setResizable(false);
                                        frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel11.setBounds(185, 35, 400, 50);
                                        mainLabel11.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel11.setForeground(Color.GREEN);
                                        frame11.add(mainLabel11);
                                        button46.setBounds(0, 100, 125, 50);
                                        frame11.add(button46);
                                        button47.setBounds(0, 180, 125, 50);
                                        frame11.add(button47);
                                        button48.setBounds(0, 260, 125, 50);
                                        frame11.add(button48);
                                        button49.setBounds(0, 340, 250, 50);
                                        frame11.add(button49);
                                        button50.setBounds(475, 100, 125, 50);
                                        frame11.add(button50);
                                        button51.setBounds(475, 180, 125, 50);
                                        frame11.add(button51);
                                        button52.setBounds(475, 260, 125, 50);
                                        frame11.add(button52);
                                        button53.setBounds(350, 340, 250, 50);
                                        frame11.add(button53);

                                        //if user clicks "$100"
                                        button46.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getChequingBalance();
                                                double wit = 100;

                                                //if tota credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes:
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$200"
                                        button47.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                               //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //close scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getChequingBalance();
                                                double wit = 200;

                                                //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$300"
                                        button48.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //close scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getChequingBalance();
                                                double wit = 300;

                                                //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);
                                                    
                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Back"
                                        button49.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes creditcardwithdraw window
                                                frame11.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "$20"
                                        button50.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getChequingBalance();
                                                double wit = 20;

                                                //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$40"
                                        button51.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //closes the scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getChequingBalance();
                                                double wit = 40;

                                                //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);
                                                    
                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes the program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$80"
                                        button52.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                File nf = new File("CreditCardBalance.txt");
                                                Scanner scanN;
                                                double creditCard = 0;
                                                
                                                //exception handler
                                                try
                                                {
                                                    //connects scanner to the file and obtains last line of input from file
                                                    scanN = new Scanner(nf);
                                                    while(scanN.hasNext())
                                                    {
                                                        creditCard = scanN.nextDouble();
                                                    }
                                                    //closes scanner
                                                    scanN.close();
                                                }
                                                catch(IOException k)
                                                {
                                                    //prints an error message
                                                    System.out.println("File error" + k.getMessage());
                                                }
                                                
                                                //initialize double variables for the total credit card balance, and withdraw amount
                                                double creditCardTotal = creditCard + myTransactions.getCreditCardBalance();
                                                double wit = 80;

                                                //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                if(creditCardTotal >= wit && wit > 0)
                                                {
                                                    //calculates the new credit card balance running in the program
                                                    myTransactions.creditCardWithdraw(wit);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart and creditcardwithdraw window
                                                            frame.dispose();
                                                            frame11.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame11.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Another Amount"
                                        button53.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to let user enter amount
                                                JFrame frame15 = new JFrame("anotheramount");
                                                JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                JTextField txtField1 = new JTextField();
                                                JButton button76 = new JButton("Ok");
                                                JButton button77 = new JButton("Cancel");
                                                JLabel Label = new JLabel();
                                                frame15.setLayout(null);
                                                frame15.setVisible(true);
                                                frame15.setSize(600,450);
                                                frame15.setResizable(false);
                                                frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel18.setBounds(120, 35, 400, 50);
                                                mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel18.setForeground(Color.GREEN);
                                                frame15.add(mainLabel18);
                                                txtField1.setBounds(185, 150, 200, 25);
                                                frame15.add(txtField1);
                                                button76.setBounds(185, 200, 200, 25);
                                                frame15.add(button76);
                                                button77.setBounds(185, 250, 200, 25);
                                                frame15.add(button77);
                                                
                                                //if user clicks "Ok"
                                                button76.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                                        File nf = new File("CreditCardBalance.txt");
                                                        Scanner scanN;
                                                        double creditCard = 0;
                                                        
                                                        //exception handler
                                                        try
                                                        {
                                                            //connects scanner to the file and obtains last line of input from file
                                                            scanN = new Scanner(nf);
                                                            while(scanN.hasNext())
                                                            {
                                                                creditCard = scanN.nextDouble();
                                                            }
                                                            //closes scanner
                                                            scanN.close();
                                                        }
                                                        catch(IOException k)
                                                        {
                                                            //prints an error message
                                                            System.out.println("File error" + k.getMessage());
                                                        }
                                                        //initialize double variables for the total credit card balance, and withdraw amount
                                                        double creditCardTotal = creditCard + myTransactions.getCreditCardBalance();
                                                        double withdrawAmount = Double.parseDouble((txtField1.getText()));

                                                        //if total credit card balance is greater than or equal to withdraw amount, and withdraw amount is greater than 0
                                                        if(creditCardTotal >= withdrawAmount && withdrawAmount > 0)
                                                        {
                                                            //calculates the new credit card balance running in the program
                                                            myTransactions.creditCardWithdraw(withdrawAmount);
                                                            
                                                            //uses graphics to display restart option
                                                            JFrame frame16 = new JFrame("restart");
                                                            JLabel mainLabel19 = new JLabel("Transaction completed.");
                                                            JLabel mainLabel20 = new JLabel("Would you like to perform another transaction?");
                                                            JButton button78 = new JButton("Yes");
                                                            JButton button79 = new JButton("No");
                                                            frame16.setLayout(null);
                                                            frame16.setVisible(true);
                                                            frame16.setSize(600,450);
                                                            frame16.setResizable(false);
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            mainLabel19.setBounds(170, 35, 400, 50);
                                                            mainLabel19.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel19.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel19);
                                                            mainLabel20.setBounds(90, 100, 400, 50);
                                                            mainLabel20.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel20.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel20);
                                                            button78.setBounds(185, 230, 200, 25);
                                                            frame16.add(button78);
                                                            button79.setBounds(185, 310, 200, 25);
                                                            frame16.add(button79);

                                                            //if user clicks "Yes"
                                                            button78.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes restart, anotheramount, creditcardwithdraw, and withdraw window
                                                                    frame16.dispose();
                                                                    frame15.dispose();
                                                                    frame11.dispose();
                                                                    frame5.dispose();
                                                                }
                                                            });
                                                            
                                                            //if user clicks "No"
                                                            button79.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes program"
                                                                    System.exit(0);
                                                                }
                                                            });
                                                        }
                                                        else
                                                        {
                                                            //prints an error message
                                                            Label.setText("Insufficient Funds.");
                                                            Label.setBounds(215, 300, 400, 50);
                                                            Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            Label.setForeground(Color.RED);
                                                            frame15.add(Label);
                                                        }
                                                    }
                                                });
                                                
                                                //if user clicks "Cancel"
                                                button77.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //closes anotheramount window
                                                        frame15.dispose();
                                                    }
                                                });               
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Back"
                                button20.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //closes withdraw window
                                        frame5.dispose();
                                    }
                                 });
                             }
                        });
                        
                        //if user clicks "Deposit"
                        button5.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //uses graphics to display menu options
                                JFrame frame6 = new JFrame("deposit");
                                JLabel mainLabel5 = new JLabel("Please select a transaction.");
                                JButton button21 = new JButton("Chequing");
                                JButton button22 = new JButton("Savings");
                                JButton button23 = new JButton("Back");
                                frame6.setLayout(null);
                                frame6.setVisible(true);
                                frame6.setSize(600,450);
                                frame6.setResizable(false);
                                frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                mainLabel5.setBounds(185, 35, 400, 50);
                                mainLabel5.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                mainLabel5.setForeground(Color.GREEN);
                                frame6.add(mainLabel5);
                                button21.setBounds(0, 100, 250, 50);
                                frame6.add(button21);
                                button22.setBounds(0, 200, 250, 50);
                                frame6.add(button22);
                                button23.setBounds(0, 300, 250, 50);
                                frame6.add(button23);

                                //if user clicks "Chequing"
                                button21.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display transaction options
                                        JFrame frame15 = new JFrame("chequing");
                                        JLabel mainLabel16 = new JLabel("Please select a transaction.");
                                        JButton button60 = new JButton("$100");
                                        JButton button61 = new JButton("$200");
                                        JButton button62 = new JButton("$300");
                                        JButton button63 = new JButton("Back");
                                        JButton button64 = new JButton("$20");
                                        JButton button65 = new JButton("$40");
                                        JButton button66 = new JButton("$80");
                                        JButton button67 = new JButton("Another Amount");
                                        JLabel Label = new JLabel();
                                        frame15.setLayout(null);
                                        frame15.setVisible(true);
                                        frame15.setSize(600,450);
                                        frame15.setResizable(false);
                                        frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel16.setBounds(185, 35, 400, 50);
                                        mainLabel16.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel16.setForeground(Color.GREEN);
                                        frame15.add(mainLabel16);
                                        button60.setBounds(0, 100, 125, 50);
                                        frame15.add(button60);
                                        button61.setBounds(0, 180, 125, 50);
                                        frame15.add(button61);
                                        button62.setBounds(0, 260, 125, 50);
                                        frame15.add(button62);
                                        button63.setBounds(0, 340, 250, 50);
                                        frame15.add(button63);
                                        button64.setBounds(475, 100, 125, 50);
                                        frame15.add(button64);
                                        button65.setBounds(475, 180, 125, 50);
                                        frame15.add(button65);
                                        button66.setBounds(475, 260, 125, 50);
                                        frame15.add(button66);
                                        button67.setBounds(350, 340, 250, 50);
                                        frame15.add(button67);

                                        //if user clicks "$100"
                                        button60.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 100;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$200"
                                        button61.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 200;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to disply restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$300"
                                        button62.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 300;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);
                                                    
                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Back"
                                        button63.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes chequing window
                                                frame15.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "$20"
                                        button64.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 20;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);
                                                    
                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$40"
                                        button65.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initialized double variable
                                                double dep = 40;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$80"
                                        button66.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initialized double variable
                                                double dep = 80;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new chequing balance running in the program
                                                    myTransactions.chequingDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, chequing, and deposit window
                                                            frame.dispose();
                                                            frame15.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame15.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Another Amount"
                                        button67.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to let user enter amount
                                                JFrame frame1 = new JFrame("transferamount");
                                                JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                JTextField txtField = new JTextField();
                                                JButton button = new JButton("Ok");
                                                JButton button1 = new JButton("Cancel");
                                                JLabel Label = new JLabel();
                                                frame1.setLayout(null);
                                                frame1.setVisible(true);
                                                frame1.setSize(600,450);
                                                frame1.setResizable(false);
                                                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel18.setBounds(120, 35, 400, 50);
                                                mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel18.setForeground(Color.GREEN);
                                                frame1.add(mainLabel18);
                                                txtField.setBounds(185, 150, 200, 25);
                                                frame1.add(txtField);
                                                button.setBounds(185, 200, 200, 25);
                                                frame1.add(button);
                                                button1.setBounds(185, 250, 200, 25);
                                                frame1.add(button1);
                                                
                                                //if user clicks "Ok"
                                                button.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //initialize deposit amount
                                                        double depositAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                        //if deposit amount is greater than 0
                                                        if(depositAmount > 0)
                                                        {
                                                            //calculates the new chequing balance running in the program
                                                            myTransactions.chequingDeposit(depositAmount);
                                                            
                                                            //uses graphics to display restart option
                                                            JFrame frame16 = new JFrame("restart");
                                                            JLabel mainLabel19 = new JLabel("Transaction completed.");
                                                            JLabel mainLabel20 = new JLabel("Would you like to perform another transaction?");
                                                            JButton button78 = new JButton("Yes");
                                                            JButton button79 = new JButton("No");
                                                            frame16.setLayout(null);
                                                            frame16.setVisible(true);
                                                            frame16.setSize(600,450);
                                                            frame16.setResizable(false);
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            mainLabel19.setBounds(170, 35, 400, 50);
                                                            mainLabel19.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel19.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel19);
                                                            mainLabel20.setBounds(90, 100, 400, 50);
                                                            mainLabel20.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel20.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel20);
                                                            button78.setBounds(185, 230, 200, 25);
                                                            frame16.add(button78);
                                                            button79.setBounds(185, 310, 200, 25);
                                                            frame16.add(button79);

                                                            //if user clicks "Yes"
                                                            button78.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes restart, transferamount, chequing, and deposit window
                                                                    frame16.dispose();
                                                                    frame1.dispose();
                                                                    frame15.dispose();
                                                                    frame6.dispose();
                                                                }
                                                            });
                                                            
                                                            //if user clicks "No"
                                                            button79.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes program
                                                                    System.exit(0);
                                                                }
                                                            });
                                                        }
                                                        else
                                                        {
                                                            //prints an error message
                                                            Label.setText("Insufficient Funds.");
                                                            Label.setBounds(215, 300, 400, 50);
                                                            Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            Label.setForeground(Color.RED);
                                                            frame1.add(Label);
                                                        }
                                                    }
                                                });
                                                
                                                //if user clicks "Cancel"
                                                button1.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        frame1.dispose();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Savings"
                                button22.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //uses graphics to display transaction options
                                        JFrame frame16 = new JFrame("savings");
                                        JLabel mainLabel17 = new JLabel("Please select a transaction.");
                                        JButton button68 = new JButton("$100");
                                        JButton button69 = new JButton("$200");
                                        JButton button70 = new JButton("$300");
                                        JButton button71 = new JButton("Back");
                                        JButton button72 = new JButton("$20");
                                        JButton button73 = new JButton("$40");
                                        JButton button74 = new JButton("$80");
                                        JButton button75 = new JButton("Another Amount");
                                        frame16.setLayout(null);
                                        frame16.setVisible(true);
                                        frame16.setSize(600,450);
                                        frame16.setResizable(false);
                                        frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        mainLabel17.setBounds(185, 35, 400, 50);
                                        mainLabel17.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                        mainLabel17.setForeground(Color.GREEN);
                                        frame16.add(mainLabel17);
                                        button68.setBounds(0, 100, 125, 50);
                                        frame16.add(button68);
                                        button69.setBounds(0, 180, 125, 50);
                                        frame16.add(button69);
                                        button70.setBounds(0, 260, 125, 50);
                                        frame16.add(button70);
                                        button71.setBounds(0, 340, 250, 50);
                                        frame16.add(button71);
                                        button72.setBounds(475, 100, 125, 50);
                                        frame16.add(button72);
                                        button73.setBounds(475, 180, 125, 50);
                                        frame16.add(button73);
                                        button74.setBounds(475, 260, 125, 50);
                                        frame16.add(button74);
                                        button75.setBounds(350, 340, 250, 50);
                                        frame16.add(button75);

                                        //if user clicks "$100"
                                        button68.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 100;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);

                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and deposit window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });

                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$200"
                                        button69.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 200;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and deposit window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$300"
                                        button70.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {   
                                                //initializes double variable
                                                double dep = 300;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and deposit window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Back"
                                        button71.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //closes savings window
                                                frame16.dispose();
                                            }
                                        });
                                        
                                        //if user clicks "$20"
                                        button72.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 20;

                                                //if deposit amount is grater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and depost window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$40"
                                        button73.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 40;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);
                                                    
                                                    //uses graphics to display restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and deposit window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    
                                                    //if user clicks "No"
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "$80"
                                        button74.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //initializes double variable
                                                double dep = 80;

                                                //if deposit amount is greater than 0
                                                if(dep > 0)
                                                {
                                                    //calculates the new savings balance running in the program
                                                    myTransactions.savingsDeposit(dep);
                                                    
                                                    //uses graphics to print restart option
                                                    JFrame frame = new JFrame("restart");
                                                    JLabel mainLabel = new JLabel("Transaction completed.");
                                                    JLabel mainLabel1 = new JLabel("Would you like to perform another transaction?");
                                                    JButton button = new JButton("Yes");
                                                    JButton button1 = new JButton("No");
                                                    frame.setLayout(null);
                                                    frame.setVisible(true);
                                                    frame.setSize(600,450);
                                                    frame.setResizable(false);
                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                    mainLabel.setBounds(170, 35, 400, 50);
                                                    mainLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel.setForeground(Color.GREEN);
                                                    frame.add(mainLabel);
                                                    mainLabel1.setBounds(90, 100, 400, 50);
                                                    mainLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    mainLabel1.setForeground(Color.GREEN);
                                                    frame.add(mainLabel1);
                                                    button.setBounds(185, 230, 200, 25);
                                                    frame.add(button);
                                                    button1.setBounds(185, 310, 200, 25);
                                                    frame.add(button1);

                                                    //if user clicks "Yes"
                                                    button.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes restart, savings, and deposit window
                                                            frame.dispose();
                                                            frame16.dispose();
                                                            frame6.dispose();
                                                        }
                                                    });
                                                    button1.addActionListener(new ActionListener()
                                                    {
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            //closes program
                                                            System.exit(0);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    //prints an error message
                                                    Label.setText("Insufficient Funds.");
                                                    Label.setBounds(215, 300, 400, 50);
                                                    Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                    Label.setForeground(Color.RED);
                                                    frame16.add(Label);
                                                }
                                            }
                                        });
                                        
                                        //if user clicks "Another Amount"
                                        button75.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                //uses graphics to let user enter amount
                                                JFrame frame1 = new JFrame("transferamount");
                                                JLabel mainLabel18 = new JLabel("Please enter the amount and press OK.");
                                                JTextField txtField = new JTextField();
                                                JButton button = new JButton("Ok");
                                                JButton button1 = new JButton("Cancel");
                                                JLabel Label = new JLabel();
                                                frame1.setLayout(null);
                                                frame1.setVisible(true);
                                                frame1.setSize(600,450);
                                                frame1.setResizable(false);
                                                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                mainLabel18.setBounds(120, 35, 400, 50);
                                                mainLabel18.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                mainLabel18.setForeground(Color.GREEN);
                                                frame1.add(mainLabel18);
                                                txtField.setBounds(185, 150, 200, 25);
                                                frame1.add(txtField);
                                                button.setBounds(185, 200, 200, 25);
                                                frame1.add(button);
                                                button1.setBounds(185, 250, 200, 25);
                                                frame1.add(button1);
                                                
                                                //if user clicks "Ok"
                                                button.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //initializes deposit amount variable
                                                        double depositAmount = Double.parseDouble((txtField.getText()));
                                                        
                                                        //if deposit amount is greatet than 0
                                                        if(depositAmount > 0)
                                                        {
                                                            //calculates the new savings balance running in the program
                                                            myTransactions.savingsDeposit(depositAmount);
                                                            
                                                            //uses graphics to display restart option
                                                            JFrame frame16 = new JFrame("restart");
                                                            JLabel mainLabel19 = new JLabel("Transaction completed.");
                                                            JLabel mainLabel20 = new JLabel("Would you like to perform another transaction?");
                                                            JButton button78 = new JButton("Yes");
                                                            JButton button79 = new JButton("No");
                                                            frame16.setLayout(null);
                                                            frame16.setVisible(true);
                                                            frame16.setSize(600,450);
                                                            frame16.setResizable(false);
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            mainLabel19.setBounds(170, 35, 400, 50);
                                                            mainLabel19.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel19.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel19);
                                                            mainLabel20.setBounds(90, 100, 400, 50);
                                                            mainLabel20.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            mainLabel20.setForeground(Color.GREEN);
                                                            frame16.add(mainLabel20);
                                                            button78.setBounds(185, 230, 200, 25);
                                                            frame16.add(button78);
                                                            button79.setBounds(185, 310, 200, 25);
                                                            frame16.add(button79);

                                                            //if user clicks "Yes"
                                                            button78.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes restart, transferamount, chequing, and deposit window
                                                                    frame16.dispose();
                                                                    frame1.dispose();
                                                                    frame6.dispose();
                                                                    frame16.dispose();
                                                                }
                                                            });
                                                            
                                                            //if user clicks "No"
                                                            button79.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    //closes program
                                                                    System.exit(0);
                                                                }
                                                            });
                                                        }
                                                        else
                                                        {
                                                            //prints an error message
                                                            Label.setText("Insufficient Funds.");
                                                            Label.setBounds(215, 300, 400, 50);
                                                            Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                                                            Label.setForeground(Color.RED);
                                                            frame1.add(Label);
                                                        }
                                                    }
                                                });
                                                
                                                //if user clicks "Cancel"
                                                button1.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        //close transferamount window
                                                        frame1.dispose();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                
                                //if user clicks "Back"
                                button23.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        //closes deposit window
                                        frame6.dispose();
                                    }
                                });
                            }
                        });
                        
                        //if user cicks "Exit"
                        button6.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //establishes stream the filewriters and printwriters will use
                                FileWriter fw;
                                FileWriter fw1;
                                FileWriter fw2;
                                FileWriter fw3;
                                PrintWriter pw;
                                PrintWriter pw1;
                                PrintWriter pw2;
                                PrintWriter pw3;
                                
                                //exception handler
                                try
                                {
                                    //creates file object to read chequing balance, declaring scanner object, and initalizes double variable
                                    File nf = new File("ChequingBalance.txt");
                                    Scanner scanN;
                                    double chequing = 0.00;
                                    
                                    //creates file object to read savings balance, declaring scanner object, and initializes string variable
                                    File nf1 = new File("SavingsBalance.txt");
                                    Scanner scanN1;
                                    double savings = 0.00;
                                    
                                    //creates file object to read credit card balance, declaring scanner object, and initializes string variable
                                    File nf2 = new File("CreditCardBalance.txt");
                                    Scanner scanN2;
                                    double creditCard = 0.00;
                                    
                                    //exception handler
                                    try
                                    {
                                        //connects Scanners to Files and obtains last lines of input
                                        scanN = new Scanner(nf);
                                        scanN1 = new Scanner(nf1);
                                        scanN2 = new Scanner(nf2);
                                        while(scanN.hasNext())
                                        {
                                            chequing = scanN.nextDouble();
                                        }
                                        while(scanN1.hasNext())
                                        {
                                            savings = scanN1.nextDouble();
                                        }
                                        
                                        while(scanN2.hasNext())
                                        {
                                            creditCard = scanN2.nextDouble();
                                        }   
                                        
                                        //close scanners
                                        scanN.close();
                                        scanN1.close();
                                        scanN2.close();
                                    }
                                    catch(IOException t)
                                    {
                                        //print an error message
                                        System.out.println("File error: " + t.getMessage());
                                    }
                                    //specifiying files to be appended, attaching printwriters to it, initializes total variables, and prints total balances to its files
                                    fw = new FileWriter("ChequingBalance.txt", true);
                                    pw = new PrintWriter(fw);
                                    double chequingTotal = chequing + myTransactions.getChequingBalance();
                                    pw.println();
                                    pw.println(twoDigit.format(chequingTotal));
                                    
                                    fw1 = new FileWriter("SavingsBalance.txt", true);
                                    pw1 = new PrintWriter(fw1);
                                    double savingsTotal = savings + myTransactions.getSavingsBalance();
                                    pw1.println(twoDigit.format(savingsTotal));
                                    
                                    fw2 = new FileWriter("CreditCardBalance.txt", true);
                                    pw2 = new PrintWriter(fw2);
                                    double creditCardTotal = creditCard + myTransactions.getCreditCardBalance();
                                    pw2.println(twoDigit.format(creditCardTotal));
                                    
                                    fw3 = new FileWriter("totalBalance.txt", true);
                                    pw3 = new PrintWriter(fw3);
                                    pw3.println(twoDigit.format(chequingTotal + savingsTotal + creditCardTotal));
                                    
                                    //closes the file streams
                                    pw.close();
                                    pw1.close();
                                    pw2.close();
                                    pw3.close();
                                }
                                catch(IOException k)
                                {
                                    //prints an error message
                                    System.out.println("File error" + k.getMessage());
                                }
                                //closes program
                                System.exit(0);
                            }
                        });   
                        //closes login window
                        frame1.dispose();
                    }
                    else
                    {
                        //prints an error message
                        Label.setText("Incorrect Login.");
                        Label.setBounds(215, 300, 400, 50);
                        Label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                        Label.setForeground(Color.RED);
                        frame1.add(Label);
                    }
                    //closes scanners
                    scanSF.close();
                    scanSF1.close();
                }
                catch(IOException k)
                {
                    //prints an error message
                    System.out.println("File error: " + k.getMessage());
                }
            }
        });
    }//end of main
    
    /**
     * sortStringExchange
     * This method uses an exchange sort algorithm to sort an array of Strings
     * @param locations - the array of Strings to be sorted
     */
    public static void sortStringExchange(String[] locations)
    {
        int i, j;
        String temp;
        for(i = 0; i < locations.length - 1; i++)
        {
            for(j = i + 1; j < locations.length; j++)
            {
                if(locations[i].compareToIgnoreCase(locations[j]) > 0)   
                {
                    temp = locations[i];
                    locations[i] = locations[j];
                    locations[j] = temp;
                }
            }
        }
    }//end of sortStringExchange
    
    /**
     * atm
     * This method prints the first and last String variable from a String array
     * @param locations - the array of Strings
     * @return distance - a message stating closest and farthest atm location
     */
    public static String atm(String[] locations)
    {
        String closest = locations[1];
        String farthest = locations[6];
        String distance = "The closest location to this ATM is at " + closest + ".\n The farthest location to this ATM is at " + farthest + ".";
        return distance;
    }//end of atm
    
}//end of class
