package kr.hhplus.be.server.payment.application;

import kr.hhplus.be.server.payment.domain.Payment;
import kr.hhplus.be.server.payment.domain.PaymentStatus;
import kr.hhplus.be.server.payment.port.in.PaymentUseCase;
import kr.hhplus.be.server.payment.port.out.PaymentRepository;
import kr.hhplus.be.server.reservation.domain.Reservation;
import kr.hhplus.be.server.reservation.port.out.ReservationRepository;
import kr.hhplus.be.server.user.domain.User;
import kr.hhplus.be.server.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {

    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;


    @Override
    public void pay(Long userId, Long reservationId, Long amount) {
        User user = userRepository.findById(userId);
        user.usePoint(amount);
        Reservation reservation = reservationRepository.findById(reservationId);

        Payment payment = new Payment(null, amount, user, reservation, PaymentStatus.SUCCESS);
        paymentRepository.save(payment);
    }
}
