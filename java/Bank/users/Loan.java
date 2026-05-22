package users;
import java.util.Scanner;
import pages.Pages;
import pages.bankExceptions.*;
import java.util.InputMismatchException;
import ui.UI;

public class Loan {
 double newLoan = 0;
 double interestLoan=0;
 int timeLoan = 0;
 double repayLoanAmount=0;

    Pages page = new Pages();
    UsersStorage accountCheck;
    
    public Loan(UsersStorage accountCheck) {
        this.accountCheck = accountCheck;
    }

    //taking loan
    public void takingLoan(Scanner sc,String currentUser, String accountType){
        
        if(accountType.equals("personal")){
            page.loanRulesScreenPersonal();
        } else {
            page.loanRulesScreenSavings();
        }
                            
            try{
                System.out.print("\n\nAmount for loan: ");
                newLoan = sc.nextDouble();
                sc.nextLine();

                    if(newLoan==0){
                    } else if(newLoan<0){
                        throw new invalidAmount();
                    } else if( accountType.equals("personal") && (newLoan <100 || newLoan > 50000)){
                        throw new invalidAmount();
                    } else if( accountType.equals("saving") && (newLoan <100 || newLoan > 7000)){
                        throw new invalidAmount();
                    }else {

                        if(accountType.equals("personal")){
                            interestLoan = (newLoan*0.2)+newLoan;
                        } else if(accountType.equals("saving")){
                            interestLoan = (newLoan*0.13)+newLoan;
                        }

                        System.out.print("\nTotal duration to repay the loan in months(3, 6, 12, 24): ");
 
                        timeLoan = sc.nextInt();
                        sc.nextLine();

                        if(timeLoan == 3 || timeLoan == 6 || timeLoan == 12 || timeLoan == 24){
                            double addLoan = accountCheck.loan(currentUser);
                            newLoan+=addLoan;
                            accountCheck.updateLoan(currentUser, interestLoan);
                            accountCheck.saveToFile();
                            System.out.println("\033[1m\033[32mSuccesfully loan given.\033[0m");
                        } else {
                            throw new invalidDuration();
                        }
                    }
            } catch(invalidDuration | invalidAmount  e ) {
                System.out.println(e.getMessage());
            } catch(InputMismatchException e){
                System.out.println("\033[1m\033[31mNumbers only.\033[0m");
            }

            page.showBalance(currentUser, accountCheck);
            page.showLoan(currentUser, accountCheck);  
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


                if(choose==0){
                } else {
                        page.showBalance(currentUser, accountCheck);
                        System.out.print("Amount repaying: ");
                    try{
                        repayLoanAmount = sc.nextDouble();
                        sc.nextLine();
                            if(repayLoanAmount==0){
                            } else if(repayLoanAmount<0){
                                throw new invalidAmount();
                            } else if(repayLoanAmount>loan){
                                page.invalidInput();
                            } else {
                                if(choose==1){
                                minusLoan-=repayLoanAmount;
                                accountCheck.updateLoan(currentUser, minusLoan);
                                accountCheck.saveToFile();
                                System.out.println("Loan repayed.");  
                                } else {
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
                                  
                            }
                        } catch(invalidDuration | invalidAmount  e ) {
                            System.out.println(e.getMessage());
                        } catch(InputMismatchException e){
                            System.out.println("\033[1m\033[31mNumbers only.\033[0m");
                        }
                    
                }
                
            }
        page.showLoan(currentUser, accountCheck);
        page.showBalance(currentUser, accountCheck);
        UI.pause(sc);
    }
}
