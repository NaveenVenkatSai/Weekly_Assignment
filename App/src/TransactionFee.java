import java.util.*;
public class TransactionFee {
    String id;
    double fee;
    String timestamp; // HH:mm format
    public TransactionFee(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TransactionFee{" +
                "id='" + id + '\'' +
                ", fee=" + fee +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
