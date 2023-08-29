package com.example.courseapi.response;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CourseResponse {
    private Course course;
    private User user;

    public CourseResponse() {

    }

    public void setMessage(String course_not_found) {
    }
}
