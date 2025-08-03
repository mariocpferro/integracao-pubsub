@Component
public class PersonCanonicalProcessor implements Processor {
  @Override
  public void process(Exchange exchange) {
    CanonicalPerson cp = exchange.getIn().getBody(CanonicalPerson.class);
    // Exemplo: adicionar timestamp, validar, etc.
    cp.setFullName(cp.getFullName().trim().toUpperCase());
    exchange.getIn().setBody(cp);
  }
}
