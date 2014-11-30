package courses.jaxb;

import courses.service.StartMain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JaxbConverter {

    public static void convertEmployersToXml(EmployersGroup entity) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance (EmployersGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entity, System.out);
            jaxbMarshaller.marshal(entity, StartMain.JAXB_EMPLOYERS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
