package kr.hhplus.be.server.reservation.port.in;

import kr.hhplus.be.server.reservation.infra.web.dto.ReservationRequest;

public interface ReservationUseCase {

    ReservationRequest reserve(ReservationRequest reservationRequest, Long userId);

}
