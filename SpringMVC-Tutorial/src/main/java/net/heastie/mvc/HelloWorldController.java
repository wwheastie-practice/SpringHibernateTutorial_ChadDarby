package net.heastie.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    //Need a controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //Controller method to read from data
    //Add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        //Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //Convert the data to all upper case
        theName = theName.toUpperCase();

        //Create message
        String result = "Yo! " + theName;

        //Add message to the model
        model.addAttribute("message", result);

        return "helloworld";

    }
}
