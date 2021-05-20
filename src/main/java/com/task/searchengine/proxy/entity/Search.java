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
public class Search {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany
    List<Item> itemList;

    public Search() {
    }

    public Search(List<Item> itemList) {
        this.itemList = itemList;
    }
}
