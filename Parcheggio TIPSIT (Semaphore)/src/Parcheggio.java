import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int nMaxPosti;
    private int nPostiLiberi;
    private Semaphore pieno;

    //getter
    public int getnMaxPosti() {
        return nMaxPosti;
    }
    public int getnPostiLiberi() {
        return nPostiLiberi;
    }
    public Semaphore getSemaphore() {
        return pieno;
    }

    //constructor
    public Parcheggio(int nMaxPosti) {
        this.nMaxPosti = nMaxPosti;
        this.nPostiLiberi = nMaxPosti;
        this.pieno = new Semaphore(nMaxPosti);
    }

    //methods
    //fa entrare un auto del parcheggio
    public synchronized void entra() {
        try {
            pieno.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nPostiLiberi--;
    }
    //fa uscire un auto dal parcheggio
    public synchronized void esce() {
        nPostiLiberi++;
        pieno.release();
    }
}
