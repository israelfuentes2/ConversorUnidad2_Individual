import java.util.Arrays;
import java.util.Scanner;

public class ConversorBaseNumerica {

    public static int[] convertirBase(int numero, int base) {
        if (numero == 0) return new int[]{0};
        int[] digitos = new int[32];
        int idx = 0;
        while (numero > 0) {
            digitos[idx++] = numero % base;
            numero /= base;
        }
        int[] resultado = new int[idx];
        for (int i = 0; i < idx; i++) {
            resultado[i] = digitos[idx - i - 1];
        }
        return resultado;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static boolean linearSearch(int[] arr, int objetivo) {
        for (int num : arr) {
            if (num == objetivo) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int objetivo) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (arr[medio] == objetivo) return true;
            if (arr[medio] < objetivo) inicio = medio + 1;
            else fin = medio - 1;
        }
        return false;
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número en base 10: ");
        int numero = sc.nextInt();

        int[] binario = convertirBase(numero, 2);
        int[] octal = convertirBase(numero, 8);
        int[] hex = convertirBase(numero, 16);

        System.out.print("Binario: "); imprimirArreglo(binario);
        System.out.print("Octal: "); imprimirArreglo(octal);
        System.out.print("Hexadecimal: "); imprimirArreglo(hex);

        int[] copia = Arrays.copyOf(binario, binario.length);
        bubbleSort(copia);
        System.out.print("Binario ordenado (Burbuja): "); imprimirArreglo(copia);

        copia = Arrays.copyOf(binario, binario.length);
        insertionSort(copia);
        System.out.print("Binario ordenado (Inserción): "); imprimirArreglo(copia);

        copia = Arrays.copyOf(binario, binario.length);
        Arrays.sort(copia);
        System.out.print("Binario ordenado (Arrays.sort): "); imprimirArreglo(copia);

        System.out.print("Ingrese un dígito a buscar en el binario: ");
        int objetivo = sc.nextInt();

        System.out.println("Lineal: " + (linearSearch(binario, objetivo) ? "Encontrado" : "No encontrado"));
        Arrays.sort(binario);
        System.out.println("Binaria propia: " + (binarySearch(binario, objetivo) ? "Encontrado" : "No encontrado"));
        System.out.println("Binaria Arrays.binarySearch: " +
            (Arrays.binarySearch(binario, objetivo) >= 0 ? "Encontrado" : "No encontrado"));

        sc.close();
    }
}