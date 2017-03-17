package com.controller.employee;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/getAllEmployees")
public class EmployeeController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAllEmployees() throws Exception{
		EmployeeMain e1=new EmployeeMain();
		ArrayList<EmployeeData> elist=e1.getElist();
		ObjectMapper mp=new ObjectMapper();
		mp.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		String jsonData=mp.writeValueAsString(elist);
		System.out.println(jsonData);
		return new ModelAndView("employee","list",jsonData);
	}
}

@Controller
@RequestMapping("/getEmployee")
class EmpDetails{
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ModelAndView getEmployeeData(@PathVariable int id,ModelMap model)throws Exception{
		EmployeeMain e1=new EmployeeMain();
		ArrayList<EmployeeData> elist=e1.getElist();
		Map edetails=new HashMap();
		String msg="NULL";
		for (EmployeeData empData : elist) {
			int eid=empData.getEid();
			if(eid==id){
				edetails.put(id,empData);
				msg="data_available";
				break;
			}
		}
		model.addAttribute("message",msg);
		ObjectMapper mapper=new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		String jsonString=mapper.writeValueAsString(edetails);

		return new ModelAndView("employee_details", "empmap",jsonString);  
	}
}

@Controller
@RequestMapping("/rest/getAllEmployees")
class RestEmployeeController {
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getAllEmployees() throws Exception{
		EmployeeMain e1=new EmployeeMain();
		ArrayList<EmployeeData> elist=e1.getElist();
		ObjectMapper mp=new ObjectMapper();
		mp.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		String jsonData=mp.writeValueAsString(elist);
		//System.out.println(jsonData);
		return jsonData;
	}
}
@Controller
@RequestMapping("/rest/getEmployee")
class RestEmployeeDetails {
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public @ResponseBody String getEmployeeData(@PathVariable int id)throws Exception{
		String jsonString="Null";
		EmployeeMain e1=new EmployeeMain();
		ArrayList<EmployeeData> elist=e1.getElist();
		Map edetails=new HashMap();
		for (EmployeeData empData : elist) {
			int eid=empData.getEid();
			if(eid==id){
				edetails.put(id,empData);
				ObjectMapper mapper=new ObjectMapper();
				mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
				jsonString=mapper.writeValueAsString(edetails);
				break;
			}
			else{
				jsonString="No data available";
			}
		}

		return jsonString;
	}

}
