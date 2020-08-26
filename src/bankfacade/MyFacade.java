/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

/**
 *
 * @author YUME
 */
public class MyFacade {
    private ArrayList<CustomerIf> customerList = new ArrayList();
    
    MyFacade(){
        // customer 1
       ArrayList<AccountIf> cust1Accounts = new ArrayList();
       AccountIf acc1 = new BankAccount(44444);
       acc1.deposit(500);
       cust1Accounts.add(acc1);
       acc1 = new BankAccount(33333);
       acc1.deposit(1000);
       cust1Accounts.add(acc1);
       CustomerIf cust1 = new BankCustomer("John", cust1Accounts);
       // customer 2
       ArrayList<AccountIf> cust2Accounts = new ArrayList();
       AccountIf acc2 = new BankAccount(22222);
       acc2.deposit(500);
       cust2Accounts.add(acc2);
       acc2 = new BankAccount(11111);
       acc2.deposit(1000);
       cust2Accounts.add(acc2);
       CustomerIf cust2 = new BankCustomer("Jame", cust2Accounts);
       customerList.add(cust2);
       customerList.add(cust1);
    }

    public  void doDeposit(double amt, CustomerIf cust, int accNo){
        cust.getAccount(accNo).deposit(amt);
        
    }
    
    public  void getBankAccount(CustomerIf cust, int accNo){
        AccountIf account = cust.getAccount(accNo);
        System.out.println("Account Number: " + account.getAccountNumber() + " has " + account.getBalance());
        
    }
    
    public  CustomerIf getBankCustomer(String custName){
        CustomerIf customer = null;
        for (int i = 0 ; i < customerList.size (); i++) {
            if (customerList.get(i).getCustomerName()== custName) {
                customer = customerList.get(i);
                break;
            }
        }
        customer.getAllAccounts();
        ArrayList<AccountIf> accounts = customer.getAllAccounts();
        for(AccountIf account : accounts) {
           System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
        
        return customer;
        
    }
    
}
