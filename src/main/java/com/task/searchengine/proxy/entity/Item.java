package com.task.searchengine.proxy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue
    Long id;

    String title;
    String link;
    String formattedUrl;
}
