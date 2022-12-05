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
                    "Выберите действие: \n" +
                    "1 - Список записей \n" +
                    "2 - Добавить запись \n" +
                    "3 - Получить запись \n" +
                    "4 - Удалить запись \n" +
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
                    state.sensorValues = new ArrayList<>();

                    String[] anArray = new String[2];
                    anArray[0] = "градусы цельсия";
                    anArray[1] = "проценты";

                    int command = 0;
                    while(true) {
                        System.out.println("Выберите id сенсора, для которого хотите добавить данные");
                        System.out.println("Для выхода введите -1");
                        for (int i = 0; i < anArray.length; i++) {
                            if (i == 0)
                                System.out.println(i + " Температура в градусах цельсия");
                            if (i == 1)
                                System.out.println(i + " Влажность в процентах");
                        }
                        command = keyboard.nextInt();
                        if (command == -1)
                            break;
                        if (command < 0 || command >= anArray.length) {
                            System.out.println("Введите корректное значение из списка");
                            continue;
                        }
                        SensorValue sv = new SensorValue();
                        sv.id = command;
                        sv.data_type = anArray[command];
                        System.out.println("Введите показатель сенсора");
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
                    System.out.println("Без реализации");
            }

        } while (in != 0);
    }
}