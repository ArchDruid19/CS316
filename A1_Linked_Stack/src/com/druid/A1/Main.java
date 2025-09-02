package com.druid.A1;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedQueue queue_1 = new LinkedQueue();
        Person[] people_array = readPersonDataToQueue("people.txt");

        queue_1.enqueue(people_array[0]);
        queue_1.enqueue(people_array[1]);
        queue_1.enqueue(people_array[2]);

        System.out.println(queue_1.head.person);
        System.out.println(queue_1.dequeue());
        System.out.println(queue_1.head.person);

        queue_1.displayIterative();
    }

    public static Person[] readPersonDataToQueue(String filename) {
        Person[] person_queue = new Person[100];
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            int counter = 0;
            while (input.hasNext()) {
                String data = input.nextLine();
                String[] split_data = data.split(",");
                Person temp_person = new Person(split_data[0], split_data[1]);
                person_queue[counter] = temp_person;
                counter++;
            }

            input.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return person_queue;

    }
}
