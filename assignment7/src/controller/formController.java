//Michael Mohler 

package controller;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;

import business.OrdersBusinessInterface;


@ManagedBean
@ViewScoped
public class formController 
{
	
	//Insert the interface
	@Inject
	OrdersBusinessInterface service;


	public String onLogoff()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "TestResponse.xhtml?faces-redirect=true";
				
	}
	
	
	public String onSendOrder()
	{
		Order things = new Order(15, "09274423","Thingies",(float)30.63,3);
		service.sendOrder(things);
		return "OrderResponse.xhtml";
	}
	
	
	
	public OrdersBusinessInterface getService()
	{
		return service;
	}
	
	
	
}
