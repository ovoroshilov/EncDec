package encryption;

public class ShiftCipher implements CipherMessage {
    String message;
    int key;

    public ShiftCipher(String message, int key) {
        this.message = message;
        this.key = key;
    }

    @Override
    public String getEncryptedOrDecryptedText(String act, int key, String message) {
        StringBuilder encryptedOrDecryptedText = new StringBuilder();
        switch (act) {
            case "enc":
                for (char c : message.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        int shift = Character.isUpperCase(c) ? 65 : 97;
                        encryptedOrDecryptedText.append((char) (modulo(c - shift + key) + shift));
                    } else {
                        encryptedOrDecryptedText.append(c);
                    }
                }
                break;
            case "dec":
                encryptedOrDecryptedText.append(decipher(message, key));
                break;
        }
        return encryptedOrDecryptedText.toString();
    }

    public String decipher(String message, int key) {
        return getEncryptedOrDecryptedText("enc", -key, message);
    }

    private static int modulo(int x) {
        return (x % 26 + 26) % 26;
    }
}
