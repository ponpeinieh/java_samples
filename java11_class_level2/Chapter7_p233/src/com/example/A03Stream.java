package com.example;

import java.util.List;

/**
 *
 * @author oracle
 */
public class A03Stream {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n== CA Transations Lambda ==");
        tList.stream()
                .filter(t -> t.getState().equals(State.CA))
                //.filter(t -> t.getState().getStr().equals("CA"))
                .forEach(t -> t.printSummary());
    }
}
