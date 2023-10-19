import java.util.*;
import eleicoes.*;
import processaEntrada.LeCandidatos;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        List<CandidatoFederal> candidatosFederais = new ArrayList<>();
        List<CandidatoEstadual> candidatosEstaduais = new ArrayList<>();
        HashMap<Integer, Partido> partidos = new HashMap<>();
        HashMap<Integer, Federacao> federacoes = new HashMap<>();

        LeCandidatos.leitura(candidatosFederais, candidatosEstaduais, partidos, federacoes);
    }
}