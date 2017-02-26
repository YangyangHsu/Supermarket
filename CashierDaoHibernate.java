package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CashierDao;
import domain.Cashier;
import domain.Customer;
import domain.Payment;

public class CashierDaoHibernate extends HibernateDaoSupport implements CashierDao{

	@Override
	public Cashier get(Integer cashierId){
		return getHibernateTemplate().get(Cashier.class, cashierId);
	}
	
	@Override
	public Integer save(Cashier cashier){
		return (Integer)getHibernateTemplate().save(cashier);
	}
	
	@Override
	public void update(Cashier cashier){
		getHibernateTemplate().update(cashier);
	}
	
	@Override
	public void delete(Cashier cashier){
		getHibernateTemplate().delete(cashier);
	}
	
	@Override
	public void delete(Integer cashierId){
		getHibernateTemplate().delete(get(cashierId));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cashier> findAll(){
		return (List<Cashier>)getHibernateTemplate().find("from Cashier_TABLE");
	}
	
	@Override
	public Cashier findByName(Cashier cashier){
		return (Cashier)getHibernateTemplate().find("from Cashier as c where c.cashierName = ?",cashier.getCashierName());
	}
	
	@Override
	public Cashier findByCustomer(Customer customer){
		return (Cashier)getHibernateTemplate().find("select * from Cashier_TABLE as ca Customer_TABLE as cu Payment_TABLE as p where cu.id = ? and cu.id = payment.customerId and payment.cashierId = ca.id",customer.getId());
	}
	
	@Override
	public Cashier findByPayment(Payment payment) {
		return (Cashier)getHibernateTemplate().find("select * from Payment_TABLE as p Cashier_TABLE as c where p.paymentId=? and p.cashierId = c.cashierId",payment.getId());
	}
	
	@Override
	public Cashier findByName(String cashierName){
		return (Cashier)getHibernateTemplate().find("from Cashier as c where c.cashierName=?",cashierName);
	}
}
