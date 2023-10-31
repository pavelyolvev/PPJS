import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Document xmlToCheck;
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Scanner scanner = new Scanner(System.in);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        System.out.print("XML для проверки средней оценки: ");
        String readed = scanner.nextLine();
        if(!readed.endsWith(".xml"))
            readed += ".xml";
        xmlToCheck = builder.parse(readed);
        Checker(xmlToCheck);
    }
    static void Checker(Document document){
        boolean filemistake = false;
        NodeList studentList = document.getElementsByTagName("student");

        for (int i = 0; i < studentList.getLength(); i++) {
            Node studentNode = studentList.item(i);
            if(studentNode.getNodeType() == Node.ELEMENT_NODE){
                Element studentElement = (Element) studentNode;
                NodeList subjectList = studentElement.getElementsByTagName("subject");

                ArrayList<Double> marks = new ArrayList<>();
                for (int j = 0; j < subjectList.getLength(); j++) {
                    Node subjectNode = subjectList.item(j);
                    if (subjectNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element subjectElement = (Element) subjectNode;

                        // Получаем значение атрибута 'mark' элемента <subject>
                        String mark = subjectElement.getAttribute("mark");
                        marks.add(Double.parseDouble(mark));
                    }
                }
                Element averageElement = (Element) studentElement.getElementsByTagName("average").item(0);
                double average = Double.parseDouble(averageElement.getTextContent());
                double mSum = 0;
                for (double m: marks) {
                    mSum+=m;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
                double avgCalc = Double.parseDouble(decimalFormat.format((mSum/marks.size())));

                if(average!=avgCalc){

                    averageElement.setTextContent(String.valueOf(decimalFormat.format(avgCalc)));
                }
                filemistake = average != avgCalc;
            }
        }
        if(filemistake){
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                System.out.println("Обнаружены несовпадения. Введите имя выходного файла:");
                Scanner scanner = new Scanner(System.in);
                String readed = scanner.nextLine();
                if(!readed.endsWith(".xml"))
                    readed += ".xml";
                StreamResult result = new StreamResult(new File(readed));
                transformer.transform(source, result);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Сохранение завершено");
        } else System.out.println("Лист группы прошел проверку");
    }
}
