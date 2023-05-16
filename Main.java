import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;


public class Main {

    // Declaramos la variable listaAnimales y la declaramos static, para que al modificarla dentro
    // de las funciones, también se modifique la lista principal.
    static ArrayList<Animal> listaAnimales = Animal.inicializarAnimales();

    public static void main(String[] args) {

    // Declaración de otras variables

        boolean flag = false;
        int opcion = 0;
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

    // Código

        do {
            do {
                flag = false;
                try{
                    opcion = 0;
                    menuGuarderia();
                    System.out.printf("Opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();             // Limpiamos el scanner
                    flag = true;
                    Thread.sleep(1000);
                } catch (Exception e){
                    scanner.nextLine();             // Limpiamos el scanner
                    System.out.println("¡Opción no válida! No puede ingresar una letra.");
                }
            } while (flag == false);
            switch (opcion){
                case 1: crearAnimales();break;                                      // CREAR ANIMALES
                case 2: retirarAnimal(listaAnimales);break;                         // RETIRAR ANIMAL DE LA GUARDERÍA
                case 3: consultarAnimales(listaAnimales);break;                     // CONSULTAR ANIMALES DE LA GUARDERÍA (cantidad)
                case 4: listarAnimales(listaAnimales);break;                        // LISTAR ANIMALES DE LA GUARDERÍA
                case 5: saludarAnimales(listaAnimales);break;                       // HACER QUE LOS ANIMALES SALUDEN
                case 0: salir = true;break;                                         // SALIR
                default:
                    System.out.println("Ingresó una opción no válida. Su opción debe estar entre 0 y 5.");
            }
        } while (salir == false);
    }

    // Funciones

    // Menú's

        public static void menuGuarderia(){
            try {
            Thread.sleep(1000);
            System.out.println("\n\t\t\tGUARDERÍA ANIMAL\n");
            Thread.sleep(1000);
            System.out.println("\tMenú de Gestión");
            Thread.sleep(1000);
            System.out.println("\tEscoja su opción:\n");
            Thread.sleep(1000);
            System.out.println("\t1 - Ingresar animal a la guardería. ");
            Thread.sleep(1000);
            System.out.println("\t2 - Retirar animal de la guardería.");
            Thread.sleep(1000);
            System.out.println("\t3 - Consultar cantidad de animales en la guardería.");
            Thread.sleep(1000);
            System.out.println("\t4 - Listar animales de la guardería.");
            Thread.sleep(1000);
            System.out.println("\t5 - Hacer que los animales saluden.");
            Thread.sleep(1000);
            System.out.println("\t0 - Salir\n");
            Thread.sleep(1000);
            } catch (Exception e){}
        }

        public static void menuGuarderiaDueño(String estadoNombreDueño, String estadoApellidoDueño, String estadoDniDueño, String estadoDireccionDueño){
            try {
                Thread.sleep(1000);
                System.out.println("\n\t\t\tGUARDERÍA ANIMAL\n");
                Thread.sleep(1000);
                System.out.println("\tMenú de Dueño");
                Thread.sleep(1000);
                System.out.println("\tEscoja su opción:\n");
                Thread.sleep(1000);
                System.out.println("\t1 - Ingresar nombre del dueño. " + estadoNombreDueño);
                Thread.sleep(1000);
                System.out.println("\t2 - Ingresar apellido del dueño. " + estadoApellidoDueño);
                Thread.sleep(1000);
                System.out.println("\t3 - Ingresar DNI del dueño. " + estadoDniDueño);
                Thread.sleep(1000);
                System.out.println("\t4 - Ingresar dirección del dueño. " + estadoDireccionDueño);
                Thread.sleep(1000);
                System.out.println("\t0 - Salir\n");
                Thread.sleep(1000);
            } catch (Exception e){}
        }

        public static void menuEliminacion(){
            try {
                Thread.sleep(1000);
                System.out.println("\n\t\t\tGUARDERÍA ANIMAL\n");
                Thread.sleep(1000);
                System.out.println("\tMenú de Eliminación");
                Thread.sleep(1000);
                System.out.println("\n\tLos resultados figurarán de la siguiente forma: ");
                Thread.sleep(1000);
                System.out.println("\tTipo de Animal: Nombre del Animal - Dueño");
                Thread.sleep(1000);
                System.out.println("\n\tEscoja el número correspondiente [0 para salir]:\n");
                Thread.sleep(1000);
            } catch (Exception e){}
        }

        public static void menuAgregación(){
            try {
                Thread.sleep(1000);
                System.out.println("\n\t\t\tGUARDERÍA ANIMAL\n");
                Thread.sleep(1000);
                System.out.println("\tMenú de Agregación");
                Thread.sleep(1000);
                System.out.println("\n\tAntes de crear un nuevo animal, debe de asignarle un dueño.");
                Thread.sleep(1000);
                System.out.println("\tUsted puede escoger entre, asignarle uno de los dueños ya cargados,");
                Thread.sleep(1000);
                System.out.println("\to crear uno nuevo. ¿Qué desea hacer?");
                Thread.sleep(1000);
                System.out.println("\n\t[1] Crear un nuevo dueño.");
                Thread.sleep(1000);
                System.out.println("\t[2] Utilizar un dueño ya existente.");
                Thread.sleep(1000);
                System.out.println("\t[0] Salir.");
                Thread.sleep(1000);
                System.out.printf("\n\tOpción: ");
            } catch (Exception e){}
        }


    // Crear Animales (Opción 1)
        public static void crearAnimales() {
            Scanner scanner = new Scanner(System.in);
            try {
                String tipoAnimal;
                Dueño dueñoAnimal = new Dueño();
                menuAgregación();
                int opcion = scanner.nextInt();
                scanner.nextLine();                 // Limpiamos el scanner
                if (opcion == 1){
                    dueñoAnimal = crearDueño();
                    if (dueñoAnimal.parametrosAsignados(dueñoAnimal)){
                        System.out.println("\n¡Dueño creado con éxito!");
                    } else {
                        System.out.println("\n¡ERROR! No se han asignado todos los parámetros de dueño, por lo que no puede continuar.");
                        System.out.println("Regresará al menú principal y deberá comenzar nuevamente.");
                        return;}
                } else if (opcion == 2){
                    dueñoAnimal = elegirDueño();
                    System.out.println("\n¡Dueño elegido con éxito!");
                } else if (opcion == 0){
                    return;
                }
                int cantAnimales;
                int i = 0;
                char sex;
                Sexo sexoAnimal = Sexo.MACHO;
                System.out.printf("\n¿Cuántos animales desea crear? ");
                cantAnimales = scanner.nextInt();
                do {
                    System.out.println("\n\t---- CREADOR DE ANIMALES ----");
                    do {
                        System.out.println("\n.- ELEGIR TIPO DE ANIMAL");
                        System.out.println("Recuerde escribir la palabra correspondiente al animal que desea.");
                        System.out.printf("\n- Tipo del Animal [Perro, Gato, Mojarrita, Hámster]: ");
                        tipoAnimal = scanner.next();
                        tipoAnimal = tipoAnimal.toLowerCase();
                    } while (!tipoAnimal.equals("perro") && !tipoAnimal.equals("gato") && !tipoAnimal.equals("mojarrita") && !tipoAnimal.equals("hamster"));
                    System.out.println("\n.- ELEGIR NOMBRE");
                    System.out.printf("\n- Nombre del Animal: ");
                    String nombreAnimal = scanner.next();
                    System.out.println("\n.- ELEGIR EDAD");
                    System.out.printf("\n- Edad del Animal (años): ");
                    Integer edadAnimal = scanner.nextInt();
                    System.out.println("\n.- ELEGIR PESO");
                    System.out.printf("\n- Peso del animal (g): ");
                    Integer pesoAnimal = scanner.nextInt();
                    do {
                        System.out.println("\n.- ELEGIR SEXO");
                        System.out.printf("\nSexo del Animal (M/H): ");
                        sex = scanner.next().charAt(0);
                        if (sex == 'M' || sex == 'm') {
                            sexoAnimal = Sexo.MACHO;
                        } else if (sex == 'H' || sex == 'h') {
                            sexoAnimal = Sexo.HEMBRA;
                        } else {
                            System.out.println("¡OPCION INCORRECTA!");
                        }
                    } while (sex != 'M' && sex != 'm' && sex != 'h' && sex != 'H');
                    if (tipoAnimal.equals("perro")) {
                        System.out.println("\n.- ELEGIR RAZA");
                        System.out.printf("\nRaza del Perro: ");
                        String razaPerro = scanner.next();
                        Animal animal = new Perro(nombreAnimal, edadAnimal, dueñoAnimal, sexoAnimal, pesoAnimal, razaPerro);
                        listaAnimales.add(animal);
                    }
                    if (tipoAnimal.equals("mojarrita")) {
                        char opcionMoj = 'r';      // Solo la inicializamos para que pueda ingresar al while.
                        try {
                            while (opcionMoj != 'f' && opcionMoj != 'F' && opcionMoj != 'T' && opcionMoj != 't') {
                                System.out.println("\n.- ELEGIR TIPO DE AGUA");
                                System.out.printf("\nTipo de Agua [F = Fría] [T = Tropical]: ");
                                opcionMoj = scanner.next().charAt(0);
                            }
                        } catch (Exception e) {
                            System.out.println("\n¡No puede ingresar un número!. Sus opciones deben ser ['F' o 'T'].");
                        }
                        TipoDeAgua tipoDeAgua = TipoDeAgua.FRÍA;
                        if (opcionMoj == 'F' || opcionMoj == 'f') {
                            tipoDeAgua = TipoDeAgua.FRÍA;
                        } else if (opcionMoj == 'T' || opcionMoj == 't') {
                            tipoDeAgua = TipoDeAgua.TROPICAL;
                        }
                        Animal animal = new Mojarrita(nombreAnimal, edadAnimal, dueñoAnimal, sexoAnimal, pesoAnimal, tipoDeAgua);
                        listaAnimales.add(animal);
                    }
                    if (tipoAnimal.equals("gato")) {
                        Animal animal = new Gato(nombreAnimal, edadAnimal, dueñoAnimal, sexoAnimal, pesoAnimal);
                        listaAnimales.add(animal);
                    }
                    if (tipoAnimal.equals("hamster")) {
                        Animal animal = new Hamster(nombreAnimal, edadAnimal, dueñoAnimal, sexoAnimal, pesoAnimal);
                        listaAnimales.add(animal);
                    }
                    System.out.println("¡GENIAL! Animal creado con éxito.");
                    i++;
                    } while (i < cantAnimales);
            } catch (Exception e) {
                scanner.nextLine();                 // Limpiamos el scanner
                System.out.println("\n¡Opción no válida! No puede ingresar una letra.");
        }
    }

    // Eliminar Animales (Opción 2)
        public static void retirarAnimal(ArrayList<Animal> listaAnimales){
        int opcion = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int i = 1;
                menuEliminacion();
                for (Animal animal : listaAnimales) {
                    System.out.printf("\n[" + i + "] " + animal.imprimirEliminar());
                    i++;
                }
                System.out.printf("\n\nOpción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();                 // Limpiamos el scanner
                if (opcion == 0) {
                    break;
                }
                listaAnimales.remove(opcion - 1);
            } catch (Exception e){
                scanner.nextLine();                 // Limpiamos el scanner
                System.out.println("Debe de ingresar el número correspondiente al animal.");
            }
        } while (opcion != 0);

    };

