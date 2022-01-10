package RestAssured;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectRequest {
    @SerializedName("Name em") // "name" tuong ung "Name em" trong json
    public String name;

    @SerializedName("Job em")
    public String job;

    @SerializedName("Rank em")
    public String rank;
}
