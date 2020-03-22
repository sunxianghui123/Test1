package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping(value = "/emps")
    public String getEmp(Model model)
    {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }
    //跳转到员工页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "add";
    }

    //添加员工
    @PostMapping(value = "/emp")
    public String addEmpl(Employee employee)
    {
        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //跳转修改页面
    @GetMapping(value = "/emp/{id}")
    public String toChangePage(@PathVariable("id") Integer id,Model model)
    {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "change";
    }

    //修改员工信息
    @PutMapping(value = "/emp")
    public String changeMessage(Employee employee)
    {
        System.out.println("修改信息"+employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
