package service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Server;


public class ServerProviderFromJsonFileService {

	private Gson gson;
	private static String patch = "json/content.json";
	
	
	public ServerProviderFromJsonFileService() {
		gson = new Gson();
	}
	
	public List<Server> getServerList(){
		
		 List<Server> ipList=null;
		
		 try (Reader reader = new FileReader("/home/ersin/Documents/Git-Clones/monitoring/netdata-master/serverMonitoring/content.json")){
			 
			 ipList = gson.fromJson(reader, new TypeToken<List<Server>>() {}.getType());
	     } catch (IOException e) {
	            e.printStackTrace();
         }
	
		
		return ipList;
	}
}
