package com.example.MessageConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageConsumer {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consumes/{param}")
	public Employee consume(@PathVariable("param")int param){
		String url="http://localhost:1234/emp/select/"+param;        //url of producer
		Employee emp=restTemplate.getForObject(url,Employee.class);
		return emp;
	}
	
	@GetMapping("/consumeInsert/{param}")                  
	public Employee consumeInsert(@PathVariable("param")int param){
		//String url="http://localhost:1234/emp/insert/"+param;        //url of producer
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Employee emp=new Employee();
		//HttpEntity<Employee> emp2=new HttpEntity<Employee>(emp,headers);
		emp.setAge(18);
		emp.setId(150L);
		emp.setName("Krishna");
		emp.setSalary(99999);
		HttpEntity<Employee> emp2=new HttpEntity<Employee>(emp,headers);
		restTemplate.postForObject("http://localhost:1234/emp/insert", emp2, String.class);
		return emp;
	}
}
