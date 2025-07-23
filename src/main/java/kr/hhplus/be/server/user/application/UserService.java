package kr.hhplus.be.server.user.application;

import kr.hhplus.be.server.user.domain.User;
import kr.hhplus.be.server.user.port.in.UserUseCase;
import kr.hhplus.be.server.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public void chargePoint(Long userId, Long amount) {
        User user = userRepository.findById(userId);
        user.chargePoint(amount);

    }

    @Override
    public void usePoint(Long userId, Long amount) {
        User user = userRepository.findById(userId);
        user.usePoint(amount);
    }
}
