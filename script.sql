/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     11/2/2018 8:16:04 PM                         */
/*==============================================================*/


drop table ACTIVIDAD_ECONOMICA;

drop table CALLE;

drop table CARGO_POLITICO;

drop table CIUDAD;

drop table CLIENTE;

drop table CONTACTO;

drop table CUENTA;

drop table DIRECCION;

drop table EGRESO_CLIENTE;

drop table ESTADO_CIVIL;

drop table GENERO;

drop table IDENTIFICACION;

drop table INGRESO_CLIENTE;

drop table NACIONALIDAD;

drop table NUMERO_TELEFONO;

drop table PAIS;

drop table PARENTESCO;

drop table PROFESION;

drop table PROFESION_CLIENTE;

drop table PROVINCIA;

drop table REFERENCIA;

drop table TIPO_ACTIVIDAD_ECONOMICA;

drop table TIPO_CARGO_POLITICO;

drop table TIPO_EGRESO;

drop table TIPO_IDENTIFICACION;

drop table TIPO_INGRESO;

drop table TIPO_PARENTESCO;

drop table TIPO_PERSONERIA;

drop table TIPO_REFERENCIA;

drop table TIPO_TELEFONO;

drop table USUARIO;

/*==============================================================*/
/* Table: ACTIVIDAD_ECONOMICA                                   */
/*==============================================================*/
create table ACTIVIDAD_ECONOMICA (
   COD_ACTIVIDAD_ECONOMICA NUMERIC(7)           not null,
   COD_TIPO_ACTIVIDAD_ECONOMICA NUMERIC(2)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   constraint PK_ACTIVIDAD_ECONOMICA primary key (COD_ACTIVIDAD_ECONOMICA)
);

/*==============================================================*/
/* Table: CALLE                                                 */
/*==============================================================*/
create table CALLE (
   COD_CALLE            NUMERIC(10)          not null,
   COD_CIUDAD           NUMERIC(6)           null,
   NOMBRE               VARCHAR(50)          not null,
   constraint PK_CALLE primary key (COD_CALLE)
);

/*==============================================================*/
/* Table: CARGO_POLITICO                                        */
/*==============================================================*/
create table CARGO_POLITICO (
   COD_CARGO_POLITICO   NUMERIC(5)           not null,
   COD_TIPO_CARGO_POLITICO NUMERIC(2)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   FECHA_INICIO         DATE                 not null,
   FECHA_FIN            DATE                 not null,
   constraint PK_CARGO_POLITICO primary key (COD_CARGO_POLITICO)
);

/*==============================================================*/
/* Table: CIUDAD                                                */
/*==============================================================*/
create table CIUDAD (
   COD_CIUDAD           NUMERIC(6)           not null,
   COD_PAIS             NUMERIC(3)           not null,
   COD_PROVINCIA        NUMERIC(5)           null,
   NOMBRE               VARCHAR(50)          not null,
   constraint PK_CIUDAD primary key (COD_CIUDAD)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   COD_CLIENTE          NUMERIC(8)           not null,
   COD__DIRECCION       NUMERIC(8)           null,
   COD_ESTADO_CIVIL     NUMERIC(1)           null,
   COD_GENERO           NUMERIC(1)           null,
   COD_TIPO_PERSONERIA  NUMERIC(2)           not null,
   PAIS_NACIMIENTO      NUMERIC(3)           null,
   NOMBRES              VARCHAR(100)         not null,
   APELLIDOS            VARCHAR(100)         not null,
   FECHA_NACIMIENTO     DATE                 null,
   FECHA_REGISTRO       DATE                 not null,
   HORA_REGISTRO        TIME                 not null,
   constraint PK_CLIENTE primary key (COD_CLIENTE)
);

/*==============================================================*/
/* Table: CONTACTO                                              */
/*==============================================================*/
create table CONTACTO (
   COD_CONTACTO         NUMERIC(10)          not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   CLI_COD_CLIENTE      NUMERIC(8)           not null,
   constraint PK_CONTACTO primary key (COD_CONTACTO)
);

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   COD_CUENTA           NUMERIC(10)          not null,
   COD_CLIENTE          NUMERIC(8)           null,
   ACTIVA               BOOL                 not null,
   constraint PK_CUENTA primary key (COD_CUENTA)
);

/*==============================================================*/
/* Table: DIRECCION                                             */
/*==============================================================*/
create table DIRECCION (
   COD_DIRECCION        NUMERIC(8)           not null,
   COD_CALLE            NUMERIC(10)          not null,
   COD_CALLE_TRANS      NUMERIC(10)          null,
   NUMERO               NUMERIC(4)           null,
   REFERENCIA           VARCHAR(100)         null,
   constraint PK_DIRECCION primary key (COD_DIRECCION)
);

