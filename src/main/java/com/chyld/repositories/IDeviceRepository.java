package com.chyld.repositories;

import com.chyld.entities.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IDeviceRepository extends PagingAndSortingRepository<Device, Integer> {

    @Query("select d from Device d join d.user u where u.id = :id")
    public Page<Device> findAllDevicesByUserId(@Param("id") int id, Pageable pageable);

    @Query("select d from Device d where d.serialnumber = :serialnumber")
    public Device findDeviceBySerialNumber(@Param("serialnumber") String serialnumber);

}
