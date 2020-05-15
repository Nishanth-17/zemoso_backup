package aopdemo.dao;

import aopdemo.java.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    public void addAccount(){
        System.out.println(getClass() +" : DOING MY DB WORK: ADDING AN ACCOUNT");
    }
    public void addAccount(boolean b){
        System.out.println(getClass() +" : Function having a parameter ");
    }
    public List<Account> findAccounts(){
        List<Account> myAcc=new ArrayList<>();
        Account acc1=new Account("Nish","Gold");
        Account acc2=new Account("Disco","Platinum");
        myAcc.add(acc1);
        myAcc.add(acc2);

        return myAcc;
    }
}
