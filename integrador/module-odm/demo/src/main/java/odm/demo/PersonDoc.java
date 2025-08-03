@Document("person")
@Getter
@Setter
public class PersonDoc {
    @Id private String id;
    private String fullName;
    private LocalDate birthDate;
    // getters/setters
}
