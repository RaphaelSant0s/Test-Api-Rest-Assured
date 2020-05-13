Feature: Validar criação de Book na API

  Scenario: Devo executar especificação exemplo
    Given que tenho acesso a API
    When envio a requisição através do Método "Post"
    Then o registro do Book deve ser criado