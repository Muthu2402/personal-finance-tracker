package com.muthu.personal_finance_tracker.repository;

import com.muthu.personal_finance_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// it tells about to talk with database layer.
// Automatic Error handling in DB
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{

}
