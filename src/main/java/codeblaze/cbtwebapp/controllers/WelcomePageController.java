package codeblaze.cbtwebapp.controllers;

import codeblaze.cbtwebapp.model.Student;
import codeblaze.cbtwebapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Controller
public class WelcomePageController {
    StudentService studentService;public String timeString;
int second=0,minute=0,hour=0;int i=0;
    public WelcomePageController(StudentService studentService) {
        this.studentService = studentService;
    }
  //  @GetMapping("/storeddata")
  //public String getStoredData(Model model){
  //        return "storeddata";
  //    }
    @GetMapping("/welcomepage")
    public String getWelcomePage(Model model){
        return "welcomepage";
    }

    @GetMapping("/signup/new")
    public  String getSignUpPage(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "student_create_profile";
    }
@PostMapping("/storeddata")
public String storeData(@ModelAttribute("student") Student student,Model model,Long id){
studentService.storeStudentData(student);
        Student person=studentService.storeStudentData(student);
return "redirect:/storeddata";
}
@GetMapping("/storeddata")
    public String getStoredData(Model model){
        model.addAttribute("students",studentService.getAllStudent());

        return "storeddata";
}
    //recall that name attribute must match with field attribute in input web element
@GetMapping("/storeddata/edit/{id}")
    public String getEditPageById(@PathVariable Long id,Model model){
model.addAttribute("student",studentService.getStudentById(id));
return "edit_storeddata";
}
@PostMapping("/storeddata/{id}")
    public String updateDataPage(@ModelAttribute("student") Student student,@PathVariable Long id,Model model){
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());
        studentService.updateStudentData(existingStudent);
        return "redirect:/storeddata";
}
@GetMapping("/storeddata/{id}")
    public  String deleteStudentData(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/storeddata";
}
@GetMapping("/studentloginpage")
    public String getStudentLoginPage(Model model){
Student student=new Student();
model.addAttribute("student",student);
        return "studentlogin";
}
@PostMapping("/studentloginpage")
    public  String authenticateStudent(@ModelAttribute("student") Student student, Model model){
        List<Student> memberOfStudent=studentService.getAllStudent();
        if(memberOfStudent.contains(student.getId())){
            return "redirect:/TestArena";
        }
        else {
            return "You are not a student";
        }

}
    @GetMapping("/TestArena")
    public String getTestArena(Model model){
        Thread startClock=new Thread(new Runnable(){
            public void run(){
                for(;;){
                    try {
                        Thread.sleep(1000);
                        second = second + 1;
                        if (second == 60){
                            minute=1;
                        }
                        if(minute==60){
                            hour=1;
                        }
                    }catch (Exception exception){

                    }
                    timeString=hour+":"+minute+":"+second;
                }
            }
        });startClock.start();
        model.addAttribute("time",timeString);
        return "TestArena";
    }

}
