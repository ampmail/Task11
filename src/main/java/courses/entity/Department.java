package courses.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(propOrder = { "id", "name"}, name = "department")
public class Department {

    private Long id;
    private String name;

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 0x1f * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Department department = (Department) obj;
        if (!id.equals(department.id)) return false;
        if (!name.equals(department.name)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Department {id=" + id + ", name='" + name +"'}";
    }
}