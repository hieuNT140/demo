package RestAssured;

import com.google.gson.annotations.SerializedName;

public class ObjectRespond {
    @SerializedName("Name")
    public String name;

    @SerializedName("Job")
    public String job;

    @SerializedName("Rank")
    public String rank;

    @SerializedName("Id")
    public String id;

    @SerializedName("CreatedAt")
    public String createdAt;
}
