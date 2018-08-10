package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.User;

@Repository
public class UserDaoJpaImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addUser(User user) {
		em.persist(user);

	}

	@Override
	public List<User> getUsers() {
		TypedQuery<User> query=em.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	public User getUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User getUserByEmail(String email) {
		User u=new User();
		u.setEmail(email);
		TypedQuery<User> query=em.createQuery("FROM User u WHERE u.email=:email ",User.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}

}
