package com.sut62.team01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sut62.team01.entity.*;
import com.sut62.team01.repository.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RoomBookingTests {

    private Validator validator;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private RoomBookingRepository roomBookingRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void b6010201_testInsertDataOk() {
        // create oj
        RoomBooking roomBooking = new RoomBooking();
        // necessary for roombooking
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

        // necessary for PackageManagement
        roomBooking.setStudent(students);
        roomBooking.setRooms(rooms);
        roomBooking.setBed(bed);
        roomBooking.setEmail("pakorn@hotmail.com");
        roomBooking.setRoombookingDate(new Date());
        roomBooking = roomBookingRepository.saveAndFlush(roomBooking);

        Optional<RoomBooking> found = roomBookingRepository.findById(roomBooking.getId());
        assertEquals(roomBooking, found.get());
    }

    @Test
    void b6010201_testStudentsMustNotBeNull() {
         // create oj
         // necessary for roombooking
         Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
         students = studentsRepository.saveAndFlush(students);
         Rooms rooms = new Rooms("7133");
         rooms = roomsRepository.saveAndFlush(rooms);
         Bed bed = new Bed("What's branch?");
         bed = bedRepository.saveAndFlush(bed);
 
        

         RoomBooking roomBooking = new RoomBooking();
         roomBooking.setStudent(null);
         roomBooking.setRooms(rooms);
         roomBooking.setBed(bed);
         roomBooking.setEmail("pakorn@hotmail.com");
         roomBooking.setRoombookingDate(new Date());


        Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("student", result.iterator().next().getPropertyPath().toString());

    }

    @Test
    void b6010201_testRoomsMustNotBeNull() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setStudent(students);
        roomBooking.setRooms(null);
        roomBooking.setBed(bed);
        roomBooking.setEmail("pakorn@hotmail.com");
        roomBooking.setRoombookingDate(new Date());
        
       Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

       assertEquals(1, result.size());
       assertEquals("must not be null", result.iterator().next().getMessage());
       assertEquals("rooms", result.iterator().next().getPropertyPath().toString());

    }

    @Test
    void b6010201_testBedMustNotBeNull() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

       

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setStudent(students);
        roomBooking.setRooms(rooms);
        roomBooking.setBed(null);
        roomBooking.setEmail("pakorn@hotmail.com");
        roomBooking.setRoombookingDate(new Date());
        

       Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

       assertEquals(1, result.size());
       assertEquals("must not be null", result.iterator().next().getMessage());
       assertEquals("bed", result.iterator().next().getPropertyPath().toString());

    }

    @Test
    void b6010201_testEmailMustNotBeNull() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

       

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setStudent(students);
        roomBooking.setRooms(rooms);
        roomBooking.setBed(bed);
        roomBooking.setEmail(null);
        roomBooking.setRoombookingDate(new Date());
        

       Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

       assertEquals(1, result.size());
       assertEquals("must not be null", result.iterator().next().getMessage());
       assertEquals("email", result.iterator().next().getPropertyPath().toString());

    }

    @Test
    void b6010201_testDateMustNotBeNull() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

       

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setStudent(students);
        roomBooking.setRooms(rooms);
        roomBooking.setBed(bed);
        roomBooking.setEmail("pakorn@hotmail.com");
        roomBooking.setRoombookingDate(null);
        

       Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

       assertEquals(1, result.size());
       assertEquals("must not be null", result.iterator().next().getMessage());
       assertEquals("roombookingDate", result.iterator().next().getPropertyPath().toString());

    }

    
    @Test
    void b6010201_testEmailIsCorrect() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

       

        RoomBooking roomBooking = new RoomBooking(students,rooms,bed,"pakorn&hotmail.com");

       Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

       assertEquals(1, result.size());
       assertEquals("must be a well-formed email address", result.iterator().next().getMessage());
       assertEquals("email", result.iterator().next().getPropertyPath().toString());

    }
    
    @Test
    void b6010201_testEmailNotLessThanMin() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

        RoomBooking roomBooking = new RoomBooking(students,rooms,bed,"a@a.com");

        Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

        assertEquals(1, result.size());
        assertEquals("size must be between 10 and 30", result.iterator().next().getMessage());
        assertEquals("email", result.iterator().next().getPropertyPath().toString());

    }

    @Test
    void b6010201_testEmailNotGreaterThanMax() {
        Students students = new Students("Pontep Thaweesup", "B6000783","วิศวกรรมศาสตร์", "pontep", "1234");
        students = studentsRepository.saveAndFlush(students);
        Rooms rooms = new Rooms("7133");
        rooms = roomsRepository.saveAndFlush(rooms);
        Bed bed = new Bed("What's branch?");
        bed = bedRepository.saveAndFlush(bed);

        RoomBooking roomBooking = new RoomBooking(students,rooms,bed,"aaaaaaaaaaaaaaaaaaa@aaaaaaaaaaaaaaaaaaaaaa.com");

        Set<ConstraintViolation<RoomBooking>> result = validator.validate(roomBooking);

        assertEquals(1, result.size());
        assertEquals("size must be between 10 and 30", result.iterator().next().getMessage());
        assertEquals("email", result.iterator().next().getPropertyPath().toString());

    }

}