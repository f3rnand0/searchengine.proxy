package com.task.searchengine.proxy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class SearchQueries {
    @Id
    @GeneratedValue
    Long id;

    String query;

    @OneToOne
    Search search;
}
