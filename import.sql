drop table usuario;
drop table anotacion;
drop table especialidades;
drop table especialidadessolicitud;
drop table notificacion;
drop table solicitud;
drop table solicitud_form;
drop table token;
insert into usuario(email, dni, cdi, mcde, name, password, surname, especialidades) values('admin@cde.upm.es', '0000000', '', TRUE,'Admin', '0d6be69b264717f2dd33652e212b173104b4a647b7c11ae72e9885f11cd312fb', '', '');