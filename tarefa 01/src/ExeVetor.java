import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExeVetor {
  // * --- vars ----------------------------------------------------------- * //
  static final String operatingSystem = System.getProperty("os.name");
  static private Scanner scanner = new Scanner(System.in);
  static private int arrlength = 20;
  static private int[] vector = new int[arrlength];
  
  static private String text = "\nEscolha uma função digitando um número:\n"
  + "1) Criar ou zerar uo vetor;\n"
  + "2) Inserir um valor no vetor;\n"
  + "3) Apagar um valor do vetor;\n"
  + "4) Consultar se existe determinado valor no vetor;\n"
  + "5) Consultar quantos valores significativos "
  + "ocupam o vetor;\n"

  + "6) Consultar qual o maior valor armazenado;\n"
  + "7) Consultar qual o menor valor armazenado;\n"
  + "8) Listar dos valores armazenados no vetor;\n"
  + "0) Sair;";

  static Map<String, Runnable> commands = new HashMap<>();
  
  // * --- functions ------------------------------------------------------ * //

  static void emptyArray() {
    for (int i = 0; i < arrlength; i++) {
      vector[i] = 0;
    }

    return;
  };

  // ------------------------------------------------------------------------ //

  static void addValueToArray() {
    System.out.println("\nValor para ser inserido: ");
    Integer value = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] == 0) {
        vector[i] = value;
        return;
      }
    }

    System.out.println("\nVetor cheio!\n");
    return;
  }
  
  // ------------------------------------------------------------------------ //
  
  static void removeValueToArray() {
    System.out.println("\nValor para ser removido: ");
    Integer value = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] == value) {
        vector[i] = 0;
        return;
      }
    }

    System.out.println("\nValor não encontrado!\n");
    return;
  }

  // ------------------------------------------------------------------------ //

  static void findValueInArray() {
    System.out.println("\nValor para ser encontrado: ");
    Integer value = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] == value) {
        System.out.printf("Encontrado o valor %s na posição %s\n", value, i);
        return;
      }
    }

    System.out.println("\nValor não encontrado!\n");
    return;
  }
  
  // ------------------------------------------------------------------------ //


  static void countValues() {
    int counter = 0;
    System.out.println("\nQuantidade de valores significativos no vetor:");

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] != 0) {
        counter++;
      }
    }

    System.out.printf("\n%s\n", counter);
    return;
  }
  
  // ------------------------------------------------------------------------ //
  
  static void biggestValue() {
    int biggest = 0;
    int position = 0;
    System.out.println("\nO maior valor no vetor é:");

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] > biggest) {
        biggest = vector[i];
        position = i;
      }
    }

    System.out.printf("\n%s, na posição %s\n", biggest, position);
    return;
  }
  
  // ------------------------------------------------------------------------ //

  static void lowestValue() {
    int lowest = Integer.MAX_VALUE;
    int position = 0;
    System.out.println("\nO menor valor no vetor é:");

    for (int i = 0; i<arrlength; i++) {
      if (vector[i] < lowest && vector[i] != 0) {
        lowest = vector[i];
        position = i;
      }
    }

    System.out.printf("\n%s, na posição %s\n", lowest, position);
    return;
  }
  
  // ------------------------------------------------------------------------ //

  static void listArray() {
    System.out.print("\nListagem do vetor:\n[ ");

    for (int i = 0; i < 20; i++) {
      System.out.printf("%s, ", vector[i]);
    }

    System.out.print("]\n\n");
  }

  // * --- main ----------------------------------------------------------- * //

  public static void main(String[] args) throws Exception {    
    commands.put("1", () -> emptyArray());
    commands.put("2", () -> addValueToArray());
    commands.put("3", () -> removeValueToArray());
    commands.put("4", () -> findValueInArray());
    commands.put("5", () -> countValues());
    commands.put("6", () -> biggestValue());
    commands.put("7", () -> lowestValue());
    commands.put("8", () -> listArray());
    
    while (true) {
      System.out.println(text);
      String action = scanner.nextLine();

      if (action.equals("0")) break;
      
      Runnable commandExists = commands.get(action);

      if (commandExists == null) {
        System.out.println("Comando inválido!\n");
        continue;
      }

      commands.get(action).run();

      System.out.println("\n\n");
    }
  }
}
