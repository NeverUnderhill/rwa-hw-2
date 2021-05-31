package ba.fet.rwa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class JpaTest {
    private static EntityManager em;
 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("rwaPU");
        em = emf.createEntityManager();

        createVideo("uSP-ewdJYJc", "David Lynch on Cooking Quinoa");
        createVideo("JXeJANDKwDc", "What Are You Doing With Your Life? The Tail End");
        createVideo("QmoGi1F_rYE", "Plunging On Alone: Monte Hellman's Life In A Day (1986)");
        createVideo("0zvEG93T2mE", "Dubioza Kolektiv - Space Song feat. Earl Sixteen (Official Video)");
        createVideo("n1DnsYzim-8", "Cocteau Twins - Carolyn's Fingers");
        createVideo("ScNgrQ1EXr0", "Janko Nilovic - Drug Song (1975)");
        createVideo("fsccjsW8bSY", "This Must Be the Place (Naive Melody) (2005 Remaster)");
        createVideo("o4qsjmLxhow", "The Strokes - The Adults Are Talking (Audio)");
        createVideo("A-s9LdQPXF4", "Sun Araw - Deep Cover");
        createVideo("NHEaYbDWyQE", "Michael Says Prime Numbers for 3 Hours");
    }
 
    private static void createVideo(String youtubeId, String title) {
        em.getTransaction().begin();
        Video vid = new Video(youtubeId, title);
        em.persist(vid);
        em.getTransaction().commit();
    }
}