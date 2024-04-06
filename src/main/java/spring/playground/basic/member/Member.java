package spring.playground.basic.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Member {

    private Long id;
    private String name;
    private Grade grade;


}
