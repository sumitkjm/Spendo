package com.mas.em.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * Utility class for Jaxb object to xml and XML to object conversion.
 *
 */
public class JaxbUtils {


	/**
	 * This method should be used only in case if you are putting any debug statement
	 * as this method does not throw any exception.
	 * @param object
	 * @return
	 */
	public static String debugConvertXmlToObject(Object object) {
		String convertedXml = null;
		try {
			convertedXml = convertObjectToXml(object);
		} catch (JAXBException e) {
		}
		return convertedXml;
	}

	/**
	 * This method should be used only in case if you are putting any debug statement
	 * @param object
	 * @param jaxbEncoding
	 * @return
	 */
	public static String debugConvertXmlToObject(Object object, String jaxbEncoding) {
		String convertedXml = null;
		try {
			convertedXml = convertObjectToXml(object, jaxbEncoding);
		} catch (JAXBException e) {
		}
		return convertedXml;

	}

	/**
	 * Converts XML to Object for given xml string and objectClass
	 * @param xml XML String to be converted as JAXB Object
	 * @param objectClass Class of the object for which conversion to happen
	 * @return Converted JAXB Object as Object which can be further typed cast to use
	 * @throws JAXBException
	 */
	public static Object convertXmlToObject(String xml, Class<?> objectClass) throws JAXBException {
		Object convertedObject = null;
		JAXBContext context = JAXBContext.newInstance(objectClass);
		Unmarshaller unmarshall = context.createUnmarshaller();
		InputStream isInputXML = new ByteArrayInputStream(xml.getBytes());
		convertedObject = unmarshall.unmarshal(isInputXML);
		return convertedObject;
	}

	/** converts Object to XML for given objectClass and jaxbEncoding
	 * @param object Object to be converted in XML
	 * @param jaxbEncoding Jaxb Encoding ( XML encoding) default is UTF-8
	 * @return converted XML string
	 * @throws JAXBException
	 */
	public static String convertObjectToXml(Object object, String jaxbEncoding) throws JAXBException {
		String convertedXml = null;
		StringWriter stringwriter = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, jaxbEncoding);
		marshaller.marshal(object, stringwriter);
		convertedXml = stringwriter.toString();
		//System.out.println("OutPut Xml ::::::::::::::::::::::::::::::::: :::::: "+convertedXml);
		return convertedXml;
	}

	/** converts Object to XML for given objectClass and jaxbEncoding
	 * This takes the default encoding  as UTF-8
	 * @param object Object to be converted in XML
	 * @return converted XML string
	 * @throws JAXBException
	 */
	public static String convertObjectToXml(Object object) throws JAXBException {
		return convertObjectToXml(object, "UTF-8");
	}



}
