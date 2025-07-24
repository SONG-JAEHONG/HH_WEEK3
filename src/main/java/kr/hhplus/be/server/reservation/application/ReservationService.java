package kr.hhplus.be.server.reservation.application;

import kr.hhplus.be.server.concert.domain.ConcertDate;
import kr.hhplus.be.server.concert.domain.Seat;
import kr.hhplus.be.server.concert.port.out.ConcertRepository;
import kr.hhplus.be.server.concert.port.out.SeatRepository;
import kr.hhplus.be.server.reservation.domain.Reservation;
import kr.hhplus.be.server.reservation.infra.web.dto.ReservationRequest;
import kr.hhplus.be.server.reservation.infra.web.dto.ReservationResponse;
import kr.hhplus.be.server.reservation.port.in.ReservationUseCase;
import kr.hhplus.be.server.reservation.port.out.ReservationRepository;
import kr.hhplus.be.server.user.domain.User;
import kr.hhplus.be.server.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationService implements ReservationUseCase {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Override
    public ReservationRequest reserve(ReservationRequest reservationRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Seat seat = seatRepository.findById(reservationRequest.seatId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 좌석입니다."));

        if(!seat.isAvailable()){
            throw new IllegalStateException("이미 예약 중인 좌석입니다.");
        }
        seat.hold(); // 내부에서 상태 확인 + HOLDING 처리
        seatRepository.save(seat);




    }
}
