public class Mojarrita extends Animal{

    // ATRIBUTOS

        private TipoDeAgua tipoDeAgua;

        private final String tipoAnimal = "Mojarrita";

    // CONSTRUCTORES

        public Mojarrita(String nombre, Integer edad, Dueño dueño, Sexo sexo, Integer peso, TipoDeAgua tipoDeAgua) {
            super.setNombre(nombre);
            super.setEdad(edad);
            super.setDueño(dueño);
            super.setSexo(sexo);
            super.setPeso(peso);
            this.tipoDeAgua = tipoDeAgua;
        }

    // MÉTODOS

        @Override
        public String toString() {
            return "\nNombre: " + super.getNombreAnimal() +
                    "\nTipo de Animal: " + this.tipoAnimal +
                    "\nEdad: " + super.getEdadAnimal() + " años" +
                    "\nSexo: " + super.getSexoAnimal() +
                    "\nPeso (gr): " + super.getPesoAnimal() +
                    "\nTipo de Agua: " + this.getTipoDeAgua() +
                    "\nDueño: " + super.getDueñoAnimal().getNombreDueño() + " " + super.getDueñoAnimal().getApellidoDueño() +
                    " (" + super.getDueñoAnimal().getDniDueño() + ")" +
                    "\nDomicilio: " + super.getDueñoAnimal().getDireccionDueño() + " " + super.getDueñoAnimal().getNumeroDireccionDueño();
        }

    // GETTERS

        public TipoDeAgua getTipoDeAgua() {
            return tipoDeAgua;
        }

        public String getTipoAnimal() {
            return tipoAnimal;
        }

    // MÉTODOS ABSTRATCOS
        public String imprimirEliminar(){
            return tipoAnimal + ": " + super.getNombreAnimal() + " - " + getDueñoAnimal().getNombreDueño() + " " + getDueñoAnimal().getApellidoDueño();
        }
        @Override
        public String saludar() {
            return "Hola! Me llamo " + super.getNombreAnimal() + ", soy una " + tipoAnimal + " y mi tipo de agua es " + tipoDeAgua + ".";
        }


}
