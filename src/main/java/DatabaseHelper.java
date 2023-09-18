import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseHelper {
    private static DatabaseHelper instance;
    public EntityManager entityManager;

    private DatabaseHelper(String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) instance = new DatabaseHelper("will");
        return instance;
    }
}
