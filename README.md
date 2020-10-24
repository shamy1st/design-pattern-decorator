# Decorator Design Pattern (Java)

**Decorator** add additional behaviour to an object.
![](https://github.com/shamy1st/design-pattern-decorator/blob/main/uml.png)
### Problem: 
You have **CLoudStream** class that store data to a cloud service and **EncryptedCloudStream** class that encrypt data before storing it and **CompressedCloudStream** class that compress data before storing it, now you want to (1. encrypt, 2. compress, 3. store).

The issue with this implementation that now you want to create another class **CompressedAndEncryptedCloudStream** extends **CloudStream** and implement the same functionality again in the required order!

    public class Main {
        public static void main(String[] args) {
            CloudStream cloudstream = new EncryptedCloudStream();
            cloudstream.write("some data");
        }
    }

    public class CloudStream {
        public void write(String data) {
            System.out.println("Storing " + data);
        }
    }

    public class EncryptedCloudStream extends CloudStream {
        @Override
        public void write(String data) {
            String encryptedData = encrypt(data);
            super.write(encryptedData);
        }
        
        private String encrypt(String data) {
            return "encrypted-(" + data + ")";
        }
    }

    public class CompressedCloudStream extends CloudStream {
        @Override
        public void write(String data) {
            String compressedData = compress(data);
            super.write(compressedData);
        }
        
        private String compress(String data) {
            return "compressed-(" + data + ")";
        }
    }

### Solution:
![](https://github.com/shamy1st/design-pattern-decorator/blob/main/uml-solution.png)
