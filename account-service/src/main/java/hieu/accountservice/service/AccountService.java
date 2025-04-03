package hieu.accountservice.service;

import hieu.accountservice.model.AccountDto;

import java.util.List;

public interface AccountService {
    void add(AccountDto accountDto);
    void update(AccountDto accountDto);
    void updatePassword(AccountDto accountDto);
    void delete(Long id);
    List<AccountDto> getAll();
    AccountDto getById(Long id);
}
