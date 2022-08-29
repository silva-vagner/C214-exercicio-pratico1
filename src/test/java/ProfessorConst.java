public class ProfessorConst {
    public static String CHRISTOPHER =
            """
                    { "nome": "Christopher de Souza Lima Francisco",\s
                     "horarioDeAtendimento": "Terça das 17:30 as 19:30",\s
                     "periodo": "Integral" }
            """;

    public static String MARCELO =
            """
                    { "nome": "Marcelo Vinícius Cysneiros Aragão",\s
                     "horarioDeAtendimento": "Terça das 17:30 as 19:30",\s
                     "periodo": "Integral" }
            """;

    public static String BRENO =
            """
                    { "nome": "Breno Gontijo Tavares",\s
                     "horarioDeAtendimento": "Quinta das 15:30 as 18:00",\s
                     "periodo": "Noturno" }
            """;

    public static String PROFESSOR_PERIODO_INVALIDO =
            """
                    { "nome": "Nome Valido",\s
                     "horarioDeAtendimento": "Horario Valido",\s
                     "periodo": "" }
            """;

    public static String PROFESSOR_HORARIO_DE_ATENDIMENTO_INVALIDO =
            """
                    { "nome": "Nome Valido",\s
                     "horarioDeAtendimento": "",\s
                     "periodo": "Integral" }
            """;
}
