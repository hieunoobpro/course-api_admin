package com.example.courseapi.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotNull(message = "name ko dc de trong")
    @NotEmpty(message = "ten khong dc de trog")
    private  String name;

    private String description;
    private String type;
    private List<String> topics;
}
