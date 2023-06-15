package org.example;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory. newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse( new File("data.xml"));
        Node root = doc.getDocumentElement();
        System.out.println( "Корневой элемент: " + root.getNodeName());
        read(root);
    }
    private static void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                System. out.println( "Текущий узел: " + node_.getNodeName());
                Element element = (Element) node_;
                NamedNodeMap map = element.getAttributes();
                for (int a = 0; a < map.getLength(); a++) {
                    String attrName = map.item(a).getNodeName();
                    String attrValue = map.item(a).getNodeValue();
                    System. out.println( "Атрибут: " + attrName + "; значение: " + attrValue);
                }
                read(node_);
            }
        }
    }
}