package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class User {

		//Initializing the values 
	
		@NotNull(message = "First Name can't be empty!")
		@Size(min=5, max=15)
		String firstName ="";
		
		@NotNull(message = "Last Name can't be empty!")
		@Size(min=5, max=15)
		String lastName = "";
		
		//Default Constructor
		public User()
		{
			firstName ="Michael";
			lastName ="Mohler";
			
		}
		
		@PostConstruct
		public void init()
		{
			// Get the logged in Principle
			Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
				if(principle == null)
				{
					setFirstName("Unknown");
					setLastName("");
				}
				else
				{
					setFirstName(principle.getName());
					setLastName("");
				}

		}

		//Get for first name
		public String getFirstName() {
			return firstName;
		}
		
		//Set for first name
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		//Get for last name
		public String getLastName() {
			return lastName;
		}

		//Set for last name
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
}
