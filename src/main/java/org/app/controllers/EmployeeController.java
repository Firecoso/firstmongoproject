package org.app.controllers;

import org.app.exceptions.EmployeeServiceCannotBeNull;
import org.app.models.Employee;
import org.app.models.EmployeeDTO;
import org.app.services.EmployeeRepository;
import org.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"text/html"})
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/nuovo'>Test Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @GetMapping(value = "/nuovo")
    public String addEmployee() {
        String html = "";
        html += "<form method='POST' action='/insert'>" +
                "   <label>Codice</label><input type='text' name='code' /> "+
                "   <label>Nome completo</label><input type='text' name='fullname' /> "+
                "   <label>Data Iniziale</label> <input type='date' name='startDate' />"+
                "   <input type='submit' /> "+
                "</form>";
        return html;
    }

    @ResponseBody
    @PostMapping("/insert")
    public String testInsert(@ModelAttribute EmployeeDTO employeeDTO) throws EmployeeServiceCannotBeNull {


        Employee res= employeeService.save(employeeDTO);

        return "Inserted "+ res.getCode() + " "+ res.getFullName();
    }
}
