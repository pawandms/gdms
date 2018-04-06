package com.dms.jsf.mbean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;


@Named
@ApplicationScoped

public class CommonTask  implements Serializable {

	protected static final Logger logger = Logger.getLogger( CommonTask.class );
	
	private String NodeTypeStr;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4129430667892940583L;

	
	public CommonTask() 
	{
		//populateEventMap();	
	}
	
	

	public String getNodeTypeStr(int NodeType)
	{
		
		String typeStr = null;
		  switch(NodeType){
		  
		  	case 1: typeStr =  "Repository";break;  
		    case 2: typeStr =  "Site";break;  
		    case 3: typeStr =  "Document Library";break;  
		    case 4: typeStr =  "Folder";break;
		    case 5: typeStr =  "File";break;
		    default : typeStr = "Unknown";
		  }
		
		  return typeStr;
		
	}
	
	
	/* Generate Major Version of Content */
	
	public Double GetMajorVersion(Double version)
	{
	int value = version.intValue();
	value = value + 1;
	
	Double majorVersion = new Double(value);
	return majorVersion;
	
	}
	
	
/* Generate Minor Version of Content */
	
	public Double GetMinorVersion(Double version)
	{
		Double fraction = new Double(0.1); 
		Double result = version+fraction;
		
		DecimalFormat form = new DecimalFormat("#.#");
		
		return Double.valueOf(form.format(result));
	}
	
	@PostConstruct
	 public void postconstructbean(){
		 System.out.println("CommonTask Bean Created");
		 
	}
	
	  @PreDestroy
		 public void predestroybean(){
			  
			  System.out.println("About to Destroy CommonTask Bean from Container");
		  }
	
}
