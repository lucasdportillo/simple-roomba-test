package com.yoti.roomba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoombaOutputRepository extends JpaRepository<RoombaOutput, Long> {
}
