package kr.hhplus.be.server.concert.infra.persistence;

import kr.hhplus.be.server.concert.domain.ConcertDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaConcertDateRepository extends JpaRepository<ConcertDate, Long> {
    @Query("SELECT cd FROM ConcertDate cd WHERE cd.concert.id = :concertId")
    List<ConcertDate> findByConcertId(@Param("concertId") Long concertId);
}
