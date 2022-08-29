public class MockProfessorService implements  ProfessorService{
    @Override
    public String busca(int id) {
        if(id == 1){
            return ProfessorConst.CHRISTOPHER;
        }
        if(id == 2){
            return ProfessorConst.MARCELO;
        }
        if(id == 3){
            return ProfessorConst.BRENO;
        }
        if(id == 4){
            return ProfessorConst.PROFESSOR_PERIODO_INVALIDO;
        }
        if(id == 5){
            return ProfessorConst.PROFESSOR_HORARIO_DE_ATENDIMENTO_INVALIDO;
        }
        return null;
    }
}
