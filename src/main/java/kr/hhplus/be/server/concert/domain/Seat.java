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

    private int seatNumber;


    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_date_id")
    private ConcertDate concertDate;


    public Seat(Long id, ConcertDate concertDate, int seatNumber, SeatStatus seatStatus) {
        this.id = id;
        this.concertDate = concertDate;
        this.seatNumber = seatNumber;
        this.status = seatStatus;
     }
}
