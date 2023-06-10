import Cancion.Cancion;
import Escenario.Escenario;
import Personas.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String[] args) {

        // personas
        Persona persona1 = new Persona("Matias", "Rodirguez", LocalDate.now(), 4092);
        Persona persona2 = new Persona("Pepe", "Mateo", LocalDate.now(), 40934);
        Persona persona3 = new Persona("Valen", "Babrei", LocalDate.now(), 4382);
        Persona persona4 = new Persona("Eduardo", "Colon", LocalDate.now(), 1123);

        // hashsets y hashmaps

        HashSet<Artista> artistas = new HashSet<>(); // coleccion de artistas
        HashSet<Asistente> asistentes = new HashSet<>(); // coleccion de asistentes
        HashSet<Personal_produccion> personalPoduccion = new HashSet<>(); // coleccion del personal de produccion
        HashSet<Cancion> cancionesInterpreta = new HashSet<>(); // coleccion de las canciones que dan los artistas
        HashMap<Integer, Artista> artistasPresentan = new HashMap<>(); // mapa de hora y que arista presenta


        // artistas

        Artista artista1 = new Artista("Emilia", "Mernes", LocalDate.now(), 42213, "Reggaeton", cancionesInterpreta, true);
        Artista artista2 = new Artista("Paulo", "Londra", LocalDate.now(), 4212, "Trap", cancionesInterpreta, true);


        artistas.add(artista1);
        artistas.add(artista2);

        // asistentes

        Asistente asistente1 = new Asistente("Matias", "Rodirguez", LocalDate.now(), 4378, false, "Limpiador");
        Asistente asistente2 = new Asistente("Matias", "Colque", LocalDate.now(), 4123, false, "Seguridad");

        asistentes.add(asistente1);
        asistentes.add(asistente2);

        // personal de produccion

        Personal_produccion pp1 = new Personal_produccion("Matias", "Rodirguez", LocalDate.now(), 40901, Rol_produccion.SONIDO);
        Personal_produccion pp2 = new Personal_produccion("Matias", "Rodirguez", LocalDate.now(), 40901, Rol_produccion.TECNICO);

        personalPoduccion.add(pp1);
        personalPoduccion.add(pp2);

        // escenarios

        Escenario escenario1 = new Escenario("River Plate",82000,artistasPresentan,personalPoduccion);

        artistasPresentan.put(1100, artista1);
        artistasPresentan.put(1101, artista2);

        // SISTEMA

        Polipalooza polipalooza1 = new Polipalooza(artistas,asistentes,escenario1);


        // METODOS
        escenario1.mostrarArtistas();


    }}
