# Atividade-Tecnica-Java
# Configuração do Projeto

## Introdução
Este documento fornece instruções para configurar e executar o projeto no ambiente Eclipse utilizando PostgreSQL como banco de dados e Tomcat como servidor.

## Pré-requisitos
Certifique-se de ter instalado os seguintes itens antes de prosseguir:
- Eclipse IDE
- PostgreSQL
- Apache Tomcat (versão 9.0 recomendada)
- Maven

## Configuração do Banco de Dados
1. Crie um novo banco de dados no PostgreSQL.
2. Altere as credenciais de login e senha do banco de dados conforme necessário no arquivo `persistence.xml`.

## Configuração do Projeto no Eclipse
1. Abra o Eclipse.
2. Importe o projeto para o workspace.
3. Na aba Servers, instale o Apache Tomcat (preferencialmente versão 9.0).
4. Sincronize o projeto com o Tomcat.
5. Execute o Maven Update Project no Eclipse (Alt + F5).
6. No Eclipse, execute o Maven Install.

## Executando o Projeto
1. Inicie o Tomcat no Eclipse.
2. Execute o projeto no Eclipse (Run As).

## Schema do Banco de Dados
O Schema `atividade_tecnica_java_db` será utilizado pelo projeto. Certifique-se de que o banco de dados tenha sido criado com este nome.


![image](https://github.com/marcojrdev/Atividade-Tecnica-Java/assets/60262274/ee262e27-e60d-49ce-bb00-b19c1d12f27c)
