public class ProduccionEscenarios {

    private int escenario_id;

    private int persona_id;

    public ProduccionEscenarios(int escenario_id, int persona_id) {
        this.escenario_id = escenario_id;
        this.persona_id = persona_id;
    }

    public int getEscenario_id() {
        return escenario_id;
    }

    public void setEscenario_id(int escenario_id) {
        this.escenario_id = escenario_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
}
