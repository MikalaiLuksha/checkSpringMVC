package by.pelar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    private Role role;

    private Calendar addDate;

}
