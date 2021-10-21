public class Kurz {
    String state;
    String menaShortcut;
    String amount;

    public Kurz(String state, String menaShortcut, String amount) {
        this.state = state;
        this.menaShortcut = menaShortcut;
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public String getMenaShortcut() {
        return menaShortcut;
    }

    public String getAmount() {
        return amount;
    }
}
