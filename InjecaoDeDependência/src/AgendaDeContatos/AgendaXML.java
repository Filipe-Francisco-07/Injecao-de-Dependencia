package AgendaDeContatos;

import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AgendaXML extends Agenda {
	
	private List<Contato> contato;
	
	public AgendaXML() {
		contato = new ArrayList<Contato>();
	}
	
    public List<Contato> getContato() {
		return contato;
	}
	public void adicionarContato(Contato contato) {
		this.contato.add(contato);
	}

	public void criarXML(Contato contato) {
		if (contato == null)
			return;
		else {
	        try {
	        	
	            // Criar um DocumentBuilder para criar um novo documento XML
	            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	
	            // Criar o elemento raiz
	            Element rootElement = doc.createElement("Agenda");
	            doc.appendChild(rootElement);
	
	            // Adicionar informações do contato ao documento XML
	            adicionarContato(doc, rootElement, contato);
	
	            // Transformar o documento em um arquivo XML
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	
	            // Especificar o arquivo de saída
	            FileWriter writer = new FileWriter("D:\\agenda.xml");
	            StreamResult result = new StreamResult(writer);
	
	            // Transformar e escrever o arquivo XML
	            transformer.transform(source, result);
	
	            System.out.println("Arquivo XML gerado com sucesso.");
	
	        } catch (ParserConfigurationException | TransformerException | IOException e) {
	            e.printStackTrace();
	        }
		}
    }

    private void adicionarContato(Document doc, Element parentElement, Contato contato) {
        Element contatoElement = doc.createElement("Contato");
        
        Element nomeElement = doc.createElement("Nome");
        nomeElement.appendChild(doc.createTextNode(contato.getNome()));
        contatoElement.appendChild(nomeElement);
        
        Element emailElement = doc.createElement("Email");
        emailElement.appendChild(doc.createTextNode(contato.getEmail()));
        contatoElement.appendChild(emailElement);
        
        Element dataNascimentoElement = doc.createElement("DataNascimento");
        dataNascimentoElement.appendChild(doc.createTextNode(contato.getDatanascimento().toString()));
        contatoElement.appendChild(dataNascimentoElement);
        
        Element telefoneElement = doc.createElement("Telefone");
        telefoneElement.appendChild(doc.createTextNode(contato.getTelefone()));
        contatoElement.appendChild(telefoneElement);
        
        parentElement.appendChild(contatoElement);
    }
}
