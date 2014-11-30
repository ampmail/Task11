package courses.service.Samples;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "lastName", "firstName", "birthDate", "type" }, name = "person")
public class Person {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private PersonType type;
    @XmlAttribute(name = "active")
    private Status status = Status.PENDING_APPROVAL;

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public Person delete() {
        status = Status.INACTIVE;
        return this;
    }

    public Person approve() {
        status = Status.ACTIVE;
        return this;
    }

    @XmlJavaTypeAdapter(ShortDateFormatter.class)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}