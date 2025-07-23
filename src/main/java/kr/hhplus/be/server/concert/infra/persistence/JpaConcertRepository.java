package kr.hhplus.be.server.concert.infra.persistence;

import jakarta.persistence.EntityManager;
import kr.hhplus.be.server.concert.domain.Concert;
import kr.hhplus.be.server.concert.domain.ConcertDate;
import kr.hhplus.be.server.concert.domain.Seat;
import kr.hhplus.be.server.concert.domain.SeatStatus;
import kr.hhplus.be.server.concert.port.out.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaConcertRepository implements ConcertRepository {

    private final EntityManager em;


    @Override
    public List<Concert> findAllConcerts() {
        return em.createQuery("SELECT c FROM Concert c", Concert.class)
                .getResultList();
    }

    @Override
    public List<ConcertDate> findDatesByConcertId(Long concertId) {
        return em.createQuery(
                "SELECT cd FROM ConcertDate cd WHERE cd.concert.id = :concertId", ConcertDate.class)
                .setParameter("concertId", concertId)
                .getResultList();
    }

    @Override
    public List<Seat> findAvailableSeatsByConcertDateId(Long concertDateId) {
        return em.createQuery(
                "SELECT s FROM Seat s WHERE s.concertDate.id = :concertDateId AND s.status = :status", Seat.class)
                .setParameter("concertDateId",concertDateId)
                .setParameter("status", SeatStatus.AVAILABLE)
                .getResultList();
    }

}
