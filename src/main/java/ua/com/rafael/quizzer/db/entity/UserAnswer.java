package ua.com.rafael.quizzer.db.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_answers", schema = "quizzer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserAnswer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    private Question question;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_answers_answer_options", schema = "quizzer",
            joinColumns = {@JoinColumn(name = "user_answer_id")},
            inverseJoinColumns = @JoinColumn(name = "answer_option_id"))
    private List<AnswerOption> chosenAnswerOptions;

    private LocalDateTime submittingTime;
}
