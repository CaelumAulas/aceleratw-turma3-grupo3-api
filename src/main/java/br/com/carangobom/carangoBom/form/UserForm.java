package br.com.carangobom.carangoBom.form;

import br.com.carangobom.carangoBom.model.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public static User converter(UserForm userform) {
        userform.setPassword(new BCryptPasswordEncoder().encode(userform.password));
        return new User(userform.getUser(), userform.getPassword());
    }
}

