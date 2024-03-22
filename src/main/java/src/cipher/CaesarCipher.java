package src.cipher;

public class CaesarCipher {
    private String key;
    private String text;
    private boolean activeCipher;

    public CaesarCipher(String key, String text){
        this.key = key;
        this.setText(text);
        this.activeCipher = false;
    }

    public void encryption(){
        if (!activeCipher){
            activeCipher = true;
            for (char k : key.toCharArray()){
                StringBuilder shifted = new StringBuilder();
                for (char c : text.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char base;
                        if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN) {
                            base = Character.isUpperCase(c) ? 'A' : 'a';
                            int offset = (c - base + ((int) k)) % 26;
                            if (offset < 0) {
                                offset += 26;
                            }
                            shifted.append((char) (base + offset));
                        }
                    } else {
                        shifted.append(c);
                    }
                }
                text = shifted.toString();
            }
        }
    }

    public void decryption(){
        if (activeCipher){
            activeCipher = false;
            for (char k : key.toCharArray()){
                StringBuilder shifted = new StringBuilder();
                for (char c : text.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char base;
                        if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN) {
                            base = Character.isUpperCase(c) ? 'A' : 'a';
                            int offset = (c - base - ((int) k)) % 26;
                            if (offset < 0) {
                                offset += 26;
                            }
                            shifted.append((char) (base + offset));
                        }
                    } else {
                        shifted.append(c);
                    }
                }
                text = shifted.toString();
            }
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        activeCipher = false;
    }
}
