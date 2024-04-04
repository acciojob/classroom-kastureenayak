package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        String name = student.getName();
        studentMap.put(name, student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        String name = teacher.getName();
        teacherMap.put(name, teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            List<String> students = teacherStudentMapping.get(teacher);
            students.add(student);
            teacherStudentMapping.put(teacher, students);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        Student name = studentMap.get(student);
        return name;
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        Teacher name=teacherMap.get(teacher);
        return name;
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        List<String> listOfStudents=teacherStudentMapping.get(teacher);
        return listOfStudents;
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String> studentList = new ArrayList<>();
        for(String student : studentMap.keySet()){
            studentList.add(student);
        }
        return studentList;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        for(String student : teacherStudentMapping.get(teacher)){
            studentMap.remove(student);
        }
        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        for(String teacher : teacherMap.keySet()){
            for(String student : teacherStudentMapping.get(teacher)){
                studentMap.remove(student);
            }
            teacherMap.remove(teacher);
            teacherStudentMapping.remove(teacher);
        }
    }
}