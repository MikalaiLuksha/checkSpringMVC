package by.pelar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public User(@NotBlank String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }
}
