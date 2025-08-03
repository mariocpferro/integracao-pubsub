@Service
public class PersonOutboundService {
  private final PersonRepository repo;
  private final RedisTemplate<String, String> redis;

  @Value("${app.redis.channel}")
  private String channel;

  public PersonOutboundService(PersonRepository repo,
      RedisTemplate<String, String> redis) {
    this.repo = repo;
    this.redis = redis;
  }

  public void publishAll() {
    repo.findAll().stream()
        .map(this::toCanonical)
        .forEach(canonical -> {
          redis.convertAndSend(channel, toJson(canonical));
        });
  }

  private CanonicalPerson toCanonical(PersonEntity e) {
    return new CanonicalPerson(e.getId(), e.getFirstName(),
        e.getLastName(), e.getBirthDate());
  }
}
