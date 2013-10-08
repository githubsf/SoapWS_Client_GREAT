package org.anoosh.soapws;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

/*
 * GO TO www.webservicex.net, choose category Utility,
 * and select GeoIPService web service for this example
 * then go to the link for its WSDL, and copy the WSDL's URL address
 * start a command prompt in your DOS, the java utility that comes
 * with a java SE, is called 'wsimport', and will be on your path as long
 * as java is on your path. Without any options it only takes the URL of the WSDL
 * and generates classes from it. It will not keep the *.java files. You can 
 * use the -keep to keep the java files instead of deleting them after compilation 
 * and also specify the directory for the source java files with -s .
 * Once the java files are kept with -keep -s src , then open and view the source code
 * and look for the package name at the top of the file. Create a package in your Eclipse
 * project with the same exact name as you saw in wsimport generated java files and copy
 * all those java files from your DOS dir to your Eclipse's new package. Now the source
 * code of the ws is local to your project. Which of the 9 files to choose as a stub in 
 * our client? You need to look at WSDL online. Go to the bottom of WSDL and pay 
 * attention to these 2 elements only : wsdl:service & wsdl:port
 * <wsdl:service name="GeoIPService"> 
 * <wsdl:port name="GeoIPServiceSoap" binding="tns:GeoIPServiceSoap"> 
 * 
 * So now you will need to import both of these to your client java class
 * use Eclipse suggestion(Ctrl-space bar) to see the methods in each, or use project explorer
 * but 1st instantiate an object of GeoIPService.(our wsdl:service name='...') and then use 
 * one of its method to get to the port for the service.(our wsdl:port name='...')
 * 
 */
public class IPlocationFinder {

	/*
	 * To test this , open a DOS command window, and type:  ping google.com
	 * to get a valid IP address to pass in as argument
	 * in Eclipse go to 'Run Configurations' and use 'Arguments' tab
	 * then copy and paste your valid ip address to the arguments tab
	 * and then hit run.
	 */
	public static void main(String[] args) {
		if(args.length != 1) {System.out.println("You need to pass in an IP address.");}
		else {
			String ipAddress = args[0];
			// Now we use java SE's "wsimport" to generate all java files and classes
			// from the WSDL of the online remote WS and import them to our project
			GeoIPService ipSvc = new GeoIPService();
			GeoIPServiceSoap soapStub = ipSvc.getGeoIPServiceSoap(); //OUR STUB,acts as a proxy/SEI for the remote WS
			GeoIP geoIP = soapStub.getGeoIP(ipAddress); // geoIP is a custom complex data type
			System.out.println(geoIP.getCountryName());
		}
		

	}

}
