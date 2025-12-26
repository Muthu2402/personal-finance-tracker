package com.muthu.personal_finance_tracker.service;

import com.muthu.personal_finance_tracker.model.Expense;
import com.muthu.personal_finance_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    // Constructor Injection (BEST PRACTICE)
    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Expense> getAll() {
        return repository.findAll();
    }

    @Override
    public Expense getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    @Override
    public Expense save(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
