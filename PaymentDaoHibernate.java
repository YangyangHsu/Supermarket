package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.PaymentDao;
import domain.Cashier;
import domain.Customer;
import domain.Payment;

public class PaymentDaoHibernate extends HibernateDaoSupport implements PaymentDao {

	@Override
	public Payment get(Integer paymentId) {
		return getHibernateTemplate().get(Payment.class, paymentId);
	}

	@Override
	public Integer save(Payment payment) {
		return (Integer)getHibernateTemplate().save(payment);
	}

	@Override
	public void update(Payment payment) {
		getHibernateTemplate().update(payment);
	}

	@Override
	public void delete(Payment payment) {
		getHibernateTemplate().delete(payment);
	}

	@Override
	public void delete(Integer paymentId) {
		getHibernateTemplate().delete(get(paymentId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findAll() {
		return (List<Payment>)getHibernateTemplate().find("from Payment_TABLE");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findByCustomer(Customer customer) {
		return (List<Payment>)getHibernateTemplate().
				find("from Payment as p where p.customer = ? ",customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findByCashier(Cashier cashier) {
		return (List<Payment>)getHibernateTemplate().
				find("from Payment as p where p.cashier = ? ",cashier);
	}
	

}
