package com.chyld.repositories;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPositionRepository extends PagingAndSortingRepository<Position, Integer> {
    @Query("select p from Position p join p.run r where r.id = :id")
    public List<Position> findAllPositionsByRunId(@Param("id") int id);
}
