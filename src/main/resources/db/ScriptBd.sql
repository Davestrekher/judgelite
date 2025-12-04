create table estudante(
   nome varchar(100),
   tipo_usuario varchar(1),
   senha varchar(320),
   email varchar(320) not null,
   usuario_name varchar(50),
   
   primary key (usuario_name),
   foreign key(usuario_name) references Usuario(usuario_name)
);

create table Usuario(
   nome varchar(100),
   tipo_usuario varchar(1),
   senha varchar(320),
   email varchar(320) not null,
   usuario_name varchar(50),
   primary key(usuario_name)
);

create table professor(
    nome varchar(100),
	tipo_usuario varchar(1),
	senha varchar(320),
	email varchar(320) not null,
	usuario_name varchar(50),
	primary key (usuario_name),
	foreign key(usuario_name) references Usuario(usuario_name)
);


create table usuarioProblema(
      usuario_name varchar(50),
	  id_problemas Integer,
	  primary key (usuario_name, id_problemas), 
	  foreign key(usuario_name) references Usuario(usuario_name),
	  foreign key(id_problemas) references problema(id_problemas)
);

create table casoteste(
          entrada Text,
	  saida text,
	  id_problemas Integer,
	  contador Integer,
	  primary key (contador, id_problemas),
	  foreign key(id_problemas) references problema(id_problemas)
);

create table problema(
        id_problemas Integer,
	data_problema date,
	dificuldade varchar(50),
	enuciado varchar(28000),
	nome varchar(1000),
	entrada varchar(14000),
	saida varchar(14000),
	id_usuarioprofessor varchar(50),
	primary key (id_problemas),
	foreign key(id_usuarioprofessor) references professor(usuario_name)
); 

create table submissao(
    codigo_fonte Varchar(10000),
    data_submissao date,
	linguagem Varchar(100),
	Status Varchar(100),
	id_submissao integer,
	usuario_name varchar(50),
	primary key(id_submissao),
	foreign key(usuario_name) references Usuario(usuario_name)
);