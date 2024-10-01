package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise32 {

    public static void main(String[] args) {

        // Llamar al método para generar una cadena
        String textToSave = generateStringToSave(null); // Se pasa null para que llame a generateUserInputToSave()

        // Escribir la cadena en el archivo
        printToFile(textToSave);

        System.out.println("El texto ha sido guardado en el archivo data.txt");
    }

    public static String generateStringToSave(String string) {
        // Si la cadena es nula, generar la entrada del usuario
        if (string == null) {
            return generateUserInputToSave();
        }
        return string; // Si se pasa una cadena, devolverla directamente
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data.txt"))) {
            writer.write(string); // no crea el directorio resource ahi puede fallar
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


}
