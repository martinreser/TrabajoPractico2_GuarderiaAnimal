public class Hamster extends Animal{

    // ATRIBUTOS

        private final String tipoAnimal = "Hámster";

    // CONSTRUCTORES

        public Hamster(String nombre, Integer edad, Dueño dueño, Sexo sexo, Integer peso) {
            super.setNombre(nombre);
            super.setEdad(edad);
            super.setDueño(dueño);
            super.setSexo(sexo);
            super.setPeso(peso);
        }

    // MÉTODOS

        @Override
        public String toString() {
            return "\nNombre: " + super.getNombreAnimal() +
                    "\nTipo de Animal: " + this.tipoAnimal +
                    "\nEdad: " + super.getEdadAnimal() + " años" +
                    "\nSexo: " + super.getSexoAnimal() +
                    "\nPeso (gr): " + super.getPesoAnimal() +
                    "\nDueño: " + super.getDueñoAnimal().getNombreDueño() + " " + super.getDueñoAnimal().getApellidoDueño() +
                    " (" + super.getDueñoAnimal().getDniDueño() + ")" +
                    "\nDomicilio: " + super.getDueñoAnimal().getDireccionDueño() + " " + super.getDueñoAnimal().getNumeroDireccionDueño();
        }

    // GETTERS
        public String getTipoAnimal() {
            return tipoAnimal;
        }

    // MÉTODOS ABSTRACTOS

        public String imprimirEliminar(){
            return tipoAnimal + ": " + super.getNombreAnimal() + " - " + getDueñoAnimal().getNombreDueño() + " " + getDueñoAnimal().getApellidoDueño();
        }
        @Override
        public String saludar() {
            return "Hola! Me llamo " + super.getNombreAnimal() + " y soy un " + tipoAnimal + ".";
        }
}
