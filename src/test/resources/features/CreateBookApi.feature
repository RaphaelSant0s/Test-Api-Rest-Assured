Feature: Validar criação de Book na API

  @tag1
  Scenario Outline: Devo executar especificação exemplo
    When realizo a criação do livro <book>
    Then o status code deve ser <statusCode>
    Examples:
      | book               | statusCode |
      | "book_teste"       | "200"      |
      | "book_teste_falha" | "200"      |