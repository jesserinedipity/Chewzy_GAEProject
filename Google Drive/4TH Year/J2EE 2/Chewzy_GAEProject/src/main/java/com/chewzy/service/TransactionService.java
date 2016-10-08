package com.chewzy.service;

import com.chewzy.model.Transaction;

import java.util.List;

/**
 * Created by Misa on 10/3/2016.
 */
public interface TransactionService {

    public List<Transaction> getAllTransactions();
    public Transaction getTransactionbyId(Long transId);
}
