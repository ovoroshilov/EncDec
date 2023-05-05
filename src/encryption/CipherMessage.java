package encryption;

public interface CipherMessage {
   public String getEncryptedOrDecryptedText(String act, int key, String message);
}
