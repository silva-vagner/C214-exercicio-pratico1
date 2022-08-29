import exception.HorarioDeAtendimentoInvalidoException;
import exception.PeriodoInvalidoException;
import exception.ProfessorIdNaoEncontradoException;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BuscaProfessorTest {

    @Test
    public void testeBuscaProfessorChrisSucesso() throws ProfessorIdNaoEncontradoException, PeriodoInvalidoException, HorarioDeAtendimentoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        Professor christopher = buscaProfessor.buscaProfessor(1);

        assertEquals("Christopher de Souza Lima Francisco", christopher.getNome());
        assertEquals("Terça das 17:30 as 19:30", christopher.getHorarioDeAtendimento());
        assertEquals("Integral", christopher.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorMarceloSucesso() throws ProfessorIdNaoEncontradoException, PeriodoInvalidoException, HorarioDeAtendimentoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        Professor marcelo = buscaProfessor.buscaProfessor(2);

        assertEquals("Marcelo Vinícius Cysneiros Aragão", marcelo.getNome());
        assertEquals("Terça das 17:30 as 19:30", marcelo.getHorarioDeAtendimento());
        assertEquals("Integral", marcelo.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorBrenoSucesso() throws ProfessorIdNaoEncontradoException, PeriodoInvalidoException, HorarioDeAtendimentoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        Professor breno = buscaProfessor.buscaProfessor(3);

        assertEquals("Breno Gontijo Tavares", breno.getNome());
        assertEquals("Quinta das 15:30 as 18:00", breno.getHorarioDeAtendimento());
        assertEquals("Noturno", breno.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorIdInvalido() throws PeriodoInvalidoException, HorarioDeAtendimentoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        try {
            buscaProfessor.buscaProfessor(30);
            Assert.fail("excecao esperada nao foi lançada");
        }catch (ProfessorIdNaoEncontradoException e){
            assertThat(e.getMessage(), is("id nao encontrado"));
        }
    }

    @Test
    public void testeBuscaProfessorPeriodoInvalido() throws ProfessorIdNaoEncontradoException, HorarioDeAtendimentoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        try {
            buscaProfessor.buscaProfessor(4);
            Assert.fail("excecao esperada nao foi lançada");
        }catch (PeriodoInvalidoException e){
            assertThat(e.getMessage(), is("periodo inválido"));
        }
    }

    @Test
    public void testeBuscaProfessorHorarioDeAtendimentoInvalido() throws ProfessorIdNaoEncontradoException, PeriodoInvalidoException {
        ProfessorService service = new MockProfessorService();
        BuscaProfessor buscaProfessor = new BuscaProfessor(service);

        try {
            buscaProfessor.buscaProfessor(5);
            Assert.fail("excecao esperada nao foi lançada");
        }catch (HorarioDeAtendimentoInvalidoException e){
            assertThat(e.getMessage(), is("horário de atendimento inválido"));
        }
    }
}
