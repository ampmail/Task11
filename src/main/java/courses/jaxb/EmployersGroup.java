package courses.jaxb;

import courses.entity.Employer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = { "name", "employers" }, name = "EmployersGroup")
@XmlRootElement
public class EmployersGroup {

    private String name;
    private List<Employer> employers = new ArrayList<Employer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "employers")
    @XmlElement(name = "employer")
    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }
}