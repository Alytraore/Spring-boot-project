package com.alytraore.Springboot.project.controller;

import com.alytraore.Springboot.project.entity.Department;
import com.alytraore.Springboot.project.error.DepartmentNotFoundException;
import com.alytraore.Springboot.project.service.DepartmentService;
import com.alytraore.Springboot.project.service.DepartmentServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/department")
     public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
     }

     @GetMapping("/department/{id}")
     public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
     }

     @DeleteMapping("/department/{id}")
     public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
     }

     @PutMapping("/department/{id}")
     public Department updateDepartment(@PathVariable("id") Long departmentId,
                                        @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);

     }

     @GetMapping("/department/name/{name}")
     public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);

     }
}