/*==============================================================*/
/* Table: EGRESO_CLIENTE                                        */
/*==============================================================*/
create table EGRESO_CLIENTE (
   COD_EGRESO_CLIENTE   NUMERIC(10)          not null,
   COD_TIPO_EGRESO      NUMERIC(2)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   VALOR                NUMERIC(9)           not null,
   constraint PK_EGRESO_CLIENTE primary key (COD_EGRESO_CLIENTE)
);

/*==============================================================*/
/* Table: ESTADO_CIVIL                                          */
/*==============================================================*/
create table ESTADO_CIVIL (
   COD_ESTADO_CIVIL     NUMERIC(1)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_ESTADO_CIVIL primary key (COD_ESTADO_CIVIL)
);

/*==============================================================*/
/* Table: GENERO                                                */
/*==============================================================*/
create table GENERO (
   COD_GENERO           NUMERIC(1)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_GENERO primary key (COD_GENERO)
);

/*==============================================================*/
/* Table: IDENTIFICACION                                        */
/*==============================================================*/
create table IDENTIFICACION (
   COD_IDENTIFICACION   NUMERIC(9)           not null,
   COD_TIPO_IDENTIFICACION NUMERIC(1)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   COD_PAIS             NUMERIC(3)           not null,
   NUMERO_IDENTIFICACION NUMERIC(15)          not null,
   constraint PK_IDENTIFICACION primary key (COD_IDENTIFICACION)
);

/*==============================================================*/
/* Table: INGRESO_CLIENTE                                       */
/*==============================================================*/
create table INGRESO_CLIENTE (
   COD_INGRESO_CLIENTE  NUMERIC(10)          not null,
   COD_TIPO_INGRESO     NUMERIC(2)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   VALOR                NUMERIC(9)           not null,
   constraint PK_INGRESO_CLIENTE primary key (COD_INGRESO_CLIENTE)
);

/*==============================================================*/
/* Table: NACIONALIDAD                                          */
/*==============================================================*/
create table NACIONALIDAD (
   COD_NACIONALIDAD     NUMERIC(8)           not null,
   COD_PAIS             NUMERIC(3)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   constraint PK_NACIONALIDAD primary key (COD_NACIONALIDAD)
);

