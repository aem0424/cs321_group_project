package cs321project;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Parser.java
 Dr. Huaming Zhang
 CS 321-03
 November 26, 2021

 This class reads through the .xml file used for storing the food data in order
 to use it for
*/

public class Parser extends DefaultHandler {
   boolean smallPrice = false;
   boolean largePrice = false;

   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

      if (qName.equalsIgnoreCase("type")) {
         tracker++;
      }
      else if (qName.equalsIgnoreCase("small")) {
         smallPrice = true;
      }
      else if (qName.equalsIgnoreCase("large")) {
         largePrice = true;
      }
      else if (qName.equalsIgnoreCase("\\type")) {
         tracker--;
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
      
      String temp = new String(ch, start, length);
      if (smallPrice) {
         Constants.PRICE_DATABASE.prices[tracker - 1][0] = Float.parseFloat(temp);
         smallPrice = false;
      } else if (largePrice) {
         Constants.PRICE_DATABASE.prices[tracker - 1][1] = Float.parseFloat(temp);
         largePrice = false;
      }
   }
   
   // PRIVATE VARIABLES
   private int tracker = 0; // Used to track which food item the parser is currently on
} // END OF FILE