package com.example.MessageProducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value="/emp")
@RestController
@RequestMapping("/emp")
public class EmployeeServices {
	
	@Autowired
	EmployeeDAO employeeDao;
	ArrayList<Employee> emplist=new ArrayList<Employee>();
	
	@GetMapping(value="/select/{id}",produces=MediaType.APPLICATION_XML_VALUE)            //value is used to uniquely identify the request
	//@RequestMapping(path="/select",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public Employee readEmployee(@PathVariable("id")int id){   //Reading property so use GET
		Employee emp=new Employee();
		emp.setAge(20);
		emp.setName("Pranav");
		emp.setSalary(30000);
		System.out.println(id);
		return emp;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee insertEmployee(@RequestBody Employee emp){   //Reading property so use GET
		employeeDao.save(emp);
		System.out.println(emp);
		return emp;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="/insert/MultipleEmp",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Employee> insertEmployeeMultipleEmp(@RequestBody ArrayList<Employee> emp){   //Reading property so use GET
		//ArrayList<Employee> emplist=new ArrayList<Employee>();
		emplist=emp;
		employeeDao.saveAll(emplist);
		System.out.println(emp);
		return emp;
	}
	@GetMapping(value="/selectMulti/{age}",produces=MediaType.APPLICATION_XML_VALUE)  
	//@GetMapping(value="/selectMulti",produces=MediaType.APPLICATION_XML_VALUE)  
	public Employee readMultipleEmployee(@PathVariable("age")int age){        //emplist based on age==id
	//public Employee readMultipleEmployee(){
		Employee emp=new Employee();
		for(Employee emp1:emplist){
			if(emp1.getAge()==age)
				return emp1;
			
		}
		return emp;
		
	}
	@ExceptionHandler(Exception.class)
	public void handler(HttpServletResponse res){
		try{
			res.sendRedirect("http://google.com");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	

	@GetMapping(value="/retrieveAll")
	public List<Employee> retrieveEmployee(){   //Reading property so use GET
		
		System.out.println(employeeDao.findAll());
		
		List<Employee> empList=employeeDao.findAll();
		
		return empList;
		
	}
	
	
	
	@GetMapping(value="/retrieveOne/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public Employee retrieveOneEmployee(@PathVariable("id")long id){   //Reading property so use GET
		
		return employeeDao.getOne(id);
		
	}
	@GetMapping(value="/deleteOne/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public void deleteEmployee(@PathVariable("id")long id){   //Reading property so use GET
		
		if(employeeDao.existsById(id)){
			employeeDao.deleteById(id);
		}
		else{
			System.out.println("Record for "+id+"not exist");
		}
		
	}
	
	
	@GetMapping(value="/delete")
	public void delete(){   //Reading property so use GET
		
		employeeDao.deleteAll();
		
	}
	
	@PostMapping(value="/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@PathVariable("id")long id,@RequestBody Employee emp){   //Reading property so use GET
		  
			
		
		if(employeeDao.existsById(id)){
			employeeDao.save(emp);
			System.out.println(emp);
		}
		else{
			System.out.println("Record for "+id+"not exist");
		}
		
	}
	
	
	@GetMapping(value="/findByName/{Name}")//,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> retrieveByName(@PathVariable("Name") String Name)
	{
		
		
		
		//List<Employee> returnList = null;
		List<Employee> eList=employeeDao.findByName(Name);
		System.out.println(eList);
		return eList;//returnList;
		
	}
	
}
