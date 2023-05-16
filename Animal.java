import java.util.ArrayList;

public abstract class Animal {

    // ATRIBUTOS

        private String nombreAnimal;
        private Integer edadAnimal;
        private Dueño dueñoAnimal;
        private Sexo sexoAnimal;
        private Integer pesoAnimal;

    // MÉTODOS

        public static ArrayList<Animal> inicializarAnimales() {
            ArrayList<Animal> listaAnimales = new ArrayList<>();

            Dueño jimena = new Dueño(45740868, "Jimena", "Denk", "Alvear", 1768);
            Animal simon = new Perro("Simón", 10, jimena, Sexo.MACHO, 8000, "Caniche Toy");
            Animal chicho = new Perro("Chicho", 2, jimena, Sexo.MACHO, 15000, "Labrador");
            Animal muna = new Gato("Muna", 4, jimena, Sexo.HEMBRA, 6000);
            Dueño martin = new Dueño(45319502, "Martin", "Reser", "Zelarrayan", 417);
            Animal topi = new Hamster("Topi", 1, martin, Sexo.MACHO, 2650);
            Animal nemo = new Mojarrita("Nemo", 5, martin, Sexo.MACHO, 250, TipoDeAgua.FRÍA);
            Animal lopo = new Perro("Lopo", 1, martin, Sexo.MACHO, 13000, "Golden Retriever");
            Dueño tomas = new Dueño(45319674, "Tomas", "Tusek", "Congreso de Tucumán", 764);
            Animal braco = new Perro("Braco", 3, tomas, Sexo.MACHO, 30000, "Pitbull");

            listaAnimales.add(simon);
            listaAnimales.add(chicho);
            listaAnimales.add(muna);
            listaAnimales.add(topi);
            listaAnimales.add(nemo);
            listaAnimales.add(lopo);
            listaAnimales.add(braco);

            return listaAnimales;
        }

    // GETTERS

        public String getNombreAnimal() {
            return nombreAnimal;
        }

        public Dueño getDueñoAnimal() {
            return dueñoAnimal;
        }

        public Integer getEdadAnimal() {
            return edadAnimal;
        }

        public Sexo getSexoAnimal() {
            return sexoAnimal;
        }

        public Integer getPesoAnimal() {
            return pesoAnimal;
        }

    // SETTERS
        public void setNombre(String nombre) {
            this.nombreAnimal = nombre;
        }

        public void setEdad(Integer edad) {
            this.edadAnimal = edad;
        }

        public void setDueño(Dueño dueño) {
            this.dueñoAnimal = dueño;
        }

        public void setSexo(Sexo sexo) {
            this.sexoAnimal = sexo;
        }

        public void setPeso(Integer peso) {
            this.pesoAnimal = peso;
        }

    // MÉTODOS ABSTRACTOS

        public abstract String saludar();

        public abstract String  imprimirEliminar();
}
