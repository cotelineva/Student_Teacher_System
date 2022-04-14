import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {

    @Test
    void register() {
        Person p1 = new Person("Ion","Ionescu");
        Student s1 = new Student("Paul","Popescu",1000,0, Collections.<Course>emptyList());
        Course c1 = new Course("BD", p1, 1, Collections.<Student>emptyList(), 10);
        RegistrationSystem r = new RegistrationSystem();

        assertEquals(r.register(c1,s1),true);
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        Person p1 = new Person("Ion","Ionescu");
        Course c1 = new Course("BD", p1, 1, Collections.<Student>emptyList(), 10);
        Course c2 = new Course("MAP", p1, 3, Collections.<Student>emptyList(), 10);
        CourseInMemoryRepo cr = new CourseInMemoryRepo();
        RegistrationSystem r = new RegistrationSystem();

        cr.save(c1);
        cr.save(c2);

        List<Course> list = List.of(c1,c2);

        assertEquals(r.retrieveCoursesWithFreePlaces(cr),list);

    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        Person p1 = new Person("Ion","Ionescu");
        Student s1 = new Student("Paul","Popescu",1000,0, Collections.<Course>emptyList());
        Student s2 = new Student("Paula","Popa",1003,0, Collections.<Course>emptyList());
        Course c1 = new Course("BD", p1, 2, Collections.<Student>emptyList(), 10);
        RegistrationSystem r = new RegistrationSystem();

        r.register(c1,s1);
        r.register(c1,s2);

        List<Student> list = List.of(s1,s2);

        assertEquals(r.retrieveStudentsEnrolledForACourse(c1),list);

    }

    @Test
    void getAllCourses() {
        Person p1 = new Person("Ion","Ionescu");
        Course c1 = new Course("BD", p1, 1, Collections.<Student>emptyList(), 10);
        Course c2 = new Course("MAP", p1, 3, Collections.<Student>emptyList(), 10);
        CourseInMemoryRepo cr = new CourseInMemoryRepo();
        RegistrationSystem r = new RegistrationSystem();

        cr.save(c1);
        cr.save(c2);

        List<Course> list = List.of(c1,c2);

        assertEquals(r.getAllCourses(cr),list);
    }
}