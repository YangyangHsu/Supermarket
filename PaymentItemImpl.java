package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.CashierDao;
import dao.CustomerDao;
import dao.ItemDao;
import dao.PaymentDao;
import domain.Item;
import domain.Payment;
import exception.SupermarketException;
import service.PaymentItem;

public class PaymentItemImpl implements PaymentItem {
	private CashierDao cashierDao;
	private CustomerDao customerDao;
	private PaymentDao paymentDao;
	private ItemDao thingDao;
	
	public void setCashierDao(CashierDao cashierDao){
		this.cashierDao = cashierDao;
	}
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao = customerDao;
	}
	public void setPaymentDao(PaymentDao paymentDao){
		this.paymentDao = paymentDao;
	}
	public void setThingDao(ItemDao thingDao){
		this.thingDao = thingDao;
	}
	
	@Override
	public List<Item> getAllThing() throws SupermarketException{
		List<Item> things = thingDao.findAll();
		List<Item> thingResult = new ArrayList<Item>();
		for (Item t : things){
			thingResult.add(new Item(t.getItemName(),t.getItemCount(),t.getItemPrice()));
		}
		return thingResult;
	}
	
	@Override
	public List<Item> getItem(Payment payment) throws SupermarketException{
		List<Item> thingFind = thingDao.findByPayment(payment);
		List<Item> thingResult = new ArrayList<Item>();
		for (Item t : thingFind){
			thingResult.add(new Item(t.getItemName(),t.getItemCount(),t.getItemPrice()));
		}
		return thingResult;
	}
	
}
