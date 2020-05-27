public class Main {
    public static void main(String[] args) {
        Parcheggio P1 = new Parcheggio(10);

        for(int i = 0; i < 30; i++)
            (new Auto("Auto" + i, P1)).start();
    }
}