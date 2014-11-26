package courses.jaxb;

import courses.entity.DepartmentsGroup;
import courses.service.Main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JaxbConverter {

    public static void convertDepartmentsToXml(DepartmentsGroup entity) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentsGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entity, System.out);
            jaxbMarshaller.marshal(entity, Main.JAXB_DEPARTMENTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public void marshallExample() {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Department.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(createJavaObjectExample1(), System.out);
//        } catch (JAXBException exception) {
//            Logger.getLogger(Application.class.getName()).
//                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
//        }
//    }

//
//    public static void main(String[] argv) throws Exception {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        DOMImplementation impl = builder.getDOMImplementation(); // более сложный, но и более гибкий способ создания документов
//        Document doc = impl.createDocument(null, // namespaceURI
//                null, // qualifiedName
//                null); // doctype
//        Element e1 = doc.createElement("api");
//        doc.appendChild(e1);
//        Element e2 = doc.createElement("java");
//        e2.setAttribute("url", "http://www.quizful.net");
//        e1.appendChild(e2);
//    }

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
