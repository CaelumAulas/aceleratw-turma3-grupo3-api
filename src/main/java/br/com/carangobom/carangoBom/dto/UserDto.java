package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.models.User;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class UserDto {

    private Long id;
    private String user;

    public UserDto(User user) {
        this.user = user.getName();
        this.id = user.getId();
    }

    public static Page<UserDto> converter(Page<User> users) {
        return users.map(UserDto::new);
    }


}
