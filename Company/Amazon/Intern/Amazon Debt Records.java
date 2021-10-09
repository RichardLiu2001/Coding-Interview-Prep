import java.util.*;
import java.io.*;
import java.lang.*;

/**
class debtRecord{
    String borrower = ""; // importer
    String lender = ""; //exporter
    int amount = 0;
}
**/

public class Solution {
    List<String> minimumDebtMembers(List<debtRecord> records){
    
    HashMap<String, Integer> debt = new HashMap<>();	

    for (debtRecord d : records) {
    	String borrower = d.borrower;
    	String lender = d.lender;
    	int amount = d.amount;

    	int borrowerBalance = debt.getOrDefault(borrower, 0);
    	int lenderBalance = debt.getOrDefault(lender, 0);

    	debt.put(borrower, borrowerBalance - amount);
    	debt.put(lender, lenderBalance + amount);
    }

    List<String> result = new ArrayList<>();

    int minBalance = Integer.MAX_VALUE;

    for (String country : debt.keySet()) {
    	int balance = debt.get(country);
    	minBalance = Math.min(minBalance, balance);
    }

    if (minBalance >= 0) {
    	result.add("Nobody has a negative balance");
    	return result;
    }

    for (String country : debt.keySet()) {
    	int balance = debt.get(country);
    	if (balance == minBalance) {
    		result.add(country);
    	}
    }

    Collections.sort(result);
    return result;


    }
}
