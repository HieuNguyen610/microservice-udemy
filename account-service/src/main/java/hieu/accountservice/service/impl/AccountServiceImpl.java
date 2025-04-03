package hieu.accountservice.service.impl;

import hieu.accountservice.entity.Account;
import hieu.accountservice.model.AccountDto;
import hieu.accountservice.repository.AccountRepository;
import hieu.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;

    @Override
    public void add(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        accountRepository.save(account);
    }

    @Override
    public void update(AccountDto accountDto) {
        Account account = findAccountById(accountDto.getId());
        modelMapper.typeMap(AccountDto.class, Account.class)
                        .addMappings(mapper -> mapper.skip(Account::setPassword))
                                .map(accountDto, account);
        accountRepository.save(account);
    }

    private Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public void updatePassword(AccountDto accountDto) {
        Account account = findAccountById(accountDto.getId());
        accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        Account account = findAccountById(id);
        accountRepository.delete(account);
    }

    @Override
    public List<AccountDto> getAll() {
        return convertEntitiesToDtos(accountRepository.findAll());
    }

    @Override
    public AccountDto getById(Long id) {
        return convertEntityToDto(findAccountById(id));
    }

    private AccountDto convertEntityToDto(Account entity) {
        return modelMapper.map(entity, AccountDto.class);
    }

    private List<AccountDto> convertEntitiesToDtos(List<Account> entities) {
        return entities.stream().map(this::convertEntityToDto).toList();
    }
}
