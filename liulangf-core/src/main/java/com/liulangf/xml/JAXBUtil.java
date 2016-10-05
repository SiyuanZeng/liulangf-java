package com.liulangf.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@SuppressWarnings("unchecked")
public class JAXBUtil {

    private static ConcurrentHashMap<Class<?>, JAXBContext> jaxbContextMap = new ConcurrentHashMap<Class<?>, JAXBContext>();

    private static JAXBContext getJAXBContext(Class<?> clazz) throws JAXBException {
    	JAXBContext jc = null;
    	if (jaxbContextMap.get(clazz) == null) {
            jc = JAXBContext.newInstance(new Class[] { clazz }, Collections.EMPTY_MAP);
            jaxbContextMap.put(clazz, jc);
        } else {
            jc = (JAXBContext) jaxbContextMap.get(clazz);
        }
    	return jc;
    }
    
    public static String marshToXml(Object t) throws JAXBException {
        JAXBContext jc = getJAXBContext(t.getClass());
        Marshaller u = jc.createMarshaller();
        u.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        u.marshal(t, sw);
        return sw.toString();
    }

    public static void marshToXml(Object t, File file) throws JAXBException {
    	JAXBContext jc = getJAXBContext(t.getClass());
        Marshaller u = jc.createMarshaller();
        u.setProperty("jaxb.formatted.output", Boolean.TRUE);
        u.marshal(t, file);
    }

    public static <T> T unmarshToObj(Class<T> tclz, String xmlstr) throws JAXBException {
        JAXBContext jc = getJAXBContext(tclz);
        Unmarshaller un = jc.createUnmarshaller();
        try {
            return (T) un.unmarshal(new ByteArrayInputStream(xmlstr.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            //never happen
            return null;
        }
    }

    public static <T> T unmarshToObj(Class<T> tclz, File file) throws JAXBException {
        JAXBContext jc = getJAXBContext(tclz);
        Unmarshaller un = jc.createUnmarshaller();
        return (T) un.unmarshal(file);
    }

    public static <T> T unmarshToObj(Class<T> tclz, InputStream file) throws JAXBException {
        JAXBContext jc = getJAXBContext(tclz);
        Unmarshaller un = jc.createUnmarshaller();
        return (T) un.unmarshal(file);
    }
    
}