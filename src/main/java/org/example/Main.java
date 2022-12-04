package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int in = 0;

        do {
            System.out.println("-----------------------------\n" +
                    "Выберите действие: \n" +
                    "1 - Список задач \n" +
                    "2 - Добавить задачу \n" +
                    "3 - Получить задачу \n" +
                    "4 - Удалить задачу \n" +
                    "0 - Выход \n"
            );
            in = keyboard.nextInt();

            switch (in) {
                case 1:
                    String issues = Web.getStates();
                    System.out.println(issues);
                    break;
                case 2:
                    State state = new State();
                    state.id = Instant.now().getEpochSecond();
                    state.time = new Date();


                    try {
                        JAXBContext context = JAXBContext.newInstance(State.class);
                        javax.xml.bind.Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        StringWriter sw = new StringWriter();
                        m.marshal(state, sw);
                        String finalXML = sw.toString().substring(62, sw.toString().length() - 9);
                        finalXML = "<arg0" + finalXML;
                        System.out.println(finalXML);

                        Web.addState(finalXML);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }

                    break;
                default:
                    System.out.println("Без реализации");
            }

        } while (in != 0);
    }
}