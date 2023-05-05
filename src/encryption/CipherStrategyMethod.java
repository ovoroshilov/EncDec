package encryption;

public class CipherStrategyMethod {
    private CipherMessage cipherMessage;

    public void setCipherMessage(CipherMessage cipherMessage) {
        this.cipherMessage = cipherMessage;
    }
    public String getEncryptedOrDecryptedText(String act, int key, String message) {
       return this.cipherMessage.getEncryptedOrDecryptedText(act, key, message);
    }
}
