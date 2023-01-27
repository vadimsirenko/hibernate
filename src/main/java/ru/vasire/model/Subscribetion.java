package ru.vasire.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subscribetion")
public class Subscribetion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany()
    @JoinTable(name = "Person_Subscribetion",
            joinColumns=@JoinColumn(name="subscribetion_id"),
            inverseJoinColumns=@JoinColumn(name="person_id"))
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Subscribetion(String name) {
        this.name = name;
    }

    public Subscribetion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Subscribetion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
