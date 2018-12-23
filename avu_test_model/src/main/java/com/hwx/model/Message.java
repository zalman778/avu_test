package com.hwx.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;

/*
    Класс сущности отправляемых сообщений.
 */
@XmlRootElement(name = "jms_message")
public class Message implements Serializable {
    private String uid;
    private Integer intValue;
    private Integer pickValue;

    private Date createDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dateValue;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Integer getPickValue() {
        return pickValue;
    }

    public void setPickValue(Integer pickValue) {
        this.pickValue = pickValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;

        if ((intValue == null) || (pickValue == null) || dateValue == null || createDate == null)
            return false;

        return (intValue.equals(message.intValue)) &&
               (pickValue.equals(message.pickValue)) &&
               (dateValue.equals(message.dateValue)) &&
               (createDate.equals(message.getCreateDate()));
    }

    @Override
    public int hashCode() {
        return Arrays.asList(intValue, pickValue, dateValue.getTime(), createDate.getTime()).hashCode();
    }

    public static Message parseXml(String xmlString) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);
        return (Message) unmarshaller.unmarshal(reader);
    }

    public static String toXml(Message object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(object, sw);
        return sw.toString();
    }
}
