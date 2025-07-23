package kr.hhplus.be.server.concert.port.out;

import kr.hhplus.be.server.concert.domain.Seat;

import java.util.Optional;

public interface SeatRepository {

    Optional<Seat> findById(Long id);


}
