package Lombok;

import lombok.*;

//@Setter
//@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

//@ToString //default
//@ToString(includeFieldNames = true,exclude = {"name"})
@ToString(includeFieldNames = true,of = {"id","name"})
@EqualsAndHashCode(of = {"id","name"})
public class Person {

    public int id;
    public String name;

}
