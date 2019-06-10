drop database if exists viagens;
create database if not exists viagens;
use viagens;

create table conta(
	email varchar(50) not null primary key,
    senha varchar(15) not null
)engine = innodb;

create table usuario(
	id int not null auto_increment primary key,
    nome varchar(55) not null,
    conta_email varchar(50) not null unique,
    
    constraint fk_conta_email foreign key(conta_email) references conta(email)
    on update cascade
    on delete cascade
)engine = innodb;

create table roteiro(
	id int not null auto_increment primary key,
    destino varchar(50) not null,
    data_ida date not null,
    data_volta date not null,
    preco_total double not null,

    usuario_conta_email varchar(50) not null,
    
    constraint fk_usuario_conta_email foreign key(usuario_conta_email) references usuario(conta_email)
    on update cascade
    on delete cascade
)engine = innodb;

create table tipo_transporte(
	id int not null auto_increment primary key,
    nome varchar(30) not null
)engine = innodb;

create table transporte(
	id int not null auto_increment primary key,
    horario_ida time not null,
    horario_volta time not null,
    preco double not null,
    
    tipo_transporte_id int not null,
    roteiro_id int not null unique,
    
    constraint fk_tipo_transporte_id foreign key(tipo_transporte_id) references tipo_transporte(id)
    on update cascade
    on delete cascade,
    
    constraint fk_roteiro_id_transporte foreign key(roteiro_id) references roteiro(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table hospedagem(
	id int not null auto_increment primary key,
	nome varchar(50) not null,
    endereco varchar(50) not null,
    checkIn time not null,
    checkOut time not null,
    preco double not null,
    
    roteiro_id int not null unique,
    
    constraint fk_roteiro_id_hospedagem foreign key(roteiro_id) references roteiro(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table restaurante(
	id int not null auto_increment primary key,
    nome varchar(50) not null,
    endereco varchar(50) not null
)engine = innodb;

create table ponto_turistico(
	id int not null auto_increment primary key,
    nome varchar(50) not null,
    endereco varchar(50) not null,
    preco double not null
)engine = innodb;

create table roteiro_has_restaurante(
	roteiro_id int not null,
    restaurante_id int,
    
    constraint fk_roteiro_id foreign key(roteiro_id) references roteiro(id)
    on update cascade
    on delete cascade,
    
    constraint fk_restaurante_id_ foreign key(restaurante_id) references restaurante(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table roteiro_has_ponto_turistico(
	roteiro_id int not null,
    ponto_turistico_id int,
    
    constraint fk_roteiro_id_ foreign key(roteiro_id) references roteiro(id)
    on update cascade
    on delete cascade,
    
    constraint fk_ponto_turistico_id_ foreign key(ponto_turistico_id) references ponto_turistico(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table continente(
	id int not null auto_increment primary key,
    nome varchar(30) not null
)engine = innodb;

create table viagens(
	id int not null auto_increment primary key,
	destino varchar(50) not null,
    alta_temporada varchar(1000) not null,
    clima varchar(1000) not null,
    
    continente_id int not null,
    
    constraint fk_continente_id foreign key(continente_id) references continente(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table ponto_turistico_viagem(
	id int not null auto_increment primary key,
    nome varchar(50) not null,
    endereco varchar(50) not null,
    preco varchar(30) not null,
    latitude double not null,
    longitude double not null
)engine = innodb;

create table viagem_has_ponto_turistico(
	viagem_id int not null,
    ponto_turistico_viagem_id int,
    
    constraint fk_viagem_id_pt foreign key(viagem_id) references viagens(id)
    on update cascade
    on delete cascade,
    
    constraint fk_ponto_turistico_id foreign key(ponto_turistico_viagem_id) references ponto_turistico_viagem(id)
    on update cascade
    on delete cascade
)engine = innodb;

create table imagens(
	id int not null auto_increment primary key,
    caminho varchar(100) not null,
	
    viagens_id int not null unique,
    
    constraint fk_viagens_id foreign key(viagens_id) references viagens(id)
    on update cascade
    on delete cascade
)engine = innodb;

insert into conta(email, senha) values("admin", "admin");

insert into tipo_transporte(nome) values("Avião"), ("Carro"), ("Ônibus"), ("Trem"), ("Navio");
insert into continente(nome) values("América do Norte"), ("América do Sul"), ("Europa"), ("África"), ("Oceania"), ("Ásia");

drop view if exists preco_roteiro;
drop view if exists preco_ponto_turistico;

create view preco_roteiro as (
	select transporte.preco + hospedagem.preco
    'preco_roteiro', roteiro.id 'ID'
    from transporte, hospedagem, roteiro
    where transporte.roteiro_id = roteiro.id and hospedagem.roteiro_id = roteiro.id 
);

create view preco_ponto_turistico as (
	select sum(ponto_turistico.preco) 'preco_ponto_turistico', roteiro.id 'ID'
    from roteiro, ponto_turistico, roteiro_has_ponto_turistico
    where ponto_turistico_id = ponto_turistico.id and roteiro.id = roteiro_id
    group by roteiro.id
);

delimiter $$
create procedure removerRoteiro(in idRoteiro int)

begin
	delete restaurante
    from restaurante, roteiro_has_restaurante, roteiro
    where restaurante.id = restaurante_id and roteiro.id = roteiro_id and roteiro.id = idRoteiro;
    
    delete ponto_turistico
    from ponto_turistico, roteiro_has_ponto_turistico, roteiro
    where ponto_turistico.id = ponto_turistico_id and roteiro.id = roteiro_id and roteiro.id = idRoteiro;
    
    delete roteiro
    from roteiro
    where id = idRoteiro;
end $$
delimiter ;