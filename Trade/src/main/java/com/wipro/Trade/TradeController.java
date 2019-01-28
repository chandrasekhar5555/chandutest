package com.wipro.Trade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//import com.wipro.Register.User;

//import com.wipro.Register.User;

//import com.wipro.Register.User;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



@Controller
public class TradeController {
	
	User user=new User();
	Map<String,Double> companies=new HashMap<String,Double>();
	
	Map<String,Trade> trades=new HashMap<String,Trade>();
	
	private static final Logger LOG=LoggerFactory.getLogger(TradeController.class);
	public TradeController(){
		companies.put("WIPRO", 298.45);
		companies.put("INFY", 949.95);
		companies.put("TCS", 2713.70);
		companies.put("TECHM", 485.85);	
		
	}
	
	
		//@Autowired	
		//private RestTemplate restTemplate;
		
		//@Autowired
		//private DiscoveryClient discoveryClient;

		//@Value("${pivotal.registerservice.name}")
		 //protected String registerService;
		
		
	@RequestMapping(value = "/trade/do", method = RequestMethod.POST)
	
	public String tradeDo(@ModelAttribute("ticker")String ticker,@ModelAttribute("qty") int qty,HttpServletRequest request,Model model)
	{
		System.out.print("===========Trade do=================");
		Double price=companies.get(ticker);
		System.out.print("===========Trade do="+ticker+"====="+price+"====="+qty+"===========");
		Trade u=new Trade(ticker,price,qty);
		double total=price*qty;
		u.setTotalcost(total);	
		LOG.error("Total Price error IS"+total);
		LOG.warn("Total Price warn IS"+total);
		LOG.info("Total Price  info IS"+total);
		LOG.debug("Total Price IS"+total);
				
		trades.put(ticker, u);
		
		
				
		//all the below code is just used to simulate that from Trade service
		//also we can call the register-service Microservice		
		
		//List<ServiceInstance> instances=  discoveryClient.getInstances(registerService);
		//URI uri=instances.get(0).getUri();
		
		//System.out.println("Register-Service.getAllRegisteredUsers() .URI========="+uri);
		//String url=uri.toString()+"/users/all";
		
		System.out.println("========================================");
		//System.out.println("Trade-Service.tradedo()  .URI========="+url);
		
		//Map<String,Object> aa=new HashMap<String,Object>();
		
		//ResponseEntity<String> result = restTemplate.getForEntity(url,String.class);
		
		/*if (result.getStatusCode() == HttpStatus.OK) {
			
			return result.getBody();
			
		} else {
			
			return null;
		} */
		model.addAttribute("total", total);
		
		return "success";
		
		//return "<html><body bgcolor='coral'>Traded Successfully "+"</body></html>";
		
		//return "<html><body bgcolor='coral'>Traded Successfully</body></html>";
		
	}
	
	@RequestMapping(value = "/trade/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Trade> getAllTrades()
	{
		return trades;
	}
	
	@RequestMapping(value = "/trade/{ticker}", method = RequestMethod.GET)
	@ResponseBody
	public Trade getTradeOfTicker(@PathVariable("ticker")String ticker)
	{
		return trades.get(ticker);
	}
	
	

}