Framework utilizado: Spring MVC
Motivo: maior familiaridade do grupo com o framework, além da preferência pessoal do grupo em geral ser pelo Spring. A impressão é que ele abstrai menos os conceitos de web do que os outros frameworks, e isso é visto como uma vantagem pelo grupo.

INSTRUÇÕES

1. Certifique-se dos parâmetros de conexão no banco. Se necessário, ajuste o persistence.xml do projeto. Configurações da aplicação:
URL: jdbc:mysql://localhost:3306/dbfiap
user: root
password: fiap

2. Crie o schema dbfiap no MySQL, e coloque-o como schema padrão.

3. Importe o self-contained file "db.sql", que veio junto com este arquivo.

4. Importe o projeto no eclipse.
	- Precisamos tirar as libs do projeto para que fosse possível fazer o upload no portal, por conta do tamanho. É possível baixar as libs desse link: https://drive.google.com/file/d/0BxWwmO4Tf32aa3dJalUtWWNEWGM/view?usp=sharing
	- O pacote acompanha uma imagem das libs usadas, para referência.
	- Alternativamente, baixar o projeto do GitHub: https://github.com/IgoJeferson/JavaWeb-AmigoSecreto

5. Ajuste o build path e o runtime environment, conforme necessidade.

6. Rode a aplicação no servidor (usamos o Tomcat 9.0 para desenvolvimento), o contexto é "/JavaWeb-AmigoSecreto/".

7. O login do usuário administrador é "admin", senha "admin".

8. Para se logar como participante, é necessário fazer o cadastro antes.

9. Para realizar o sorteio, logar como admin.
