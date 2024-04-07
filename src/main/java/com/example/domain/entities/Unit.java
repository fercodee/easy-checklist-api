package com.example.domain.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "unit_quizze", joinColumns = @JoinColumn(name = "unit_id"), inverseJoinColumns = @JoinColumn(name = "quizze_id"))
    private Set<Quizze> quizzes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
