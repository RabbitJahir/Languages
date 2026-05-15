package users;
import java.util.Scanner;

import ui.UI;
import pages.Pages;

public class Loan {

    Pages page = new Pages();
    UsersStorage accountCheck;
    
    public Loan(UsersStorage accountCheck) {
        this.accountCheck = accountCheck;
    }

    //taking loan
    public void takingLoan(Scanner sc,String currentUser, String accountType){
        
        if(accountType.equals("personal")){

            page.loanRulesScreenPersonal();
                            
            try{
                System.out.print("\n\nAmount for loan: ");
                double newLoan = sc.nextDouble();
                sc.nextLine();
                    if(newLoan==0){

                    } else if(newLoan<0){
                    // throw new exceptions.error();
                        UI.pause(sc);
                        page.invalidInput();
                    } else if(newLoan <100 || newLoan > 50000){
                        System.out.print("\nLoan amount must be between $100 and $50,000.");
                        UI.pause(sc);
                        page.invalidInput();
                    }else {
                        System.out.print("\nTotal duration to repay the loan in months(3, 6, 12, 24): ");

                        int timeLoan = sc.nextInt();
                        sc.nextLine();

                        if(timeLoan == 3 || timeLoan == 6 || timeLoan == 12 || timeLoan == 24){
                            double addLoan = accountCheck.loan(currentUser);
                            newLoan+=addLoan;
                            accountCheck.updateLoan(currentUser, newLoan);
                            accountCheck.saveToFile();
                            System.out.println("\033[1m\033[32mSuccesfully loan given.\033[0m");
                        } else {
                            page.invalidInput();
                        }
            }
            } catch(Exception e ) {
                System.out.println("\033[1m\033[31mInvalid input! Please enter numbers only.\033[0m");
                sc.nextLine(); // clears the bad input
            }

            page.showBalance(currentUser, accountCheck);
            page.showLoan(currentUser, accountCheck);  

        }else if(accountType.equals("saving")){

            page.loanRulesScreenSavings();
                           
            try{
                System.out.print("\n\nAmount for loan: ");
                double newLoan = sc.nextDouble();
                sc.nextLine();
                    if(newLoan==0){

                    
                    } else if(newLoan<0){
                        // throw new exceptions.error();
                        UI.pause(sc);
                        page.invalidInput();
                    } else if(newLoan <100 || newLoan > 5000){
                        System.out.print("\nLoan amount must be between $100 and $5,000.");
                        UI.pause(sc);
                        page.invalidInput();
                    }else {
                        System.out.print("\nTotal duration to repay the loan in months(3, 6, 12, 24): ");
                        int timeLoan = sc.nextInt();
                        sc.nextLine();
                            if(timeLoan == 3 || timeLoan == 6 || timeLoan == 12 || timeLoan == 24){
                                double addLoan = accountCheck.loan(currentUser);
                                newLoan+=addLoan;
                                accountCheck.updateLoan(currentUser, newLoan);
                                accountCheck.saveToFile();
                                System.out.println("\033[1m\033[32mSuccesfully loan given.\033[0m");
                            } else {
                                page.invalidInput();
                            }
                    }
                } catch(Exception e ) {
                    System.out.println("\033[1m\033[31mInvalid input! Please enter numbers only.\033[0m");
                    sc.nextLine(); // clears the bad input
                }
                page.showBalance(currentUser, accountCheck);
                page.showLoan(currentUser, accountCheck);
        }

    }

    // repaying loan
    public void repayingLoan(Scanner sc,String currentUser){
        double currentBalance = accountCheck.balance(currentUser);
        double loan = accountCheck.loan(currentUser);
        double minusLoan = accountCheck.loan(currentUser);

        
            if(loan==0){
                System.out.println("\033[1m\033[33mCurrently no loan.\033[0m");
            } else {
                page.showLoan(currentUser, accountCheck);
                page.repayLoanScreen();

                int choose = sc.nextInt();
                sc.nextLine();

                switch(choose){
                case 0 ->{break;}
                case 1 ->{
                     if(loan ==0){
                        
                    } else {
                        page.showBalance(currentUser, accountCheck);
                        System.out.print("\n\nAmount repaying: ");
                    try{
                        double repayLoanAmount = sc.nextDouble();
                        sc.nextLine();
                            if(repayLoanAmount==0){
                                break;
                            } else if(repayLoanAmount<0){
                                page.invalidInput();
                            } else if(repayLoanAmount>loan){
                                page.invalidInput();
                            } else {      
                                // loan update  
                                minusLoan-=repayLoanAmount;
                                accountCheck.updateLoan(currentUser, minusLoan);
                                accountCheck.saveToFile();
                                System.out.println("Loan repayed.");    
                            }
                        }catch(Exception e) {
                            page.invalidInput();
                            sc.nextLine(); // clears the bad input
                        }
                    }
                }
                case 2 ->{
                    if(loan ==0){
                        System.out.println("\033[1m\033[33mCurrently no loan.\033[0m");
                    } else {
                        page.showBalance(currentUser, accountCheck);
                        System.out.print("\n\nAmount repaying: ");
                    try{
                        double repayLoanAmount = sc.nextDouble();
                        sc.nextLine();
                            if(repayLoanAmount==0){
                                break;
                            } else if(repayLoanAmount<0){
                                page.invalidInput();
                            } else if(repayLoanAmount > currentBalance){
                              System.out.println("\033[1m\033[33mInsufficient balance.\033[0m");
                            } else if(repayLoanAmount>loan){
                                page.invalidInput();
                            } else{
                               
                                //balance update
                                currentBalance-=repayLoanAmount;
                                accountCheck.updateBalance(currentUser, currentBalance);
                                accountCheck.saveToFile();
                                // loan update  
                                minusLoan-=repayLoanAmount;
                                accountCheck.updateLoan(currentUser, minusLoan);
                                accountCheck.saveToFile();
                                System.out.println("Loan repayed.");    
                            }
                        }catch(Exception e) {
                            page.invalidInput();
                            sc.nextLine(); // clears the bad input
                        }
                    }
                }
                default ->{
                    page.invalidInput();
                }
                        }
            }
            

                page.showLoan(currentUser, accountCheck);
                page.showBalance(currentUser, accountCheck);
                UI.pause(sc);
    }
}
