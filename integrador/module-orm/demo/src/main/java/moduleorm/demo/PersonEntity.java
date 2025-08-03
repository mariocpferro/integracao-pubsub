package moduleorm.demo;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonEntity {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}