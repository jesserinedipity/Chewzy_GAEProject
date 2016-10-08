package com.chewzy.controller;

import com.chewzy.model.Transaction;
import com.chewzy.service.TransactionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Misa on 10/3/2016.
 */

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionSrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/getTransactions",  method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactions(){
        String addTransactionJson="";

        List<Transaction> transactionList = transactionSrvc.getAllTransactions();
        Gson gson = new Gson();
        addTransactionJson = gson.toJson(transactionList);

        if(transactionList.isEmpty()){
            return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getTransaction/{transaction_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("transaction_id") Long transaction_id){
        System.out.println("Fetching DishCategory with id " + transaction_id);
        String transactionJson="";
        Transaction transaction = transactionSrvc.getTransactionbyId(transaction_id);
        if(transaction==null){
            System.out.println("Transaction with id " + transaction_id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        transactionJson = gson.toJson(transaction);

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }
}