    // Consultar Animales (Opción 3)
        public static void consultarAnimales(ArrayList<Animal> listaAnimales){
        if (listaAnimales.isEmpty()){
            System.out.println("\nLo lamentamos! Actualmente no tenemos animales en la guardería :(");
        }
        else {
            System.out.println("\nActualmente tenemos " + listaAnimales.size() + " animales en la guardería.");
        }    };

    // Listar Animales (Opción 4)
        public static void listarAnimales(ArrayList<Animal> listaAnimales){
        if (listaAnimales.isEmpty()){
            System.out.println("\nLo lamentamos! Actualmente no tenemos animales en la guardería :(");
        }
        else {
            System.out.println();
            for (Animal animal : listaAnimales) {
                System.out.println(animal.toString());
            }
        }
    };

    // Hacer que los Animales saluden (Opción 5)
        public static void saludarAnimales(ArrayList<Animal> listaAnimales){
        if (listaAnimales.isEmpty()){
            System.out.println("\nLo lamentamos! Actualmente no tenemos animales en la guardería :(");
        }
        else {
            System.out.println();
            for (Animal animal:listaAnimales) {
                System.out.println(animal.saludar());
            }
        }
    };

    // Crear Dueño (Opción dentro de Crear Animales)
        public static Dueño crearDueño(){
            String estadoNombreDueño = "(Sin agregar)", estadoApellidoDueño = "(Sin agregar)",  estadoDniDueño = "(Sin agregar)", estadoDireccionDueño = "(Sin agregar)";
            String nombreDueño = "", apellidoDueño = "", direccionDueño = "";
            long dniDueño = 0;
            int numeroDueño = 0;
            char opcion = 't';
            int opcionMenuDueño = 1;
            Dueño dueño;
            Scanner scanner = new Scanner(System.in);
            do {
            try {
                menuGuarderiaDueño(estadoNombreDueño, estadoApellidoDueño, estadoDniDueño, estadoDireccionDueño);
                System.out.printf("Opción: ");
                opcionMenuDueño = scanner.nextInt();
                switch (opcionMenuDueño){
                    case 1:
                        System.out.printf("Nombre del dueño: ");
                        nombreDueño = scanner.next();
                        estadoNombreDueño = "(Agregado)";
                        break;
                    case 2:
                        System.out.printf("Apellido del dueño: ");
                        apellidoDueño = scanner.next();
                        estadoApellidoDueño = "(Agregado)";
                        break;
                    case 3:
                        System.out.printf("DNI del dueño: ");
                        dniDueño = scanner.nextLong();
                        estadoDniDueño = "(Agregado)";
                        break;
                    case 4:
                        System.out.println("Dirección del dueño: ");
                        System.out.printf("Calle: ");
                        direccionDueño = scanner.next();
                        System.out.printf("Número de Calle: ");
                        numeroDueño = scanner.nextInt();
                        estadoDireccionDueño = "(Agregado)";
                        break;
                    case 0:
                        if (nombreDueño == "" || dniDueño == 0 || direccionDueño == "" || apellidoDueño == "") {
                            do {
                                System.out.printf("Aún no ha asignado todos los parámetros, ¿Está seguro que desea salir? [S/N]: ");
                                opcion = scanner.next().charAt(0);
                                if (opcion == 's' || opcion == 'S') {
                                    return dueño = new Dueño(dniDueño, nombreDueño,apellidoDueño, direccionDueño, numeroDueño);
                                }
                                else if (opcion == 'n' || opcion == 'N') {
                                    break;
                                } else {
                                    System.out.println("Opcion no valida! Debe ingresar 'S' o 'N'.");
                                }
                            } while (opcion != 's' && opcion != 'S' && opcion != 'n' && opcion != 'N');
                        }

                    default:
                        System.out.println("Ingresó una opción no válida. Su opción debe estar entre 0 y 4.");}
                        break;
            }  catch (Exception e){
                scanner.nextLine();                 // Limpiamos el scanner
                System.out.println("¡Carácter no válido!");
            }
        } while (nombreDueño == "" || dniDueño == 0 || direccionDueño == "" || apellidoDueño == "");
        dueño = new Dueño(dniDueño, nombreDueño,apellidoDueño, direccionDueño, numeroDueño);
        return dueño;
    }

