public class Dueño {

    // ATRIBUTOS
        private long dniDueño;
        private String nombreDueño;
        private String direccionDueño;

        private int numeroDireccionDueño;

        private String apellidoDueño;

    // CONSTRUCTORES

        public Dueño(long dniDueño, String nombreDueño, String apellidoDueño, String direccionDueño, int numeroDireccionDueño) {
            this.numeroDireccionDueño = numeroDireccionDueño;
            this.apellidoDueño = apellidoDueño;
            this.dniDueño = dniDueño;
            this.nombreDueño = nombreDueño;
            this.direccionDueño = direccionDueño;
        }

        public Dueño() {
        }

    // MÉTODOS

    // GETTERS

        public long getDniDueño() {
            return dniDueño;
        }

        public String getNombreDueño() {
            return nombreDueño;
        }

        public String getDireccionDueño() {
            return direccionDueño;
        }

        public int getNumeroDireccionDueño() {
            return numeroDireccionDueño;
        }

        public String getApellidoDueño() {
            return apellidoDueño;
        }

        public boolean parametrosAsignados(Dueño dueñoVerificar){
            if (dueñoVerificar.getDireccionDueño() == ""){
                return false;
            }
            if (dueñoVerificar.getNombreDueño() == ""){
                return false;
            }
            if (dueñoVerificar.getDniDueño() == 0){
                return false;
            }
            if (dueñoVerificar.getNumeroDireccionDueño() == 0){
                return false;
            }
            if (dueñoVerificar.getApellidoDueño() == ""){
                return false;
            }
            return true;
        }
}
