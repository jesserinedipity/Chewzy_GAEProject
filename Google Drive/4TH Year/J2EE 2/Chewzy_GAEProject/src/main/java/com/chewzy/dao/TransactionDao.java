package com.chewzy.dao;

import com.chewzy.model.Transaction;

import java.util.List;

/**
 * Created by Misa on 10/3/2016.
 */
public interface TransactionDao {
    public List<Transaction> getAllTransactions() throws Exception;
    public Transaction getTransactionbyId(Long transID) throws Exception;
}
