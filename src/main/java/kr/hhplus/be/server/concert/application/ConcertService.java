package kr.hhplus.be.server.concert.application;

import kr.hhplus.be.server.concert.domain.Concert;
import kr.hhplus.be.server.concert.domain.ConcertDate;
import kr.hhplus.be.server.concert.domain.Seat;
import kr.hhplus.be.server.concert.infra.web.dto.ConcertDateResponse;
import kr.hhplus.be.server.concert.infra.web.dto.ConcertResponse;
import kr.hhplus.be.server.concert.infra.web.dto.SeatResponse;
import kr.hhplus.be.server.concert.port.in.ConcertUseCase;
import kr.hhplus.be.server.concert.port.out.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService implements ConcertUseCase {

    private final ConcertRepository concertRepository;

    @Override
    public List<ConcertResponse> getAllConcerts(){
        return concertRepository.findAllConcerts().stream()
                .map(concert -> new ConcertResponse(concert.getId(), concert.getTitle()))
                .toList();
    }

    @Override
    public List<ConcertDateResponse> getConcertDates(Long concertId) {
        return concertRepository.findDatesByConcertId(concertId).stream()
                .map(concertDate -> new ConcertDateResponse(concertDate.getId(),concertDate.getDate()))
                .toList();
    }

    @Override
    public List<SeatResponse> getSeats(Long concertDateId) {
        return concertRepository.findAvailableSeatsByConcertDateId(concertDateId).stream()
                .map(seat -> new SeatResponse(seat.getId(), seat.getSeatNumber()))
                .toList();
    }


}
