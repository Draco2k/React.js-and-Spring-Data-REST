package app.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private String description;

    private Employee() {
    }

    public Employee(String name, String lastname, String description) {
        this.description = description;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Employee employee = (Employee) obj;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name)
                && Objects.equals(lastname, employee.lastname) && Objects.equals(description, employee.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, description);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", lastname='" + lastname + '\''
                + ", description='" + description + '\'' + '}';
    }

}
