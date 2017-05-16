INSTRU��ES

Framework utilizado: Spring MVC
Motivo: maior familiaridade do grupo com o framework, al�m da prefer�ncia pessoal do grupo em geral ser pelo Spring. A impress�o � que ele abstrai menos os conceitos de web do que os outros frameworks, e isso � visto como uma vantagem pelo grupo.

INSTRU��ES

1. Certifique-se dos par�metros de conex�o no banco. Se necess�rio, ajuste o persistence.xml do projeto. Configura��es da aplica��o:
URL: jdbc:mysql://localhost:3306/dbfiap
user: root
password: fiap

2. Crie o schema dbfiap no MySQL, e coloque-o como schema padr�o.

3. Importe o self-contained file "db.sql", que veio junto com este arquivo.

4. Importe o projeto no eclipse.

5. Ajuste o build path e o runtime environment, conforme necessidade.

6. Rode a aplica��o no servidor (usamos o Tomcat 9.0 para desenvolvimento), o contexto � "/JavaWeb-AmigoSecreto/".

7. O login do usu�rio administrador � "admin", senha "admin".

8. Para se logar como participante, � necess�rio fazer o cadastro antes.

9. Para realizar o sorteio, logar como admin.