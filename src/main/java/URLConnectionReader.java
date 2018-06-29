import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLConnectionReader {

    final QName ICON = new QName("http://tehnomir.com.ua/", "icon");


    public URLConnectionReader() throws IOException, XMLStreamException {
        URL technomir = new URL("http://tehnomir.com.ua");
        InputStream input = technomir.openStream();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader r = factory.createXMLEventReader("http://tehnomir.com.ua/ws/xml.php?act=GetPrice&usr_login=Autounion&usr_passwd=Tvy188&Number=0986479606", input);
         System.out.println(r.getElementText());
        try {
            while (r.hasNext()) {
                XMLEvent event = r.peek();
                if (event.isStartElement()) {
                    StartElement start = event.asStartElement();
                    if (ICON.equals(start.getName())) {
                        System.out.println(r.getElementText());
                        break;
                    }
                }
                System.out.println(r);
                r.nextEvent();
            }

        } finally {
            r.close();
        }
        input.close();
    }
}