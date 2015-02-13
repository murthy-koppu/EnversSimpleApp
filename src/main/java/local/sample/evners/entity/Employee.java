package local.sample.evners.entity;

import javax.persistence.*;

import org.hibernate.envers.Audited;

@Entity
@Table
@Audited
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String description;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    @Audited
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

}