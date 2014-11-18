package courses.service;

import courses.dao.DepartmentDAO;
import courses.dao.impl.DepartmentDAOImpl;
import courses.dao.impl.EmployerDAOImpl;
import courses.entity.Department;
import courses.entity.Employer;
import courses.jaxb.JaxbConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static File JAXB_DEPARTMENTS = new File("D:\\Dropbox\\Public\\Java\\Task11\\src\\main\\resources\\department.xml");
    public static File JAXB_EMPLOYERS = new File("D:\\Dropbox\\Public\\Java\\Task11\\src\\main\\resources\\department.xml");

    public static void main(String[] args) throws SQLException {

        try {
            DepartmentDAO departmentDAO = new DepartmentDAOImpl();
            Department department = new Department();
            department.setName("Warehouse");
            departmentDAO.create(department);
            department.setName("Logistic");
            departmentDAO.create(department);

            System.out.println("-- All Departments --");
            List<Department> depList = departmentDAO.readAll();
            for (Department dep : depList) {
                System.out.println(dep);
            }

            EmployerDAOImpl employerDAO = new EmployerDAOImpl();
            Employer employer;
            employer = new Employer(0L, "Jim", 33, "Jim@mail.dn", department.getId());
            employerDAO.create(employer);
            employer = new Employer(0L, "Tim", 31, "Tim@gmail.com", department.getId());
            employerDAO.create(employer);
            employer = new Employer(0L, "Bim", 43, "Bim@mail.dn", department.getId());
            employerDAO.create(employer);

            System.out.println("-- All employers --");
            List<Employer> empList = employerDAO.readAll();
            for (Employer empl : empList) {
                System.out.println(empl);
            }
            JaxbConverter.convertObjectToXml(empList);

            try {

                JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(department, JAXB_DEPARTMENTS);
                jaxbMarshaller.marshal(department, System.out);

            } catch (JAXBException e) {
                e.printStackTrace();
            }




            System.out.println("-- Delete all employers --");
            empList = employerDAO.readAll();
            for (Employer empl : empList) {
                employerDAO.delete(empl.getId());
            }

            System.out.println("-- Delete all Departments --");
            depList = departmentDAO.readAll();
            for (Department dep : depList) {
                departmentDAO.delete(dep.getId());
            }

        } catch (SQLException E) {
            System.out.println(E.toString());
        } finally {

        }
        System.out.println("-----");
    }

}