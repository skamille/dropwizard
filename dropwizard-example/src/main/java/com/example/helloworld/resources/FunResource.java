package com.example.helloworld.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.helloworld.Hibernate;
import com.example.helloworld.db.FunDAO;

@Path("/fun")
@Produces(MediaType.APPLICATION_JSON)
public class FunResource {
	
	private final Hibernate hib;
	public FunResource(Hibernate hibernate) {
		hib = hibernate;
	}
	
	@POST
	public String createFun(String event) {
		FunDAO fun = new FunDAO();
		fun.model=event;
		Session sess = hib.getSessionFactory().openSession();
		/*Transaction txn = sess.beginTransaction();
		txn.begin();*/
		sess.save(fun);
	//	txn.commit();
		sess.close();
		return fun.model;
	}
	
	/*@GET
	public String getFun(String model) {
		Session sess = hib.getSessionFactory().openSession();
		
	}
*/

}
