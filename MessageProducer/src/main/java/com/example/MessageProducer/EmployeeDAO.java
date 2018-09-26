package com.example.MessageProducer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDAO extends JpaRepository<Employee, Long>
{

	public List<Employee> findByName(String name);
}


