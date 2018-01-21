package net.heastie.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        //Create objects
        Student theStudent = new Student();
        Countries countries = new Countries();
        FavoriteProgrammingLanguages favoriteProgrammingLanguages = new FavoriteProgrammingLanguages();

        //Add objects to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("favoriteLanguages", favoriteProgrammingLanguages);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //Log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        //Show Operating Systems
        for (String operatingSystem:theStudent.getOperatingSystems()) {
            System.out.println(operatingSystem);
        }

        return "student-confirmation";
    }

}
