package com.j.models.data;

import com.j.models.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestDao extends PagingAndSortingRepository<Guest, Long> {

}