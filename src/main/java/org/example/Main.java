package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int in = 0;

        do {
            System.out.println("-----------------------------\n" +
                    "Select an action: \n" +
                    "1 - List of entries \n" +
                    "2 - Add an entry \n" +
                    "0 - Exit \n"
            );
            in = keyboard.nextInt();

            switch (in) {
                case 1:
                    String states = Web.getStates();
                    System.out.println(states);
                    break;
                case 2:
                    State state = new State();
                    state.id = Instant.now().getEpochSecond();
                    state.time = new Date();
                    state.sensorValues = new ArrayList<>();

                    String[] anArray = new String[2];
                    anArray[0] = "Celsius degree"; //градусы Цельсия
                    anArray[1] = "percentages";  //проценты

                    int command = 0;
                    while(true) {
                        System.out.println("Select id sensor for adding data");
                        System.out.println("To exit, enter -1");
                        for (int i = 0; i < anArray.length; i++) {
                            if (i == 0)
                                System.out.println(i + " Temperature, C");
                            if (i == 1)
                                System.out.println(i + " Humidity, %");
                        }
                        command = keyboard.nextInt();
                        if (command == -1)
                            break;
                        if (command < 0 || command >= anArray.length) {
                            System.out.println("Enter the correct value from the list"); //Введите корректное значение из списка
                            continue;
                        }
                        SensorValue sv = new SensorValue();
                        sv.id = command;
                        sv.data_type = anArray[command];
                        System.out.println("Enter the sensor value");
                        sv.value = keyboard.nextInt();

                        state.sensorValues.add(sv);
                    }


                    try {
                        JAXBContext context = JAXBContext.newInstance(State.class);
                        javax.xml.bind.Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        StringWriter sw = new StringWriter();
                        m.marshal(state, sw);
                        String finalXML = sw.toString().substring(62, sw.toString().length() - 9);
                        finalXML = "<arg0" + finalXML;
                        //System.out.println(finalXML);

                        Web.addState(finalXML);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }

                    break;
                default:
                    System.out.println("Without realization");
            }

        } while (in != 0);
    }
}