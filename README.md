#  ConnectJob - Projeto FullStack produzido para a RECODE PRO 2023.
Projeto desenvolvido em Java utilizando Spring Boot e modelado em MVC

<div align="center">
<img src="https://github.com/Squad12Rcd/squad12/blob/c0fcc9da502be57301a3394fb189bfc3d4f7c33b/img/2-PhotoRoom.png">
</div>

<p> O ConnectJob visa conectar o estudante de baixa renda ao conhecimento em tecnologia e oportunidades de trabalho na área.
O projeto tem como proposta levar conhecimento em áreas de tecnologia para os estudantes de baixa renda interessados em tecnologia e fornecer para empresas cadastro de vagas de emprego. 
</p>
    
<h2> Status do Projeto</h2>

<li> Iniciando modelagem MVC e implementando do CRUD do banco de dados com MySQL e Java Spring Boot </strong> </li>

<h2> Implementações realizadas nesta versão </h2>
<ol>
<li> Adicionado o CRUD (Create, Read, Update, Delete) do banco de dados. É possível criar conta de "Usuário" e "Empresa", visualizar, atualizar e remover os registros do sistema </li>
<li> Foram implementados ajustes de performance visando o carregamento mais rápido da página de curso </li>
<li> Arquivos de estilo refatorados </li>
</ol>

<h2> Próximas atualizações </h2>

  <li> Adicionar Recursos de Acessibilidade: Dark mode, ferramenta para Libras, alterar fonte e tamanho de texto </li>  
  <li> Adicionar o registro de candidatura para vagas de empreso no campo do "Usuário" e Cadastro de Vagas para "Empresa". </li>
  <li> Implementar o sistema de login de usuário com recursos de segurança</li>
</ol>

<h2>Tecnologias utilizadas </h2>

<div style="display: inline_block" align="center"><br>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-plain.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-plain.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-plain.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="40" height="40"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/512px-Bootstrap_logo.svg.png" width="40" height="40" /> 
<img src="https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg" width="150" height="50" /> 
</div>

<h2> Banco de dados </h2>

<li> Para executar o Banco de dados: utilizar o comando <strong> CREATE DATABASE connectjob; </strong> </li>

<h3> Modelos do banco </h3>

<div align="center">
<strong> Modelo Conceitual</strong><br>
<img src="https://github.com/Squad12Rcd/squad12/blob/eeae6d77f022d5507924492b0515370f9d982444/img/modeloCondeitual.jpeg" /> <br>
<strong> Modelo Lógico </strong> <br>
<img src="https://github.com/Squad12Rcd/squad12/blob/05bf27b88dd885024286fc3ab6945285d0dc9ca7/img/modelologico.jpeg" /><br>

<p><strong> Modelo Físico </strong> <br></p>

<p> CREATE DATABASE connectjob; <br> </p>

<p>CREATE TABLE usuario ( <br>
  id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT, <br>
  cpf varchar(14) NOT NULL UNIQUE, <br>
  email varchar(80) NOT NULL UNIQUE, <br>
  nome varchar(80) NOT NULL, <br>
  senha varchar(250) NOT NULL <br>
);</p>

<p> CREATE TABLE empresa (  <br>
  id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,  <br>
  cnpj varchar(18) NOT NULL UNIQUE,  <br>
  email varchar(80) NOT NULL UNIQUE, <br>
  nome varchar(80) NOT NULL, <br>
  `senha` varchar(250) NOT NULL <br>
); </p>
    
</div>



<h2> Colaboradores </h2>
<ul>
  <li> @ThallesSampaio - Front-End, Back-End , Banco de dados </li>
  <li> @ThaynaSantana - Front-End </li>
  <li> @RenatoMarques - Front-End </li>
  <li> @RafaelSantos - Front-End, Back-End </li>
  <li> @Stephmarquess - Front-End, Back End </li>
  <li> @RafaelNasa - Front-End </li>
</ul>
<div align="center"> 

Renato Marques <br> <a href="https://www.linkedin.com/in/RenatoMarquesDavid" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> <br>
Stéfany Marques <br> <a href="https://www.linkedin.com/in/stéfany-marques-4390a0281" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> <br>
Rafael Santos <br> <a href="https://www.linkedin.com/in/rafael-dos-santos-433950267" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> <br>
Thalles Sampaio <br> <a href="https://www.linkedin.com/in/thallessampaio" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> <br>
Thayna Santana <br> <a href=" https://www.linkedin.com/in/thayss/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a><br>

</div>

<strong> E-mail do Squad: </strong> recodeprosquad12@gmail.com

<div align="center">
    <h2> Demonstração do Projeto </h2>
https://www.loom.com/share/6fb46b7b17b0444f89e1a9945696a1fc?sid=46744528-5914-41eb-bcba-84994a2ffe34
</div>
