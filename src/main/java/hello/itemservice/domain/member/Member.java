package hello.itemservice.domain.member;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
    private Long id;

    @NotNull
    private String loginId;
    @NotNull
    private String name;
    @NotNull
    private String password;
}
