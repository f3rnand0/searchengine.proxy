package com.task.searchengine.proxy.controler;

import com.task.searchengine.proxy.entity.Search;
import com.task.searchengine.proxy.entity.SearchQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query("select o.searchQueries from ")
    public List<SearchQueries> findAll();
}
