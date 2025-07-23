package kr.hhplus.be.server.concert.infra.persistence;

import kr.hhplus.be.server.concert.domain.Seat;
import kr.hhplus.be.server.concert.domain.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s WHERE s.concertDate.id = :concertDateId AND s.status = :status")
    List<Seat> findByConcertDateIdAndStatus(@Param("concertDateId") Long concertDateId, @Param("status") SeatStatus status);
}