/*==============================================================*/
/* Table: NUMERO_TELEFONO                                       */
/*==============================================================*/
create table NUMERO_TELEFONO (
   COD_NUMERO_TELEFONO  NUMERIC(10)          not null,
   COD_TIPO_TELEFONO    NUMERIC(2)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   NUMERO               VARCHAR(15)          not null,
   constraint PK_NUMERO_TELEFONO primary key (COD_NUMERO_TELEFONO)
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS (
   COD_PAIS             NUMERIC(3)           not null,
   NOMBRE               VARCHAR(100)         not null,
   constraint PK_PAIS primary key (COD_PAIS)
);

/*==============================================================*/
/* Table: PARENTESCO                                            */
/*==============================================================*/
create table PARENTESCO (
   COD_PARENTESCO       NUMERIC(9)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   CLI_COD_CLIENTE      NUMERIC(8)           not null,
   COD_TIPO_PARENTESCO  NUMERIC(2)           not null,
   constraint PK_PARENTESCO primary key (COD_PARENTESCO)
);

/*==============================================================*/
/* Table: PROFESION                                             */
/*==============================================================*/
create table PROFESION (
   COD_PROFESION        NUMERIC(3)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_PROFESION primary key (COD_PROFESION)
);

/*==============================================================*/
/* Table: PROFESION_CLIENTE                                     */
/*==============================================================*/
create table PROFESION_CLIENTE (
   COD_PROFESION_CLIENTE NUMERIC(8)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   COD_PROFESION        NUMERIC(3)           not null,
   constraint PK_PROFESION_CLIENTE primary key (COD_PROFESION_CLIENTE)
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA (
   COD_PROVINCIA        NUMERIC(5)           not null,
   NOMBRE               VARCHAR(25)          not null,
   constraint PK_PROVINCIA primary key (COD_PROVINCIA)
);

/*==============================================================*/
/* Table: REFERENCIA                                            */
/*==============================================================*/
create table REFERENCIA (
   COD_REFERENCIA       NUMERIC(10)          not null,
   COD_TIPO_REFERENCIA  NUMERIC(9)           not null,
   COD_CLIENTE          NUMERIC(8)           not null,
   CLI_COD_CLIENTE      NUMERIC(8)           not null,
   constraint PK_REFERENCIA primary key (COD_REFERENCIA)
);

/*==============================================================*/
/* Table: TIPO_ACTIVIDAD_ECONOMICA                              */
/*==============================================================*/
create table TIPO_ACTIVIDAD_ECONOMICA (
   COD_TIPO_ACTIVIDAD_ECONOMICA NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_TIPO_ACTIVIDAD_ECONOMICA primary key (COD_TIPO_ACTIVIDAD_ECONOMICA)
);

/*==============================================================*/
/* Table: TIPO_CARGO_POLITICO                                   */
/*==============================================================*/
create table TIPO_CARGO_POLITICO (
   COD_TIPO_CARGO_POLITICO NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(50)          not null,
   constraint PK_TIPO_CARGO_POLITICO primary key (COD_TIPO_CARGO_POLITICO)
);

/*==============================================================*/
/* Table: TIPO_EGRESO                                           */
/*==============================================================*/
create table TIPO_EGRESO (
   COD_TIPO_EGRESO      NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(100)         not null,
   constraint PK_TIPO_EGRESO primary key (COD_TIPO_EGRESO)
);

/*==============================================================*/
/* Table: TIPO_IDENTIFICACION                                   */
/*==============================================================*/
create table TIPO_IDENTIFICACION (
   COD_TIPO_IDENTIFICACION NUMERIC(1)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_TIPO_IDENTIFICACION primary key (COD_TIPO_IDENTIFICACION)
);

/*==============================================================*/
/* Table: TIPO_INGRESO                                          */
/*==============================================================*/
create table TIPO_INGRESO (
   COD_TIPO_INGRESO     NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(100)         not null,
   constraint PK_TIPO_INGRESO primary key (COD_TIPO_INGRESO)
);

/*==============================================================*/
/* Table: TIPO_PARENTESCO                                       */
/*==============================================================*/
create table TIPO_PARENTESCO (
   COD_TIPO_PARENTESCO  NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_TIPO_PARENTESCO primary key (COD_TIPO_PARENTESCO)
);

/*==============================================================*/
/* Table: TIPO_PERSONERIA                                       */
/*==============================================================*/
create table TIPO_PERSONERIA (
   COD_TIPO_PERSONERIA  NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(25)          not null,
   constraint PK_TIPO_PERSONERIA primary key (COD_TIPO_PERSONERIA)
);

/*==============================================================*/
/* Table: TIPO_REFERENCIA                                       */
/*==============================================================*/
create table TIPO_REFERENCIA (
   COD_TIPO_REFERENCIA  NUMERIC(9)           not null,
   DESCRIPTION          VARCHAR(50)          not null,
   constraint PK_TIPO_REFERENCIA primary key (COD_TIPO_REFERENCIA)
);

/*==============================================================*/
/* Table: TIPO_TELEFONO                                         */
/*==============================================================*/
create table TIPO_TELEFONO (
   COD_TIPO_TELEFONO    NUMERIC(2)           not null,
   DESCRIPCION          VARCHAR(50)          not null,
   constraint PK_TIPO_TELEFONO primary key (COD_TIPO_TELEFONO)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   COD_USUARIO          INT4                 not null,
   NOMBRE               VARCHAR(20)          not null,
   CLAVE                VARCHAR(100)         not null,
   CORREO               VARCHAR(128)         not null,
   constraint PK_USUARIO primary key (COD_USUARIO)
);

alter table ACTIVIDAD_ECONOMICA
   add constraint FK_ACTIVIDA_REFERENCE_TIPO_ACT foreign key (COD_TIPO_ACTIVIDAD_ECONOMICA)
      references TIPO_ACTIVIDAD_ECONOMICA (COD_TIPO_ACTIVIDAD_ECONOMICA)
      on delete restrict on update restrict;

alter table ACTIVIDAD_ECONOMICA
   add constraint FK_ACTIVIDA_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CALLE
   add constraint FK_CALLE_REFERENCE_CIUDAD foreign key (COD_CIUDAD)
      references CIUDAD (COD_CIUDAD)
      on delete restrict on update restrict;

alter table CARGO_POLITICO
   add constraint FK_CARGO_PO_REFERENCE_TIPO_CAR foreign key (COD_TIPO_CARGO_POLITICO)
      references TIPO_CARGO_POLITICO (COD_TIPO_CARGO_POLITICO)
      on delete restrict on update restrict;

alter table CARGO_POLITICO
   add constraint FK_CARGO_PO_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CIUDAD
   add constraint FK_CIUDAD_REFERENCE_PAIS foreign key (COD_PAIS)
      references PAIS (COD_PAIS)
      on delete restrict on update restrict;

alter table CIUDAD
   add constraint FK_CIUDAD_REFERENCE_PROVINCI foreign key (COD_PROVINCIA)
      references PROVINCIA (COD_PROVINCIA)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_TIPO_PER foreign key (COD_TIPO_PERSONERIA)
      references TIPO_PERSONERIA (COD_TIPO_PERSONERIA)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_PAIS foreign key (PAIS_NACIMIENTO)
      references PAIS (COD_PAIS)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_DIRECCIO foreign key (COD__DIRECCION)
      references DIRECCION (COD_DIRECCION)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_ESTADO_C foreign key (COD_ESTADO_CIVIL)
      references ESTADO_CIVIL (COD_ESTADO_CIVIL)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_GENERO foreign key (COD_GENERO)
      references GENERO (COD_GENERO)
      on delete restrict on update restrict;

alter table CONTACTO
   add constraint FK_CONTACTO_REFERENCE_CLIENTE2 foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CONTACTO
   add constraint FK_CONTACTO_REFERENCE_CLIENTE foreign key (CLI_COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CUENTA
   add constraint FK_CUENTA_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_REFERENCE_CALLE2 foreign key (COD_CALLE)
      references CALLE (COD_CALLE)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_REFERENCE_CALLE foreign key (COD_CALLE_TRANS)
      references CALLE (COD_CALLE)
      on delete restrict on update restrict;

alter table EGRESO_CLIENTE
   add constraint FK_EGRESO_C_REFERENCE_TIPO_EGR foreign key (COD_TIPO_EGRESO)
      references TIPO_EGRESO (COD_TIPO_EGRESO)
      on delete restrict on update restrict;

alter table EGRESO_CLIENTE
   add constraint FK_EGRESO_C_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table IDENTIFICACION
   add constraint FK_IDENTIFI_REFERENCE_TIPO_IDE foreign key (COD_TIPO_IDENTIFICACION)
      references TIPO_IDENTIFICACION (COD_TIPO_IDENTIFICACION)
      on delete restrict on update restrict;

alter table IDENTIFICACION
   add constraint FK_IDENTIFI_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table IDENTIFICACION
   add constraint FK_IDENTIFI_REFERENCE_PAIS foreign key (COD_PAIS)
      references PAIS (COD_PAIS)
      on delete restrict on update restrict;

alter table INGRESO_CLIENTE
   add constraint FK_INGRESO__REFERENCE_TIPO_ING foreign key (COD_TIPO_INGRESO)
      references TIPO_INGRESO (COD_TIPO_INGRESO)
      on delete restrict on update restrict;

alter table INGRESO_CLIENTE
   add constraint FK_INGRESO__REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table NACIONALIDAD
   add constraint FK_NACIONAL_REFERENCE_PAIS foreign key (COD_PAIS)
      references PAIS (COD_PAIS)
      on delete restrict on update restrict;

alter table NACIONALIDAD
   add constraint FK_NACIONAL_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table NUMERO_TELEFONO
   add constraint FK_NUMERO_T_REFERENCE_TIPO_TEL foreign key (COD_TIPO_TELEFONO)
      references TIPO_TELEFONO (COD_TIPO_TELEFONO)
      on delete restrict on update restrict;

alter table NUMERO_TELEFONO
   add constraint FK_NUMERO_T_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table PARENTESCO
   add constraint FK_PARENTES_REFERENCE_CLIENTE2 foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table PARENTESCO
   add constraint FK_PARENTES_REFERENCE_CLIENTE foreign key (CLI_COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table PARENTESCO
   add constraint FK_PARENTES_REFERENCE_TIPO_PAR foreign key (COD_TIPO_PARENTESCO)
      references TIPO_PARENTESCO (COD_TIPO_PARENTESCO)
      on delete restrict on update restrict;

alter table PROFESION_CLIENTE
   add constraint FK_PROFESIO_REFERENCE_CLIENTE foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table PROFESION_CLIENTE
   add constraint FK_PROFESIO_REFERENCE_PROFESIO foreign key (COD_PROFESION)
      references PROFESION (COD_PROFESION)
      on delete restrict on update restrict;

alter table REFERENCIA
   add constraint FK_REFERENC_REFERENCE_TIPO_REF foreign key (COD_TIPO_REFERENCIA)
      references TIPO_REFERENCIA (COD_TIPO_REFERENCIA)
      on delete restrict on update restrict;

alter table REFERENCIA
   add constraint FK_REFERENC_REFERENCE_CLIENTE2 foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table REFERENCIA
   add constraint FK_REFERENC_REFERENCE_CLIENTE foreign key (CLI_COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

