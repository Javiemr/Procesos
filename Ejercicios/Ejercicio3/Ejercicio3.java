import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ContarPalabras {
    public static void main(String[] args) {
        try {
            Process procesoWc = Runtime.getRuntime().exec("wc");
            BufferedReader entradaWc = new BufferedReader(new InputStreamReader(procesoWc.getInputStream()));
            BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));

            String linea;

            while (true) {
                System.out.print("cuentapalenlin> ");
                linea = entradaTeclado.readLine();

                if (linea.isEmpty()) {
                    break;
                }

                procesoWc.getOutputStream().write(linea.getBytes());
                procesoWc.getOutputStream().write("\n".getBytes());
                procesoWc.getOutputStream().flush();

                String resultadoWc = entradaWc.readLine();
                String[] partes = resultadoWc.split("\\s+");

                int num_lineas = Integer.parseInt(partes[0]);
                int num_palabras = Integer.parseInt(partes[1]);
                int num_caracteres = Integer.parseInt(partes[2]);

                System.out.println("La línea tiene " + num_lineas + " líneas, " + num_palabras + " palabras y " + num_caracteres + " caracteres.");
            }

            procesoWc.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
