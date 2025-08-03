@Component
public class CamelRoutes extends RouteBuilder {
  @Override
  public void configure() {
    from("spring-redis:{{spring.redis.host}}:{{spring.redis.port}}?command=SUBSCRIBE&channels={{app.redis.channel}}")
      .routeId("person-subscribe-route")
      .unmarshal().json(JsonLibrary.Jackson, CanonicalPerson.class)
      .process(new PersonCanonicalProcessor())
      .to("direct:feedMongo");

    from("direct:feedMongo")
      .routeId("feed-mongo-route")
      .process(exchange -> {
        CanonicalPerson cp = exchange.getIn().getBody(CanonicalPerson.class);
        PersonDoc doc = new PersonDoc();
        doc.setFullName(cp.getFullName());
        doc.setBirthDate(cp.getBirthDate());
        // save via Spring bean
      });
  }
}
