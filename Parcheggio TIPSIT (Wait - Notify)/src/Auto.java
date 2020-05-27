public class Auto extends Thread {
    private Parcheggio parcheggio;
    private boolean isParcheggiata;

    //getter
    public Parcheggio getParcheggio() {
        return parcheggio;
    }
    public boolean isParcheggiata() {
        return isParcheggiata;
    }

    //constructor
    public Auto(String nome, Parcheggio parcheggio) {
        super(nome);
        this.parcheggio = parcheggio;
        this.isParcheggiata = false;
    }
    //methods
    public void run() {
        //simulo il tempo di guida
        try {
            sleep((int)(Math.random() * 10000));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        //la macchina entra nel parcheggio
        synchronized(parcheggio) {
            parcheggio.entra();
            isParcheggiata = true;
            System.out.println(getName() + " e' entrata\n" +
                                "\t posti liberi: " + parcheggio.getNPosti());
        }
        //simulo il tempo di posteggio
        try {
            sleep((int)(Math.random() * 5000));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        //dopo il tempo di posteggio faccio uscire la macchina dal parcheggio
        synchronized(parcheggio) {
            parcheggio.esce();
            isParcheggiata = false;
            System.out.println(getName() + " e' uscita\n" +
                    "\t posti liberi: " + parcheggio.getNPosti());
        }
    }
}