@SpringBootApplication
public class IntegrationApplication implements CommandLineRunner {

  @Autowired
  private PersonOutboundService outbound;

  public static void main(String[] args) {
    SpringApplication.run(IntegrationApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    outbound.publishAll();
  }
}
