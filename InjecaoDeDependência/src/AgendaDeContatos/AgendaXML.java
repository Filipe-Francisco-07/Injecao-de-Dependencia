package AgendaDeContatos;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
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

public class AgendaXML implements Agenda {
	
	private List<Contato> lista_contato;
	
	public AgendaXML() {
		lista_contato = new ArrayList<Contato>();
	}
	
	
    public void setlista_Contato(List<Contato> contato) {
		this.lista_contato = contato;
	}

	public List<Contato> getLista_contato() {
		return lista_contato;
	}
	public void adicionarContato(Contato contato) {
		this.lista_contato.add(contato);
	}

	public void gravarContatos() {
	        try {
	        	
	            // Criar um DocumentBuilder para criar um novo documento XML
	            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	
	            // Criar o elemento raiz
	            Element rootElement = doc.createElement("Agenda");
	            doc.appendChild(rootElement);
	
	            // Adicionar informações do contato ao documento XML
	            for (Contato contato : lista_contato) {
	            	addContato(doc, rootElement, contato);
	            }
	            // Transformar o documento em um arquivo XML
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	
	            // Especificar o arquivo de saída
	            FileWriter writer = new FileWriter("agenda.xml");
	            StreamResult result = new StreamResult(writer);
	
	            // Transformar e escrever o arquivo XML
	            transformer.transform(source, result);
	
	            System.out.println("Arquivo XML gerado com sucesso.");
	
	        } catch (ParserConfigurationException | TransformerException | IOException e) {
	            e.printStackTrace();
	        }
    }

    private void addContato(Document doc, Element parentElement, Contato contato) {
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
    
    public void removerContato(Contato contato) {
        lista_contato.remove(contato);
        atualizarArquivoXML();
        System.out.println("Contato removido com sucesso.");
    }

    public void alterarContato(Contato contato) {
    	for (Contato c : lista_contato) {
        	if (c.getEmail() == contato.getEmail()) {
	            c.setDatanascimento(contato.getDatanascimento());
	            c.setTelefone(contato.getTelefone());
	            c.setNome(contato.getNome());         
	            atualizarArquivoXML();
	            System.out.println("Contato alterado com sucesso.");
        	} else {
        		System.out.println("Contato não encontrado.");
        	}
        }
    }

    private void atualizarArquivoXML() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element rootElement = doc.createElement("Agenda");
            doc.appendChild(rootElement);

            for (Contato contato : lista_contato) {
                addContato(doc, rootElement, contato);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            FileWriter writer = new FileWriter("agenda.xml");
            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);

            System.out.println("Arquivo XML atualizado com sucesso.");

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarLista() {
    	System.out.println("Lista XML: ");
	    try {
	        FileReader fileReader = new FileReader("agenda.xml");
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String linha;

	        while ((linha = bufferedReader.readLine()) != null) {
	            System.out.println(linha);
	        }	        
	        bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}