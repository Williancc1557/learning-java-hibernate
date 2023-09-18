import java.util.List;

public class PersonManagerRepository {
    private DatabaseHelper dbHelper;

    public PersonManagerRepository() {
        this.dbHelper = DatabaseHelper.getInstance();
    }

    public void removeById(long id) {
        this.dbHelper.entityManager.getTransaction().begin();
        Person person = this.dbHelper.entityManager.find(Person.class, id);
        this.dbHelper.entityManager.remove(person);
        this.dbHelper.entityManager.getTransaction().commit();
    }

    public Person getById(long id) {
        this.dbHelper.entityManager.getTransaction().begin();
        Person person = this.dbHelper.entityManager.find(Person.class, id);
        this.dbHelper.entityManager.getTransaction().commit();

        return person;
    }

    public List<Person> getById() {
        this.dbHelper.entityManager.getTransaction().begin();
        List<Person> persons = this.dbHelper.entityManager.createQuery("SELECT a FROM Person a", Person.class).getResultList();
        this.dbHelper.entityManager.getTransaction().commit();

        return persons;
    }

    public void insertPerson(Person person) {
        this.dbHelper.entityManager.getTransaction().begin();
        this.dbHelper.entityManager.persist(person);
        this.dbHelper.entityManager.getTransaction().commit();
   }

    public void updatePerson(Person person) {
        this.dbHelper.entityManager.merge(person);
    }
}
