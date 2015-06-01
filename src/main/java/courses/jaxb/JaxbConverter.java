package courses.jaxb;

import courses.service.Main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JaxbConverter {

    public static void convertEmployersGroupToXml(EmployersGroup entity) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance (EmployersGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entity, System.out);
            jaxbMarshaller.marshal(entity, Main.JAXB_EMPLOYERS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
