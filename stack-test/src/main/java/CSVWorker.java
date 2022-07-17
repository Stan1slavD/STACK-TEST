import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CSVWorker {

    public static void readData(ArrayList<Subscriber> subscribers) {
        String[] nextLine;
        ArrayList<String> str = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("абоненты.csv"), ',', '"', 1);
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    str.add(Arrays.toString(nextLine));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < str.size(); i++) {
            String sub[] = str.get(i).substring(1, str.get(i).length() - 1).split(";");
            subscribers.add(new Subscriber(Integer.parseInt(sub[0]), sub[1], sub[2], Integer.parseInt(sub[3]), Integer.parseInt(sub[4]), Integer.parseInt(sub[5]), Integer.parseInt(sub[6]), Integer.parseInt(sub[7])));
        }
    }

    public static void writeAccruedData(ArrayList<Subscriber> subscribers) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("Начисления_абоненты.csv"), ';', CSVWriter.NO_QUOTE_CHARACTER);
            String[] str = "№ строки;Фамилия;Улица;№ дома;№ Квартиры;Тип начисления;Предыдущее;Текущее;Начислено".split(";");
            writer.writeNext(str);
            subscribers.forEach(s -> writer.writeNext(s.toStringAccured().split(" ")));
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void writeSumData(ArrayList<Subscriber> subscribers) {
        HashMap<String, Double> houses = new HashMap<>();
        subscribers.forEach(s -> {
            if (houses.containsKey((s.getStreet() + " " + s.getHouse())) == false) {
                houses.put((s.getStreet() + " " + s.getHouse()), s.getAccrued());
            } else
                houses.put((s.getStreet() + " " + s.getHouse()), houses.get(s.getStreet() + " " + s.getHouse()) + s.getAccrued());
        });
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("Начисления_дома.csv"), ';', CSVWriter.NO_QUOTE_CHARACTER);
            String[] str = "№ строки;Улица;№ дома;Начислено".split(";");
            writer.writeNext(str);
            int i = 1;
            for (Map.Entry<String, Double> entry : houses.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                String addres[] = key.split(" ");
                writer.writeNext(new String[]{String.valueOf(i), addres[0], addres[1], String.valueOf(value)});
                i++;
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
