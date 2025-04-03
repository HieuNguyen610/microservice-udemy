package hieu.accountservice.controller;

import hieu.accountservice.model.AccountDto;
import hieu.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account")
    public AccountDto addAccount(@RequestBody AccountDto accountDto) {
        accountService.add(accountDto);

        return accountDto;
    }

    @GetMapping("/accounts")
    public List<AccountDto> getAccounts() {
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public AccountDto getAccountById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @PutMapping("/account/{id}")
    public AccountDto updateAccount(@PathVariable Long id, @RequestBody AccountDto updatedAccountDto) {
        accountService.update(updatedAccountDto);
        return updatedAccountDto;
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
    }
}
