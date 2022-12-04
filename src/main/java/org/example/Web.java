package org.example;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Web {
    private static final String API_ROOT = "http://desktop-0c0ducf:8080/lab2-114208892494867541476.0-SNAPSHOT/ApplicationServiceImplService";

    public static String addState(String state) throws MalformedURLException, IOException, MalformedURLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String responseString = "";
        StringBuilder outputString = new StringBuilder();

        URL url = new URL(API_ROOT);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        String xmlInputString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <SOAP-ENV:Header/>\n" +
                "    <S:Body>\n" +
                "        <ns2:addState xmlns:ns2=\"http://lab2.mycompany.com/\">\n" +
                            state +
                "           </arg0>   \n" +
                "        </ns2:addIssue>\n" +
                "    </S:Body>\n" +
                "</S:Envelope>";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(xmlInputString.getBytes());
        byte[] bytes = byteArrayOutputStream.toByteArray();


        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
        httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpURLConnection.setRequestProperty("SOAPAction", "addCity");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);

        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bytes);
        outputStream.close();


        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while ((responseString = bufferedReader.readLine()) != null) {
            outputString.append(responseString);
        }

        return outputString.toString();
    }

    public static String getStates() {

        String responseString = "";
        StringBuilder sb = new StringBuilder();
        String result = new String();

        try {
            java.net.URL url = new URL(API_ROOT);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

            String xmlInputString = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "    <Body>\n" +
                    "        <getAllState xmlns=\"http://lab2.mycompany.com/\"/>\n" +
                    "    </Body>\n" +
                    "</Envelope>";

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(xmlInputString.getBytes());
            byte[] bytes = byteArrayOutputStream.toByteArray();


            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpURLConnection.setRequestProperty("SOAPAction", "getAllCities");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();


            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((responseString = bufferedReader.readLine()) != null) {
                sb.append(responseString);
            }

            result = sb.toString().substring(183, sb.toString().length()-58);
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
