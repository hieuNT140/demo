package Lombok;


import lombok.*;

@Data
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true,exclude = {"address"})
public class Teacher extends Person {
    @NonNull
    public String address;
}
