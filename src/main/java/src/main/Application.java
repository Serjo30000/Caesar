package src.main;

import src.cipher.CaesarCipher;

public class Application {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher("Pen","Hello my name is Sergey");
        System.out.println("Стандартный текст: " + caesarCipher.getText());
        caesarCipher.encryption();
        System.out.println("Зашифрованный текст: " + caesarCipher.getText());
        caesarCipher.decryption();
        System.out.println("Дешифрованный текст: " + caesarCipher.getText());
    }
}
