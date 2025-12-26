package com.muthu.personal_finance_tracker.controller;

import com.muthu.personal_finance_tracker.model.Expense;
import com.muthu.personal_finance_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // Home page - list expenses
    @GetMapping
    public String index(Model model) {
        List<Expense> list = service.getAll();

        double total = list.stream()
                .mapToDouble(e -> e.getAmount() == null ? 0.0 : e.getAmount())
                .sum();

        model.addAttribute("expenses", list);
        model.addAttribute("total", total);

        return "index";
    }

    // Show add expense form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Expense expense = new Expense();
        expense.setDate(LocalDate.now());
        model.addAttribute("expense", expense);
        return "add-expense";
    }

    // Save new expense
    @PostMapping("/add")
    public String addExpense(
            @Valid @ModelAttribute("expense") Expense expense,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "add-expense";
        }
        service.save(expense);
        return "redirect:/";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Expense expense = service.getById(id);
        model.addAttribute("expense", expense);
        return "edit-expense";
    }

    // Save edited expense
    @PostMapping("/edit/{id}")
    public String editExpense(
            @PathVariable Long id,
            @Valid @ModelAttribute("expense") Expense expense,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "edit-expense";
        }
        expense.setId(id);
        service.save(expense);
        return "redirect:/";
    }

    // Delete expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
