package actionCustomer;

import com.opensymphony.xwork2.ActionContext;

import actionBase.CustomerBaseAction;
import actionBase.WebConstant;
import domain.Item;
import domain.Payment;

public class receivePayment extends CustomerBaseAction{
	private Item item;
	private String tip;
	private Payment payment;
	
	public void setItem(Item item){
    	this.item = item;
    }
    public Item getItem(){
    	return this.item;
    }
	
	public void setPayment(Payment payment){
		this.payment = payment;
	}
	public Payment getPayment(){
		return this.payment;
	}
    
    public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
    
    public String execute() throws Exception{
    	ActionContext ctx = ActionContext.getContext();
    	Integer id = (Integer)ctx.getSession().get(WebConstant.USER);
    	if(customerPayment.receiveCashierPayment(getPayment())){
    		setTip("Name:"+ item.getItemName() + " Number:" + item.getItemCount() +" Price: " + item.getItemPrice());
    		return "SUCCESS";
    	}
    	else {
    		setTip("Wrong!");
    		return "ERROR";
    	}
    }
}
