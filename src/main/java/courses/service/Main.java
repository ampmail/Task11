package courses.service;

import courses.dao.DepartmentDAO;
import courses.dao.impl.DepartmentDAOImpl;
import courses.dao.impl.EmployerDAOImpl;
import courses.entity.*;
import courses.jaxb.EmployersGroup;
import courses.jaxb.JaxbConverter;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static File JAXB_EMPLOYERS = new File(".\\src\\main\\resources\\employers.xml");

    public static void main(String[] args) throws SQLException {

        try {
            DepartmentDAO departmentDAO = new DepartmentDAOImpl();
            Department departmentWh = new Department();
            departmentWh.setName("Warehouse");
            departmentDAO.create(departmentWh);
            Department departmentLg = new Department();
            departmentLg.setName("Logistic");
            departmentDAO.create(departmentLg);

            System.out.println("-- All Departments --");
            List<Department> depList = departmentDAO.readAll();
            for (Department dep : depList) {
                System.out.println(dep);
            }

            EmployerDAOImpl employerDAO = new EmployerDAOImpl();
            employerDAO.create(new Employer(0L, "Jim", 33, "Jim@mail.dn", departmentLg.getId()));
            employerDAO.create(new Employer(0L, "Tim", 31, "Tim@gmail.com", departmentLg.getId()));
            employerDAO.create(new Employer(0L, "Bim", 43, "Bim@mail.dn", departmentWh.getId()));

            System.out.println("-- All employers --");
            List<Employer> empList = employerDAO.readAll();
            for (Employer empl : empList) {
                System.out.println(empl);
            }

            EmployersGroup emplGroup = new EmployersGroup();
            emplGroup.setName("EmployersGroup First");
            for (Employer empl : empList) {
                try {
                    emplGroup.getEmployers().add(empl);
                } catch (Exception exception) {
                    Logger.getLogger(Main.class.getName()).
                            log(Level.ALL, "createJavaObjectExample1 threw ParseException", exception);
                }
            }

            JaxbConverter.convertEmployersGroupToXml(emplGroup);


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