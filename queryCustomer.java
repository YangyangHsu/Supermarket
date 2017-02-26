package actionCustomer;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import actionBase.CustomerBaseAction;
import actionBase.WebConstant;

public class queryCustomer extends CustomerBaseAction{
	private List<String> customerNames;
	private String tip;
	private String name;
	
	public void setCustomerName(List<String> customerName){
		this.customerNames = customerName;
	}
	public List<String> getCustomerName(){
		return this.customerNames;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception
	{
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		String n = ((String[]) parameters.get("name"))[0];
		setCustomerName(customerPayment.queryCustomer(n));
			setTip("Success");
			return "SUCCESS";
		
	}
}
