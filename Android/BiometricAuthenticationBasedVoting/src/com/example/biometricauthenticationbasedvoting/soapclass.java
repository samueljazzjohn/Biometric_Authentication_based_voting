package com.example.biometricauthenticationbasedvoting;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class soapclass {
	public static String NAMESPACE ="http://tempuri.org/";
	public static final String url="http://10.0.2.2:53980/Biometric_authentication_based_voting/WebService.asmx";
	
	public String Callsoap(SoapObject soapobj,String SOAP_ACTION)
	{
		String outp="";
		//Declare the version of the SOAP request
SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.setOutputSoapObject(soapobj);
envelope.dotNet = true;
try {
HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
androidHttpTransport.call(SOAP_ACTION, envelope);
// Get the SoapResult from the envelope body.
SoapObject result = (SoapObject)envelope.bodyIn;
outp  =result.getProperty(0).toString();

      } catch (Exception e) {
e.printStackTrace();
      }
		return outp;
		
	}
}


