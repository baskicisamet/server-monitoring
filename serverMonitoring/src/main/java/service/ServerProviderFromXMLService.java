package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import com.tegsoft.tobe.db.dataset.DataRow;
import com.tegsoft.tobe.db.dataset.Dataset;
import com.tegsoft.tobe.util.StringUtil;

import model.Server;

public class ServerProviderFromXMLService {

	public static List<Server> getAllServers() {
		List<Server> ipList = null;
		try {
			ipList = new ArrayList<Server>();
			String url = "http://www.tegsoft.com/Tobe/app/ApplicationServlet?xmlService=DataProvider&"
					+ "serviceType=DataProvider&usercode=webservice&clearpassword=webservice123&"
					+ "method=getData&sqlQuery=SELECT%20LASTCONTIP%20FROM%20TBLLICSERVER%20WHERE%20UNITUID=%2787750197-a2f0-4690-8712-4c615c35eb8f%27";

			String XML = performHttpGetMethod(url);

			XML = XML.replace("&amp;", "&");
			XML = XML.replace("&gt;", ">");
			XML = XML.replace("&lt;", "<");
			XML = XML.replace("&apos;", "'");
			XML = XML.replace("&quot;", "\"");

			Dataset dataset = Dataset.createFromTegsoftXML(XML);

			Set<String> hashipList = new HashSet<>();
			
			for (int i = 0; i < dataset.getRowCount(); i++) {
				DataRow rowDatarow = dataset.getRow(i);
				hashipList.add(rowDatarow.getString("LASTCONTIP"));
			}
			
			hashipList.removeAll(Collections.singleton(null));
			
			for (String string : hashipList) {
				System.out.println(string);
				ipList.add(new Server("Server", string));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllServers();
	}

	public static String performHttpGetMethod(String HttpURL) throws Exception {
		URL url = new URL(HttpURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setReadTimeout(5 * 1000);
		connection.setConnectTimeout(5 * 1000);
		connection.connect();

		int responseCode = connection.getResponseCode();

		if (responseCode == 401) {
			System.out.println("GETMETHOD RESPONSECODE: 401 RETURN NULL");
			return null;
		}

		int readed;
		char[] buffer = new char[4 * 1024];
		StringBuffer sb = new StringBuffer();
		BufferedReader in = null;

		if (responseCode == 200) {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		} else {
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "UTF-8"));
		}
		while ((readed = in.read(buffer)) > 0) {
			sb.append(buffer, 0, readed);
		}

		in.close();
		String response = sb.toString();
		connection.disconnect();

		if (responseCode != 200) {
			System.out.println("RESPONSE CODE:" + responseCode);
		}

		return response;
	}

}
