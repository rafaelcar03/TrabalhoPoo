package processaEntrada;
import eleicoes.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

public class LeVotacao{

    public static void leitura(HashMap<Integer, Candidato> candidatos, HashMap<Integer, Partido> partidos, HashMap<Integer, Federacao> federacoes, int tipoCandidato, String arquivo){
        try(FileInputStream fin = new FileInputStream(arquivo);
            Scanner s = new Scanner(fin, "ISO-8859-1")){
            s.nextLine();
            
            while(s.hasNextLine()){
                String line = s.nextLine();
                
                try(Scanner lineScanner = new Scanner(line)){
                    lineScanner.useDelimiter("\";\"");

                    setScanner(lineScanner, 17);
                    String cargo = lineScanner.next();

                    if(Integer.parseInt(cargo) == tipoCandidato){
                        lineScanner.next();
                        String destinoVotos = lineScanner.next();
                        int candidatoVotado = Integer.parseInt(destinoVotos);

                        if(candidatoVotado < 95 || candidatoVotado > 98){
                            lineScanner.next();
                            String qtdVotos = lineScanner.next();

                            if(candidatos.containsKey(candidatoVotado)){
                                Candidato c = candidatos.get(candidatoVotado);
                                c.setQuantidadeVotos(Integer.parseInt(qtdVotos));
                            }
                            else if(partidos.containsKey(candidatoVotado)){
                                Partido p = partidos.get(candidatoVotado);
                                p.setLegendaPartido(Integer.parseInt(qtdVotos));
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("arquivo nao encontrado");
            e.printStackTrace();
        }
    }
    
    public static void setScanner(Scanner lineScanner, int q){
        while(q != 0){
            lineScanner.next();
            q--;
        }
    }
}
