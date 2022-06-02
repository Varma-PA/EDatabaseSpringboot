package com.northeastern.employeesdatabase.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Employee_Table")
@Getter
@Setter
@ToString
//@NoArgsConstructor
//@RequiredArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "dept")
    public String department;

    public Employee(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
