package com.example.helloworld.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.helloworld.Hibernate;
import com.example.helloworld.db.FunDAO;
import com.google.common.collect.Lists;

@Path("/fun")
@Produces(MediaType.APPLICATION_JSON)
public class FunResource {

	private final Hibernate hib;
	public FunResource(Hibernate hibernate) {
		hib = hibernate;
	}

	@POST
	public String createFun(@QueryParam(value="event") String event) {		
		Session sess = hib.openSession();
		try {
			sess.beginTransaction();
			FunDAO fun = new FunDAO(event);	
			sess.save(fun);		
			sess.getTransaction().commit();		
			return fun.getModel();
		} finally {
			hib.closeSession();
		}
	}

	@GET
	public List<FunDAO> getFun(@QueryParam(value="event")String event) {
		Session sess = hib.openSession();
		try {
			Criteria crit = sess.createCriteria(FunDAO.class);
			crit.add(Restrictions.eq("model", event));
			List fun = crit.list();
			List<FunDAO> funList = Lists.newArrayList();
			for(Object o : fun) {
				funList.add((FunDAO)o);
			}
			return funList;
		}finally {
			hib.closeSession();
		}
	}


}
