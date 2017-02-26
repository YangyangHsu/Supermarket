package actionCustomer;

import com.opensymphony.xwork2.ActionContext;
import actionBase.CustomerBaseAction;
import actionBase.WebConstant;

public class saveCustomer extends CustomerBaseAction{
	private String customerName;
	private String tip;
	
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	public String getCustomerName(){
		return this.customerName;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception
	{
		if(customerPayment.addCustomer(getCustomerName()))
		{
			setTip("Success");
			return "SUCCESS";
		}
		else
		{
			setTip("Error!");
			return "ERROR";
		}
	}
}
