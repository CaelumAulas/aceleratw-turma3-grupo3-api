package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.models.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserForm {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String user;

    @NotNull
    @NotEmpty
    @Length(min = 6)
    private String password;

    public static User converter(UserForm user) {
        return new User(user.getUser(), user.getPassword());
    }
}
