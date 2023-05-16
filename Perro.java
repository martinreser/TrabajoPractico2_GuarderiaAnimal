import java.util.Scanner;

public class Perro extends Animal {

    // ATRIBUTOS
        private String raza;

        private final String tipoAnimal = "Perro";


    // CONSTRUCTORES

        public Perro(String nombre, Integer edad, Dueño dueño, Sexo sexo, Integer peso, String raza) {
            super.setNombre(nombre);
            super.setEdad(edad);
            super.setDueño(dueño);
            super.setSexo(sexo);
            super.setPeso(peso);
            this.raza = raza;
        }

    // MÉTODOS

        @Override
        public String toString() {
            return "\nNombre: " + super.getNombreAnimal() +
                    "\nTipo de Animal: " + this.tipoAnimal +
                    "\nEdad: " + super.getEdadAnimal() + " años" +
                    "\nSexo: " + super.getSexoAnimal() +
                    "\nPeso (gr): " + super.getPesoAnimal() +
                    "\nRaza: " + this.getRaza() +
                    "\nDueño: " + super.getDueñoAnimal().getNombreDueño() + " " + super.getDueñoAnimal().getApellidoDueño() +
                    " (" + super.getDueñoAnimal().getDniDueño() + ")" +
                    "\nDomicilio: " + super.getDueñoAnimal().getDireccionDueño() + " " + super.getDueñoAnimal().getNumeroDireccionDueño();
        }

    // GETTERS
        public String getRaza() {
            return raza;
        }

        public String getTipoAnimal() {
            return tipoAnimal;
        }

    // MÉTODOS ABSTRACTOS

        public String imprimirEliminar(){
            return tipoAnimal + ": " + super.getNombreAnimal() + " - " + getDueñoAnimal().getNombreDueño() + " " + getDueñoAnimal().getApellidoDueño();
        }

        @Override
        public String saludar() {
            return "Hola! Me llamo " + super.getNombreAnimal() + ", soy un " + tipoAnimal + " y mi raza es " + raza + ".";
        }
}
