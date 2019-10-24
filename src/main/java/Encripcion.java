import java.util.Scanner;

public class Encripcion {


    public static void main(String[] args) {

        final String secretKey;
        String contentString;

        Scanner myObj = new Scanner(System.in);

        System.out.println("Ingrese llave:");
        secretKey = myObj.nextLine();

        System.out.println("Ruta del archivo:");
        String pathValue = myObj.nextLine();

        System.out.println("Salida Archivo:");
        String newPathValue = myObj.nextLine();

        System.out.println("Opcion:");
        String opcionValue = myObj.nextLine();


        FilesOperation filesOperation = new FilesOperation();
        String originalString = filesOperation.readFile(pathValue);


        if(opcionValue.equals("E")){
            contentString = AES.encrypt(originalString, secretKey);
        }
        else{
            contentString = AES.decrypt(originalString, secretKey);
        }


        filesOperation.writeFile(contentString, newPathValue);

        System.out.println("Finalizo");

    }

}