    // Elegir Dueño (Opción dentro de Crear Animales)
        public static Dueño elegirDueño(){
            Scanner scanner = new Scanner(System.in);
            int dueño = 0;
            do {
                try {
                    List<Dueño> listDueños = new ArrayList<>();
                    int i = 0;
                    Thread.sleep(500);
                    System.out.println("\nA continuación, se mostrarán los dueños disponibles.");
                    for (Animal animal : listaAnimales) {
                        if (listDueños.contains(animal.getDueñoAnimal())) {
                        } else {
                            listDueños.add(animal.getDueñoAnimal());
                        }
                        Thread.sleep(500);
                    }
                    for (Dueño dueños : listDueños){
                            System.out.println("\n[" + i + "] Dueño: " + dueños.getNombreDueño() + ", " +
                                    dueños.getApellidoDueño() + " - " + dueños.getDniDueño());
                            System.out.println("Domicilio: " + dueños.getDireccionDueño() + " " +
                                    dueños.getNumeroDireccionDueño());
                            i++;
                    }
                    System.out.printf("\nOpcion: ");
                    int opcion = scanner.nextInt();
                    if (opcion >= 0 && opcion < listDueños.size()) {
                        dueño = 1;
                        return (listaAnimales.get(opcion).getDueñoAnimal());
                    }
                    else {
                        System.out.println("\n¡ERROR! Debe de ingresar un número entre 0 y " + (listDueños.size()-1));
                    }
                } catch (Exception e) {
                    scanner.nextLine();                 // Limpiamos el scanner
                    System.out.println("\n¡ERROR! Debe ingresar el número correspondiente al dueño que desea.");
                }
            } while (dueño == 0);
            return null;
        }
}
