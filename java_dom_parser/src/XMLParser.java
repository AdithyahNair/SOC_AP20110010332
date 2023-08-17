import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("employee.xml");
			StringBuilder table = new StringBuilder();
			table.append("<table border=\"1\">");
			table.append("<tr><th>id</th><th>firstName</th><th>lastName</th><th>hireDate</th><th>deptCode</th><th>salary</th></tr>");
			NodeList employeeList = doc.getElementsByTagName("employee");
			for(int i=0; i<employeeList.getLength(); i++) {
				Node e = employeeList.item(i);
				if(e.getNodeType()==Node.ELEMENT_NODE) {
					Element employee = (Element) e;
					String id = employee.getAttribute("id");
					table.append("<tr>");
					NodeList nameList = employee.getChildNodes();
					table.append("<td>").append(id).append("</td>");
					for(int j=0; j<nameList.getLength(); j++) {
						Node n = nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE) {
							Element name = (Element) n;
							table.append("<td>").append(name.getTextContent()).append("</td>");
						}
					}
					table.append("</tr>");
				}
			}
			table.append("</table>");
			System.out.println(table.toString());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
