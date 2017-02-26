package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CustomerDao;
import domain.Customer;

public class CustomerDaoHibernate extends HibernateDaoSupport implements CustomerDao{
	
	@Override
	public Customer get(Integer id){
		return getHibernateTemplate().get(Customer.class, id);
	}
	
	@Override
	public Integer save(Customer customer){
		return (Integer)getHibernateTemplate().save(customer);
	}
	
	@Override
	public void update(Customer customer){
		getHibernateTemplate().update(customer);
	}
	
	@Override
	public void delete(Customer customer){
		getHibernateTemplate().delete(customer);
	}
	
	@Override
	public void delete(Integer id){
		getHibernateTemplate().delete(get(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll(){
		return (List<Customer>)getHibernateTemplate().find("from Customer_TABLE");
	}
	
	@Override
	public Customer findById(Integer id){
		return (Customer)getHibernateTemplate().find("from Customer_TABLE as c where c.id = ?", id);
	}
	
	@Override
	public Customer findByName(String customerName){
		return (Customer)getHibernateTemplate().find("from Customer as c where c.customerName = ?", customerName);
	}
	
	@Override
	public List<String> queryByName(String customerName){
		return (List<String>)getHibernateTemplate().find("from Customer as c where c.customerName like ?", customerName);
	}
}
