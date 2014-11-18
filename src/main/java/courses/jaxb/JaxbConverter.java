package courses.jaxb;

import courses.entity.Employer;
import courses.service.Main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbConverter {

    public static void convertObjectToXml(List <Employer> employers) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(employers, System.out);
            jaxbMarshaller.marshal(employers, Main.JAXB_RESULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static <T> convertXmlToObject(File file) {
//        T entity = new T();
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(T.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//            entity = (T) jaxbUnmarshaller.unmarshal(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return entity;
//    }

}
