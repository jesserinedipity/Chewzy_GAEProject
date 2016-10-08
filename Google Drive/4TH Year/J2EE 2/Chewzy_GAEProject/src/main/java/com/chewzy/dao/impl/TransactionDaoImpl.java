package com.chewzy.dao.impl;

import com.chewzy.dao.TransactionDao;
import com.chewzy.model.Transaction;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 10/3/2016.
 */
@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao{

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactionList = ObjectifyService.ofy().load().type(Transaction.class).list();

        return transactionList;
    }

    public Transaction getTransactionbyId(Long transID){
        Transaction transaction = ObjectifyService.ofy().load().type(Transaction.class).id(transID).now();

        return transaction;
    }
}
