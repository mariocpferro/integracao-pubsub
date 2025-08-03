public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByLastName(String lastName);
}