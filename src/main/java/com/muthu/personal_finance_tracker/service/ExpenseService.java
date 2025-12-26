package com.muthu.personal_finance_tracker.service;

import com.muthu.personal_finance_tracker.model.Expense;
import java.util.List;

public interface ExpenseService {
     List<Expense> getAll();
     Expense getById(Long id);
     Expense save(Expense expense);
     void delete(Long id);
}
