import java.util.InputMismatchException;
import java.util.Scanner;

public class LiquidacionNomina {
    public static void liquidarNomina() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuantos empleados quiere liquidar: ");
        int numEmpleados = scanner.nextInt();  //esto me permite liquidar cierta cantidad de usuarios segun lo que ingrese

        for (int i = 0; i < numEmpleados; i++) { //aqui lo que hago es incrementar dependiendo la cantidad de usuarios que necesito liquidar
            System.out.println("\nEmpleado #" + (i + 1));
            System.out.print("digite su nombre ");
            String nombre = scanner.next();
            System.out.print("digite su apellido ");
            String apellido = scanner.next();
            System.out.print("digite su documento: ");
            String documento = scanner.next();
            System.out.print("digite los días que trabajados: ");
            int diasTrabajados = scanner.nextInt();
            System.out.print("digite si realizo horas extras: ");
            int horasExtras = scanner.nextInt();
            System.out.print("digite si realizo recargos recargos nocturnos: ");
            int recargosNocturnos = scanner.nextInt();
            System.out.print("¿recibe subsidio de transporte? (si o no): ");
            boolean recibeSubsidioTransporte = scanner.next().equalsIgnoreCase("Sí");

            double salarioBasico = 1000000; // Ejemplo: salario básico fijo
            double valorHora = salarioBasico / 240; // salario por hora (8 horas al día * 30 días)
            double valorHoraExtra = valorHora * 1.25; // alor de la hora extra (suponiendo 25% más)
            double valorRecargoNocturno = valorHora * 1.35; //valor del recargo nocturno (suponiendo 35% más)

            // aqui estoy calculando  horas extras y recargos nocturnos
            double totalHorasExtras = horasExtras * valorHoraExtra;
            double totalRecargosNocturnos = recargosNocturnos * valorRecargoNocturno;

            // aqui estoy calculando el total devengado
            double totalDevengado = (diasTrabajados * 8 * valorHora) + totalHorasExtras + totalRecargosNocturnos;

            // aqui estoy calculando el subsidio de transporte
            double subsidioTransporte = recibeSubsidioTransporte ? 106454 : 0; // Valor del subsidio de transporte en 2024

            // Calculo de descuentos
            double descuentos = 0.04 * totalDevengado; // Ejemplo: descuento por seguridad social (4%)

            // Calculo del valor  total neto
            double totalNeto = totalDevengado + subsidioTransporte - descuentos;

            // aqui se realizan las impresiones de la liquidacion
            System.out.println("\n--- Liquidación de nómina ---");
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Documento: " + documento);
            System.out.println("Días trabajados: " + diasTrabajados);
            System.out.println("Horas extras: " + horasExtras);
            System.out.println("Recargos nocturnos: " + recargosNocturnos);
            System.out.println("Recibe subsidio de transporte: " + (recibeSubsidioTransporte ? "Sí" : "No"));
            System.out.println("Subsidio de transporte: " + subsidioTransporte);
            System.out.println("Total devengado: " + totalDevengado);
            System.out.println("Descuentos: " + descuentos);
            System.out.println("Total neto a pagar: " + totalNeto);
        }


        scanner.close();
    }
}
