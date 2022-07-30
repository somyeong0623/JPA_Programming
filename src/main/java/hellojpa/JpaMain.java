package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();// database connection 받는다고 생각하면 됨.
        tx.begin();  //transaction 시작

        try {

            //EntityManager를 자바 컬렉션이라고 생각하자
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            List<Member> result = em.createQuery("select m from Member as m",Member.class)
                            .getResultList();

            for(Member m : result){
                System.out.println("member.name = "+ m.getName());
            }


            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
