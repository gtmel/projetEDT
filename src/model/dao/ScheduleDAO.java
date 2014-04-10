package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.ScheduleEntity;

/**
 * 
 * @author thibault
 * 
 */
public class ScheduleDAO
{
	// nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	@PersistenceContext
	private EntityManager em;

	public ScheduleDAO()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode permetant de sauvegarder un horaire
	 * 
	 * @param name
	 */
	public void addSchedule(ScheduleEntity scheduleEntity)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(scheduleEntity);
			tx.commit();
		} finally
		{
			em.close();
		}
	}

	public void updateSchedule(ScheduleEntity schedule)
	{
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			em.getTransaction().begin();
			schedule = em.merge(schedule);
			em.getTransaction().commit();
		} finally
		{
			em.close();
		}
	}

	public ScheduleEntity getSchedule(long id)
	{
		ScheduleEntity scheduleEntity;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = em.createNamedQuery("ScheduleEntity.findById").setParameter("id", id);
			scheduleEntity = q.getResultList() != null ? (ScheduleEntity) q.getResultList().get(0) : null;
		} finally
		{
			em.close();
		}
		return scheduleEntity;
	}

	public void removeSchedule(ScheduleEntity scheduleEntity)
	{
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			em.getTransaction().begin();
			scheduleEntity = em.merge(scheduleEntity);
			em.remove(scheduleEntity);
			em.getTransaction().commit();
		} finally
		{
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> getAllSchedule()
	{
		List<ScheduleEntity> schedules;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = getEntityManager().createNamedQuery("ScheduleEntity.findAll");
			schedules = q.getResultList();
		} finally
		{
			getEntityManager().close();
		}
		return schedules;
	}

	/**
	 * Permet de récupérer et d'initialiser l'entity manager si celui ci est
	 * null
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager()
	{
		if (em == null)
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		}
		return em;
	}

}
