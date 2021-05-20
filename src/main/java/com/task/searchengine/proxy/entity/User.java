package com.task.searchengine.proxy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany
    List<Search> searchList;
}
