package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ItemDao;
import domain.Item;
import domain.Payment;

public class ItemDaoHibernate extends HibernateDaoSupport implements ItemDao{

	@Override
	public Item get(Integer thingId) {
		return getHibernateTemplate().get(Item.class, thingId);
	}

	@Override
	public Integer save(Item thing) {
		return (Integer)getHibernateTemplate().save(thing);
	}

	@Override
	public void update(Item thing) {
		getHibernateTemplate().update(thing);
	}

	@Override
	public void delete(Item thing) {
		getHibernateTemplate().delete(thing);
	}

	@Override
	public void delete(Integer thingId) {
		getHibernateTemplate().delete(get(thingId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAll() {
		return (List<Item>)getHibernateTemplate().find("from Item_TABLE");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Item findByThingName(String thingName) {
		return (Item)getHibernateTemplate().
				find("from Item as t where t.itemName = ? ",thingName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findByPayment(Payment payment) {
		return (List<Item>)getHibernateTemplate().
				find("select * from Item_TABLE as t Payment_TABLE as p where p.id=? and p.itemId = t.id ",payment.getId());
	}

}
