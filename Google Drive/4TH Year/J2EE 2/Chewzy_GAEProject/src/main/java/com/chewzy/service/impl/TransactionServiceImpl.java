package com.chewzy.service.impl;

import com.chewzy.dao.TransactionDao;
import com.chewzy.model.Transaction;
import com.chewzy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 10/3/2016.
 */
@Component("transactionSrvc")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactionList = null;
        try {
            transactionList = transactionDao.getAllTransactions();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactionList;
    }

    public Transaction getTransactionbyId(Long transId){
        Transaction transaction = null;
        try {
            transaction = transactionDao.getTransactionbyId(transId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;
    }


}
