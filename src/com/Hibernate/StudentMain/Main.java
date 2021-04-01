package com.Hibernate.StudentMain;
import com.Hibernate.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;


// THIS CLASS HAVE APPLIES CRUD OPERATIONS TO THE JVA CODE AND JDBC

public class Main {

    public static void displayStudents(List<Student> listOfStudents){
        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {

        try {

            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();

            try {
// CREATE DATA
//                System.out.println("Creating a new Student object");
//
//                Student student2 =   new Student("Aammy","G","aammy@gmail.com");
//                Student student3 =   new Student("Hammy","C","hammyC@gmail.com");
//                Student student4 =   new Student("Dammy","D","dammyD@gmail.com");
//                Student student5 =   new Student("Tammy","E","tammyE@gmail.com");

                session.beginTransaction();

//                System.out.println("Saving the Student");
//                session.save(student2);
//                session.save(student3);
//                session.save(student4);
//                session.save(student5);
// READ DATA
                //Now retrieve from database using primary key
//                Student retrieveStudent = session.get(Student.class,student2.getId());
//                System.out.println("Getting id of : " + retrieveStudent +" : "+ student2.getId());

// APPLY QUERY

                System.out.println("!---------------Applying Query---------------!");

                List<Student> listOfStudents = session.createQuery("from Student").list();

                // display list of students
                System.out.println("!---------------Display Students---------------!");
                displayStudents(listOfStudents);

                listOfStudents = session.createQuery("from Student s where s.lastname = 'D'").list();

                // students who's lastname is D
                System.out.println("!---------------Display Students who's Lastname is D---------------!");
                displayStudents(listOfStudents);

                listOfStudents = session.createQuery("from Student s where s.lastname = 'D' or s.firstname = 'Sammy'").list();

                // students who's lastname is D
                System.out.println("!---------------Display Students who's Lastname is D OR firstname is Sammy---------------!");
                displayStudents(listOfStudents);


                listOfStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();

                // Display Students who's email ends with '%@gmail.com'
                System.out.println("!---------------Display Students who's email ends with '%@gmail.com'---------------!");
                displayStudents(listOfStudents);

// UPDATE DATA

//                int studentId = 1;
//                Student student = session.get(Student.class,studentId);

                // Update Student id = 1,firstname
//                System.out.println("!---------------Updated Student id = 1 firstname---------------!");
//                student.setFirstname("Mammy");


                // Update set of students email
                System.out.println("!---------------Updated set of students email---------------!");
                session.createQuery("update Student set email = '@outlook.com'").executeUpdate();


// DELETE DATA


//                int studentId2 = 1;
//                Student student2 = session.get(Student.class,studentId2);
//
//                // Update Student id = 1,firstname
//                System.out.println("!---------------Deleted Student id = 1 firstname---------------!");
//                session.delete(student2);


                // Delete student Id = 2
                System.out.println("!---------------Deleted student Id = 2---------------!");
                session.createQuery("delete from Student where id = 2").executeUpdate();

                session.getTransaction().commit();

                System.out.println("Done !!!....");

            }
            finally {
                sessionFactory.close();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
