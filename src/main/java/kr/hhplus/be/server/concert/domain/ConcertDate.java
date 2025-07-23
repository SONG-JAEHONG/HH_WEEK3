package kr.hhplus.be.server.concert.domain;

import jakarta.persistence.*;
import kr.hhplus.be.server.common.base.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
public class ConcertDate extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Concert concert;

    private LocalDate Date;

    public ConcertDate(long id, Concert concert, LocalDate Date) {
        this.id = id;
        this.concert = concert;
        this.Date = Date;
    }
}
