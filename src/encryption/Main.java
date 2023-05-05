package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    String inputMassage = "";
    int inputKey = 0;
    String act = "enc";
    String in = null;
    String out = null;
    String alg = "shift";

    public static void main(String[] args) {
        Main main = new Main();
        main.setArguments(args);
        main.start();
    }

    public void setArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> act = args.length > i + 1 ? args[i + 1] : "enc";
                case "-key" -> inputKey = args.length > i + 1 ? Integer.parseInt(args[i + 1]) : 0;
                case "-data" -> inputMassage = args.length > i + 1 ? args[i + 1] : "";
                case "-in" -> in = args.length > i + 1 ? args[i + 1] : null;
                case "-out" -> out = args.length > i + 1 ? args[i + 1] : null;
                case "-alg" -> alg = args.length > i + 1 ? args[i + 1] : "shift";
            }
        }
    }

    public String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public void outputFile(String text, String name) {
        try (FileWriter writeFile = new FileWriter(name, false)) {
            writeFile.write(text);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


    public void start() {
        CipherStrategyMethod cipherStrategyMethod = new CipherStrategyMethod();
        if (alg.equals("shift")) {
            cipherStrategyMethod.setCipherMessage(new ShiftCipher(inputMassage, inputKey));
        } else {
            cipherStrategyMethod.setCipherMessage(new UnicodeCipher(inputMassage, inputKey));
        }

        if (inputMassage.equals("") && in != null) {
            try {
                inputMassage = readFile(in);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
        inputMassage = cipherStrategyMethod.getEncryptedOrDecryptedText(act, inputKey, inputMassage);

        if (out != null) {
            outputFile(inputMassage, out);
        } else {
            System.out.println(inputMassage);
        }
    }
}