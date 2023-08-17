package AgendaDeContatos;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TesteXml {
    public static void main(String[] args) {
        try {
            // Criar um DocumentBuilder para criar um novo documento XML
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            // Criar o elemento raiz
            Element rootElement = doc.createElement("Int");
            doc.appendChild(rootElement);

            // Adicionar strings ao documento
            addStringElement(doc, rootElement, "Hello");
            addStringElement(doc, rootElement, "World");
            addStringElement(doc, rootElement, "Java");
            addStringElement(doc, rootElement, "2");

            // Transformar o documento em um arquivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            // Especificar o arquivo de saída
            FileWriter writer = new FileWriter("D:\\strings.xml");
            StreamResult result = new StreamResult(writer);

            // Transformar e escrever o arquivo XML
            transformer.transform(source, result);

            System.out.println("Arquivo XML gerado com sucesso.");

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStringElement(Document doc, Element parentElement, String value) {
        Element stringElement = doc.createElement("String");
        stringElement.appendChild(doc.createTextNode(value));
        parentElement.appendChild(stringElement);
    }
}
