package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/courses")
public class AdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public String getCourseDetails(@PathVariable("id") Long id, Model model) {
        Integer intValue = Math.toIntExact(id);
        Course course = courseService.getCourse(intValue).getCourse();
        if (course == null) {
            return "redirect:/admin/courses"; // Chuyển hướng về trang danh sách khóa học nếu không tìm thấy khóa học
        }
        model.addAttribute("course", course);
        return "course-details"; // Trả về tên template hiển thị chi tiết khóa học
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        Integer intValue = Math.toIntExact(id);
        courseService.deleteCourse(intValue);
        return ResponseEntity.ok("Course deleted successfully.");
    }

    @PostMapping("/{id}/update")
    public String updateCourse(@PathVariable("id") Integer id, @ModelAttribute("course") Course updatedCourse) {
        Integer intValue = Math.toIntExact(id);
        Course course = courseService.getCourse(intValue).getCourse();
        if (course == null) {
            return "redirect:/admin/courses"; // Chuyển hướng về trang danh sách khóa học nếu không tìm thấy khóa học
        }
        // Cập nhật thông tin của khóa học
        course.setName(updatedCourse.getName());
        course.setDescription(updatedCourse.getDescription());
        course.setTopics(updatedCourse.getTopics());
        course.setType(updatedCourse.getType());
        course.setUserId(updatedCourse.getUserId());

        courseService.saveCourse(course);
        return "redirect:/admin/courses/" + id; // Chuyển hướng về trang chi tiết khóa học sau khi cập nhật thành công
    }

    @PostMapping("/{id}/upload-thumbnail")
    public String uploadThumbnail(@PathVariable("id") Integer id, @RequestParam("thumbnail") MultipartFile thumbnail) {
        Integer intValue = Math.toIntExact(id);
        Course course = courseService.getCourse(intValue).getCourse();
        if (course == null) {
            return "redirect:/admin/courses"; // Chuyển hướng về trang danh sách khóa học nếu không tìm thấy khóa học
        }

        return "redirect:/admin/courses/" + id; // Chuyển hướng về trang chi tiết khóa học sau khi upload thành công
    }
    @PostMapping("/create")
    public String createCourse(@ModelAttribute("course") Course course) {
        // Thực hiện lưu khóa học mới vào cơ sở dữ liệu
        courseService.saveCourse(course);
        return "redirect:/admin/courses"; // Chuyển hướng về trang danh sách khóa học sau khi tạo thành công
    }
}
