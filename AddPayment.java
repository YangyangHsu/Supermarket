package actionCashier;


import com.opensymphony.xwork2.ActionContext;

import actionBase.CashierBaseAction;
import actionBase.WebConstant;
import domain.Customer;
import domain.Item;

public class AddPayment extends CashierBaseAction{
	private String tip;
	private Customer customer;
	private String customerName;
	private Item item;
	private String itemName;
	
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
    public Customer getCustomer(){
    	return this.customer;
    }
    
    public void setItem(Item item){
    	this.item = item;
    }
    public Item getItem(){
    	return this.item;
    }
    
    public void setCustomerName(String customerName){
    	this.customerName = customerName;
    }
    public String getCustomerName(){
    	return this.customerName;
    }
    
    public void setItemName(String itemName){
    	this.itemName = itemName;
    }
    public String getItemName(){
    	return this.itemName;
    }
    
    public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
    
    public String execute() throws Exception{
    	ActionContext ctx = ActionContext.getContext();
    	String cashierName = (String)ctx.getSession().get(WebConstant.USER);
    	if(cashPay.addCashierPayment(cashierName, getCustomerName(), getItemName())){
    		setTip("Name:"+ item.getItemName() + " Number:" + item.getItemCount() +" Price: " + item.getItemPrice());
    		return "Success";
    	}
    	else {
    		setTip("Wrong!");
    		return "Error";
    	}
    }
}
