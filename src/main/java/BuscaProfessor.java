import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exception.HorarioDeAtendimentoInvalidoException;
import exception.PeriodoInvalidoException;
import exception.ProfessorIdNaoEncontradoException;

public class BuscaProfessor {

    ProfessorService professorService;

    public BuscaProfessor(ProfessorService professorService){
        this.professorService = professorService;
    }

    public Professor buscaProfessor(int id) throws ProfessorIdNaoEncontradoException,
            PeriodoInvalidoException,
            HorarioDeAtendimentoInvalidoException {
        String professorJson = professorService.busca(id);
        if(professorJson == null){
            throw new ProfessorIdNaoEncontradoException("id nao encontrado");
        }

        JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();
        var nome = jsonObject.get("nome").getAsString();
        var horarioDeAtendimento = jsonObject.get("horarioDeAtendimento").getAsString();
        var periodo = jsonObject.get("periodo").getAsString();

        if(!(periodo.equals("Integral") || periodo.equals("Noturno"))){
            throw new PeriodoInvalidoException("periodo inválido");
        }

        if(horarioDeAtendimento.equals("")){
            throw new HorarioDeAtendimentoInvalidoException("horário de atendimento inválido");
        }

        return new Professor(nome, horarioDeAtendimento, periodo);
    }
}
