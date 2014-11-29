package courses.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = { "name", "employers","departments"}, name = "EmployersInDepartmentsGroup")
@XmlRootElement
public class EmployersInDepartmentsGroup {

    private String name;
    private List<Employer> employer = new ArrayList<Employer>();
    private List<Department> department = new ArrayList<Department>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "members")
    @XmlElement(name = "employer")
    public List<Employer> getEmployers() {
        return employer;
    }
    public void setEmployers(List<Employer> employer) {
        this.employer = employer;
    }

    public List<Department> getDepartments() {
        return department;
    }
    public void setDepartments(List<Department> department) {
        this.department = department;
    }
}
