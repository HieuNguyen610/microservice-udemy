package hieu.accountservice.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Builder
@Setter
public class AccountDto {

    private Long id;

    private String name;

    private String password;

    private String username;

    private Set<String> roles;
}
