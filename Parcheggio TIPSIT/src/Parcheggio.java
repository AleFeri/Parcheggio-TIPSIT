public class Parcheggio {
    private int nPosti;

    //getter
    public int getNPosti() {
        return nPosti;
    }

    //constructor
    public Parcheggio(int posti) {
        this.nPosti= posti;
    }

    //methods
    //fa entrare un auto del parcheggio
    public synchronized void entra() {
        //mette la macchina in attesa finche' non si libera un posto
        while (nPosti == 0) {
            try {
                wait();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //quando il parcheggio si libera conta la macchina come se fosse dentro
        nPosti--;
    }
    //fa uscire un auto dal parcheggio
    public synchronized void esce() {
        //quando la macchina esce, libera il posto
        nPosti++;
        notifyAll();
    }
}