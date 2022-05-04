package com.shubham.repository;

import com.shubham.model.Student;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
