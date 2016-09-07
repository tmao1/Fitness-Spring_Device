package com.chyld.repositories;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRunRepository extends PagingAndSortingRepository<Run, Integer> {
    @Query("select r from Run r join r.device d where d.serialnumber = :serialnumber AND  r.endtime IS NULL")
    public List<Run> findActiveRunsByDeviceSerialNumber(@Param("serialnumber") String serialnumber);
}
