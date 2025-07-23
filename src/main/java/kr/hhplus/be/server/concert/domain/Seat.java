package kr.hhplus.be.server.concert.domain;

import jakarta.persistence.*;
import kr.hhplus.be.server.common.base.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Seat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ConcertDate concertDate;

    private int seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public Seat(Long id, ConcertDate concertDate, int seatNumber, SeatStatus status) {
        this.id = id;
        this.concertDate = concertDate;
        this.seatNumber = seatNumber;
        this.status = status;
    }

}
