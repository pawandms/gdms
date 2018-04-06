package com.dms.jsf.mbean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

@Named
@ViewScoped
public class userHome implements Serializable{

	
	protected static final Logger logger = Logger.getLogger( userHome.class );
	
	
	@Inject
	CommonTask commontsk;

	// Activities Pie Chart Model
	 private PieChartModel actpieModel;
	
	
	private static final long serialVersionUID = 1L;
	
	
		
	//Connection con;
	
	
	public userHome() 
	{
	
	}

	
	
	public PieChartModel getActpieModel() {
		return actpieModel;
	}


	public void pieItemSelect(ItemSelectEvent event) {
		
	logger.info("Chart Sellection Event occured for "+event.getComponent().toString());
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	
	   private void createPieModel() {
		   actpieModel = new PieChartModel();
		   actpieModel.setShowDataLabels(true);
		   actpieModel.set("Content Activities", 100);
		   actpieModel.set("User Acivities", 15);
		   actpieModel.set("Group Activities", 10);
		   actpieModel.set("Folder Activities", 25);
		     
		   actpieModel.setTitle("Activities Pie Chart");
		   actpieModel.setLegendPosition("w");
	    }
	
	
	  @PostConstruct
	 public void postconstructbean() 
	  {
		  
		  System.out.println("UserHome Bean Created");
		  logger.error("UserHome Bean Created");
		  createPieModel();
		  System.out.println("File Type is :"+commontsk.getNodeTypeStr(5));
		  //eventList = new ArrayList<Eventmst>(commontsk.getEventmap().values());
	  }

	
	
	  @PreDestroy
	 public void predestroybean(){
		  
		  logger.error("UserHome Bean Destory from Container");
		  System.out.println("About to Destroy UserHome Bean from Container");
	  }
	  
	  


}
