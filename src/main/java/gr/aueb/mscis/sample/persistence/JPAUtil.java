package gr.aueb.mscis.sample.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The type Jpa util.
 * We make this class final so that it can't be extended in subclasses, which is a best practice for utility classes
 *
 */
public final class JPAUtil {

    private static  EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> ENTITY_MANAGER = new ThreadLocal<>();

    private JPAUtil() {
    }

    /**
     * Gets entity manager factory.
     *
     * @return the entity manager factory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("vaccpro");
        }
        return emf;
    }


    /**
     * Gets current entity manager.
     *
     * @return the current entity manager
     */
    public static EntityManager getCurrentEntityManager() {
        EntityManager em = ENTITY_MANAGER.get();
        if (em  == null || !em.isOpen()) {
            em = getEntityManagerFactory().createEntityManager();
            ENTITY_MANAGER.set(em);
        }
        return em;
    }

    /**
     * Create entity manager entity manager.
     *
     * @return the entity manager
     */
    public static EntityManager createEntityManager() {
    	return getEntityManagerFactory().createEntityManager();
    }
}
