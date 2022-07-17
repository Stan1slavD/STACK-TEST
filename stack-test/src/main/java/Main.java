import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        CSVWorker.readData(subscribers);
        //subscribers.forEach(x -> System.out.println(x.toString()));
        CSVWorker.writeAccruedData(subscribers);
        CSVWorker.writeSumData(subscribers);
    }
}
