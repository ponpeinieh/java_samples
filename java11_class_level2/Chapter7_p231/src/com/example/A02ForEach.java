package com.example;

import java.util.List;

/**
 *
 * @author oracle
 */
public class A02ForEach {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n=== Print List with forEach ===");
        tList.forEach(t -> t.printSummary());
    }

}
