package com.revature.grademanagementsystemstudentms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystemstudentms.configuration.MessageConstants;
import com.revature.grademanagementsystemstudentms.exception.ServiceException;
import com.revature.grademanagementsystemstudentms.modal.Student;
import com.revature.grademanagementsystemstudentms.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	@Transactional
    public Student addstudent(String name, int regno) throws ServiceException {
        Student student = new Student();
        student.setName(name);
        student.setRegno(regno);         
        try {
            student = studentRepository.save(student);
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
            throw new ServiceException(MessageConstants.UNABLE_TO_INSERT);
        }        
        
        return student;
    }
}
