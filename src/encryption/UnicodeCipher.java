package encryption;

public class UnicodeCipher implements CipherMessage{
    String message;
    int key;

    public UnicodeCipher(String massage, int key) throws NullPointerException {
        this.message = massage;
        this.key = key;
    }

    public String getEncryptedOrDecryptedText(String act, int key, String message) {
        StringBuilder encryptedOrDecryptedText = new StringBuilder();
        switch (act) {
            case "enc":
                for (char letter : message.toCharArray()) {
                    encryptedOrDecryptedText.append((char) (letter + key));
                }
                break;
            case "dec":
                for (char letter : message.toCharArray()) {
                    encryptedOrDecryptedText.append((char) (letter - key));
                }
                break;
        }
        return encryptedOrDecryptedText.toString();
    }
}
